package com.kvn_syte.server.entities;

import java.util.ArrayList;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    Long id;

    String title;
    Date createdTime;
    ArrayList<Block> blocks;
    ArrayList<Comment> comments;
    boolean isClosedComments;
    Long likesCount;
}
