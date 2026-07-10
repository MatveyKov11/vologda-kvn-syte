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

    public ArrayList<Style> testData(){
        ArrayList<Color> b = new ArrayList<>();
        b.add(new Color(0L, 0L, 0L, 0L, 0L));
        b.add(new Color(1L, 0L, 255L, 255L, 255L));

        ArrayList<Color> c = new ArrayList<>();
        c.add(new Color(2L, 1L, 255L, 50L, 255L));
        c.add(new Color(3L, 1L, 255L, 255L, 255L));

        ArrayList<Style> a = new ArrayList<>();
        a.add(new Style(0L, "Чёрно-белый основной", b, RoleType.Main, true));
        a.add(new Style(1L, "Чёрно-белый тёмный", b, RoleType.Dark, true));
        a.add(new Style(2L, "Чёрно-белый для слабовидящих", b, RoleType.Blind, true));

        a.add(new Style(3L, "Пурпурно-белый основной", c, RoleType.Main, false));
        a.add(new Style(4L, "Пурпурно-белый тёмный", c, RoleType.Dark, false));
        a.add(new Style(5L, "Пурпурно-белый для слабовидящих", c, RoleType.Blind, false));
        return a;
    }
}
