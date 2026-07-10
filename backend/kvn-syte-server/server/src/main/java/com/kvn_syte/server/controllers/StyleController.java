package com.kvn_syte.server.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kvn_syte.server.entities.Style;

@RestController
@RequestMapping("/api/styles")
public class StyleController {
    
    @GetMapping("/all")
    public ArrayList<Style> getAll() {
        Style a = new Style();
        return a.testData();
    }
}
