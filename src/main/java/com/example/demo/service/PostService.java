package com.example.demo.service;

import com.example.demo.client.ForeignDataSourceClient;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PostService {

    @Autowired
    private ForeignDataSourceClient dataSourceClient;


    /**
     *
     * 1. sdf
     * 2. medium -> use cache library, redis, hazlecast
     * 3. large, require accurate -> direct
     * 500 items, 154 KB
     *
     *  speed cache vs. direct
     *  cache (ms): 459, 353, 242, 275, 380
     *  direct (ms): 10,040, 10,640, 9,710, 12,520, 9,140
     */
    public List<Post> getPosts() {
        List<Comment> commentsCache = dataSourceClient.getComments();
        return dataSourceClient.getPosts().stream().peek(post -> {
            post.setComments(commentsCache.stream().filter(comment -> comment.getPostId() == post.getId())
                    .collect(Collectors.toList()));
//            post.setComments(dataSourceClient.getCommentsByPostId(post.getId()));
        }).collect(Collectors.toList());



    }
}
