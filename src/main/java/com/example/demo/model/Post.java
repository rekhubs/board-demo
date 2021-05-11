package com.example.demo.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Post {
    private long id;
    private String title;
    private String body;
    private long userId;
    private List<Comment> comments = new ArrayList<>();
}
