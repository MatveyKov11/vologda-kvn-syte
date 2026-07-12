package com.kvn_syte.server.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kvn_syte.server.entities.Table;
import com.kvn_syte.server.repos.TableRepository;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    private final TableRepository repo;

    public TableController(TableRepository r){
        this.repo = r;
    }
    
    @GetMapping("/all")
    public ArrayList<Table> getAll(){
        return repo.getAll();
    }
}
