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
    RoleType role;
    boolean isMain;

    public enum RoleType{
        None, Main, Dark, Blind;

        public String toString(){
            switch (this){
                case RoleType.Main:
                    return "Main";
                case RoleType.Dark:
                    return "Dark";
                case RoleType.Blind:
                    return "Blind";
                default:
                    return "---";
            }
        }
    }
}
