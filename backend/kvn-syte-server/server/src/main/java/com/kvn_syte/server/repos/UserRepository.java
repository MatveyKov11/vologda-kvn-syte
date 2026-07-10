package com.kvn_syte.server.repos;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.kvn_syte.server.entities.User;
import com.kvn_syte.server.entities.User.UserType;

@Repository
public class UserRepository {
    public ArrayList<User> getAll() {
        ArrayList<User> a = new ArrayList<>();
        a.add(new User(0L, "123", "POST", UserType.Admin, false, new Date()));
        a.add(new User(0L, "123", "POST", UserType.Admin, false, new Date()));
        a.add(new User(0L, "123", "POST", UserType.Admin, false, new Date()));
        return a;
    }
}
