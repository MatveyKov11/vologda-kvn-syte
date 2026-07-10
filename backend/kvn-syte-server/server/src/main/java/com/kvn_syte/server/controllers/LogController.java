package com.kvn_syte.server.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kvn_syte.server.entities.Log;
import com.kvn_syte.server.repos.LogRepository;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    private LogRepository repo;

    public LogController(LogRepository r){
        this.repo = r;
    }
    
    @GetMapping("/all")
    public ArrayList<Log> getAll() {

        return repo.getAll();
    }
    
}
