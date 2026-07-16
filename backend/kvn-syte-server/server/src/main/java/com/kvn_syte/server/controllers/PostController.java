package com.kvn_syte.server.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kvn_syte.server.entities.Post;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    
    @GetMapping("/all")
    public ArrayList<Post> getAll() {
        Post a = new Post();

        return a.testData();
    }
    
}
