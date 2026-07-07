package com.kvn_syte.server.repos;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.kvn_syte.server.entities.Log;

@Repository
public class LogRepository {
    public ArrayList<Log> getAll(){
        ArrayList<Log> a = new ArrayList<>();
        a.add(new Log(0L, 0L, "ADD", 0L, "POST"));
        a.add(new Log(0L, 0L, "ADD", 0L, "POST"));
        a.add(new Log(0L, 0L, "ADD", 0L, "POST"));
        return a;
    }
}
