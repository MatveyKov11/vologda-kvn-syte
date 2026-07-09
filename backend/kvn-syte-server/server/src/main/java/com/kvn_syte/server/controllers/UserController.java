package com.kvn_syte.server.controllers;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kvn_syte.server.entities.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @GetMapping("/all")
    public ArrayList<User> getAll() {
        ArrayList<User> a = new ArrayList<>();
        a.add(new User(0L, "123", "ADD", "POST", false, new Date()));
        a.add(new User(1L, "123", "ADD", "POST", false, new Date()));
        a.add(new User(2L, "123", "ADD", "POST", false, new Date()));
        return a;
    }
}
