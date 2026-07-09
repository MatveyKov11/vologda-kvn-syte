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
    String role;
    boolean isBlocked;
    Date lastActionTime;
}
