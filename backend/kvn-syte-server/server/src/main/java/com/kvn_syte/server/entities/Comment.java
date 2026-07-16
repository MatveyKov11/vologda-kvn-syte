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
    UserType user;
    String message;
    Date publishTime;

    public enum UserType{
        Anon, Admin, Editor;

        @Override
        public String toString(){
            return switch (this) {
                case UserType.Anon -> "Аноним";
                case UserType.Admin -> "Администратор";
                case UserType.Editor -> "Редактор";
                default -> "???";
            };
        }
    }
}