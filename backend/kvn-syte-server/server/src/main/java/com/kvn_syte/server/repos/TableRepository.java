package com.kvn_syte.server.repos;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.kvn_syte.server.entities.Table;

@Repository
public class TableRepository {
    public ArrayList<Table> getAll(){
        Table a = new Table();
        return a.testData();
    }
}
