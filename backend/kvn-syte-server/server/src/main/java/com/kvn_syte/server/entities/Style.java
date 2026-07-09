package com.kvn_syte.server.entities;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Style {
    Long id;

    String title;
    ArrayList<Color> colors;
    String type;
    boolean isMain;
}
