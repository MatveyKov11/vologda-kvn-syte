package com.kvn_syte.server.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kvn_syte.server.entities.User;
import com.kvn_syte.server.repos.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository r){
        this.repo = r;
    }
    
    @GetMapping("/all")
    public ArrayList<User> getAll() {
        return repo.getAll();
    }
}
