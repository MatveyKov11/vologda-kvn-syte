package com.kvn_syte.server.repos;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.kvn_syte.server.entities.Style;

@Repository
public class StyleRepository {
    public ArrayList<Style> getAll(){
        Style a = new Style();
        return a.testData();
    }
}
