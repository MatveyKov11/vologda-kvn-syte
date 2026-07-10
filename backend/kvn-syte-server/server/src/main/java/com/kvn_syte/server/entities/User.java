package com.kvn_syte.server.entities;

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
}
