package com.kvn_syte.server.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kvn_syte.server.entities.Log;


@RestController
@RequestMapping("/api/logs")
public class LogController {
    
    @GetMapping("/all")
    public ArrayList<Log> getAll() {
        ArrayList<Log> a = new ArrayList<>();
        return a;
    }
    
}
