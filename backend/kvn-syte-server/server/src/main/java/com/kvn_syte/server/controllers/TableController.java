package com.kvn_syte.server.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kvn_syte.server.entities.Table;
import com.kvn_syte.server.repos.UserRepository;

@RestController
@RequestMapping("/api/tables")
public class TableController {
    
    @GetMapping("/all")
    public ArrayList<Table> getAll(){
        Table a = new Table();
        return a.testData();
    }
}
