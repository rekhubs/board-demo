package com.example.demo.client;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "foreignDataSource", url = "https://jsonplaceholder.typicode.com/")
public interface ForeignDataSourceClient {

    @GetMapping(value = "/posts")
    List<Post> getPosts();

    @GetMapping(value = "/posts/{id}/comments")
    List<Comment> getCommentsByPostId(@PathVariable("id") long id);

    @GetMapping(value = "/comments")
    List<Comment> getComments();

}
