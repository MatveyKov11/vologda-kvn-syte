package com.kvn_syte.server.entities;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Block {
    Long id;
    Long postId;

    Long position;
    ArrayList<String> data;
    String type;
    String feature;
}
