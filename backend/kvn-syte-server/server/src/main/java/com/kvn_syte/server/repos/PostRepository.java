package com.kvn_syte.server.repos;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.kvn_syte.server.entities.Post;

@Repository
public class PostRepository {
    public ArrayList<Post> getAll() {
        Post a = new Post();
        return a.testData();
    }
    
}
