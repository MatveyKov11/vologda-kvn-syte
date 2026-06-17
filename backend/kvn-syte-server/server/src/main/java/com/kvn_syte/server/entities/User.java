package com.kvn_syte.server.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

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
