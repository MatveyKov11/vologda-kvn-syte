package com.kvn_syte.server.repos;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.kvn_syte.server.entities.User;

@Repository
public class UserRepository {
    public ArrayList<User> getAll() {
        ArrayList<User> a = new ArrayList<>();
        a.add(new User(0L, "123", "ADD", "POST", false, new Date()));
        a.add(new User(1L, "123", "ADD", "POST", false, new Date()));
        a.add(new User(2L, "123", "ADD", "POST", false, new Date()));
        return a;
    }
}
