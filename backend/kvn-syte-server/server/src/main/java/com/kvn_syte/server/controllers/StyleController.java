package com.kvn_syte.server.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kvn_syte.server.entities.Style;
import com.kvn_syte.server.repos.StyleRepository;

@RestController
@RequestMapping("/api/styles")
public class StyleController {

    private final StyleRepository repo;

    public StyleController(StyleRepository r){
        this.repo = r;
    }
    
    @GetMapping("/all")
    public ArrayList<Style> getAll() {
        return repo.getAll();
    }
}
