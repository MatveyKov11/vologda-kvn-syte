package com.kvn_syte.server.repos;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.kvn_syte.server.entities.Log;
import com.kvn_syte.server.entities.Log.UserType;
import com.kvn_syte.server.entities.Log.ActionType;
import com.kvn_syte.server.entities.Log.ObjectType;

@Repository
public class LogRepository {
    public ArrayList<Log> getAll(){
        ArrayList<Log> a = new ArrayList<>();
        a.add(new Log(0L, 0L, UserType.Anon, ActionType.Add, 0L, ObjectType.Post, new Date()));
        a.add(new Log(1L, 0L, UserType.Anon, ActionType.Add, 0L, ObjectType.Post, new Date()));
        a.add(new Log(2L, 0L, UserType.Anon, ActionType.Add, 0L, ObjectType.Post, new Date()));
        return a;
    }
}
