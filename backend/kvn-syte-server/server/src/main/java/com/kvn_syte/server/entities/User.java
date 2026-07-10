package com.kvn_syte.server.entities;

import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Long id;

    String username;
    String password;
    UserType role;
    boolean isBlocked;
    Date lastActionTime;

    public enum UserType{
        Anon, Admin, Editor;

        public String toString(){
            switch (this){
                case UserType.Anon:
                    return "Anon";
                case UserType.Admin:
                    return "Admin";
                case UserType.Editor:
                    return "Editor";
                default:
                    return "???";
            }
        }
    }

    public ArrayList<User> testData(){
        ArrayList<User> a = new ArrayList<>();
        a.add(new User(0L, "admin", "1234", UserType.Admin, false, new Date()));
        a.add(new User(1L, "admin2", "1111", UserType.Admin, false, new Date()));
        a.add(new User(2L, "editor", "353535", UserType.Editor, true, new Date()));
        return a;
    }
}
