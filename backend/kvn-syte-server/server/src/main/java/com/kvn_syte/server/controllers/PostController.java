package com.kvn_syte.server.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kvn_syte.server.entities.Post;
import com.kvn_syte.server.repos.PostRepository;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository repo;

    public PostController(PostRepository r){
        this.repo = r;
    }
    
    @GetMapping("/all")
    public ArrayList<Post> getAll() {
        return repo.getAll();
    }
    
}
