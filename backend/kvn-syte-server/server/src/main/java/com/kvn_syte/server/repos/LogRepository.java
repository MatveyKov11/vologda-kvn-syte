package com.kvn_syte.server.repos;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.kvn_syte.server.entities.Log;

@Repository
public class LogRepository {
    public ArrayList<Log> getAll(){
        Log a = new Log();
        return a.testData();
    }
}
