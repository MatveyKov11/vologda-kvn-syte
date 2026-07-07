package com.kvn_syte.server.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    Long id;
    Long postId;

    Long userId;
    String username;
    String message;
    Date publishTime;
}