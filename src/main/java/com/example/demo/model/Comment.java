package com.example.demo.model;

import lombok.Data;

@Data
public class Comment {
    private long id;
    private String name;
    private String body;
    private String email;
    private long postId;
}
