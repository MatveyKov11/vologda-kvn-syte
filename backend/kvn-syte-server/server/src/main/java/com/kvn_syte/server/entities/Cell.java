package com.kvn_syte.server.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cell {
    Long id;
    Long tableId;

    Long column;
    Long row;
    String data;
}
