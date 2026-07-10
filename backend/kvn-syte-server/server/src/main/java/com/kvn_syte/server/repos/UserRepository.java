package com.kvn_syte.server.repos;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.kvn_syte.server.entities.User;

@Repository
public class UserRepository {
    public ArrayList<User> getAll() {
        User a = new User();
        return a.testData();
    }
}
