package com.example.demo.controller;

import com.example.demo.client.ForeignDataSourceClient;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1")
@RestController
public class PostController {

    @Autowired private ForeignDataSourceClient foreignDataSourceClient;
    @Autowired private PostService postService;

    @GetMapping("/posts")
    public ResponseEntity getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }

    @GetMapping("/raw/posts")
    public ResponseEntity getRawPosts() {
        return ResponseEntity.ok(foreignDataSourceClient.getPosts());
    }

    @GetMapping("/raw/comments")
    public ResponseEntity getRawComments() {
        return ResponseEntity.ok(foreignDataSourceClient.getComments());
    }
}
