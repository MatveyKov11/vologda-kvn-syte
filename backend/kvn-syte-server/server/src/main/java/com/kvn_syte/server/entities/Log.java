package com.kvn_syte.server.entities;

import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    Long id;

    Long userId;
    UserType user;
    ActionType action;
    Long objectId;
    ObjectType object;
    Date time;

    public enum UserType{
        Anon, Admin, Editor;

        @Override
        public String toString(){
            return switch (this) {
                case UserType.Anon -> "Anon";
                case UserType.Admin -> "Admin";
                case UserType.Editor -> "Editor";
                default -> "???";
            };
        }
    }

    public enum ActionType{
        Add, Change, Delete, Block;

        @Override
        public String toString(){
            return switch (this) {
                case ActionType.Add -> "Add";
                case ActionType.Change -> "Change";
                case ActionType.Delete -> "Delete";
                case ActionType.Block -> "Block";
                default -> "???";
            };
        }
    }

    public enum ObjectType{
        User, Table, Style, Post, Comment;

        @Override
        public String toString(){
            return switch (this) {
                case ObjectType.User -> "User";
                case ObjectType.Table -> "Table";
                case ObjectType.Style -> "Style";
                case ObjectType.Post -> "Post";
                case ObjectType.Comment -> "Comment";
                default -> "???";
            };
        }
    }

    public ArrayList<Log> testData(){
        ArrayList<Log> a = new ArrayList<>();
        a.add(new Log( 0L, 1L, UserType.Admin, ActionType.Add, 4L, ObjectType.User, new Date()));
        a.add(new Log( 1L, 1L, UserType.Admin, ActionType.Block, 4L, ObjectType.User, new Date()));
        a.add(new Log( 2L, 1L, UserType.Admin, ActionType.Delete, 4L, ObjectType.User, new Date()));
        a.add(new Log( 3L, 1L, UserType.Admin, ActionType.Add, 2L, ObjectType.User, new Date()));

        a.add(new Log( 4L, 2L, UserType.Admin, ActionType.Add, 1L, ObjectType.Table, new Date()));
        a.add(new Log( 5L, 1L, UserType.Admin, ActionType.Add, 2L, ObjectType.Table, new Date()));
        a.add(new Log( 6L, 2L, UserType.Admin, ActionType.Change, 2L, ObjectType.Table, new Date()));
        a.add(new Log( 7L, 2L, UserType.Admin, ActionType.Delete, 2L, ObjectType.Table, new Date()));

        a.add(new Log( 8L, 1L, UserType.Admin, ActionType.Add, 1L, ObjectType.Post, new Date()));
        a.add(new Log( 9L, 2L, UserType.Admin, ActionType.Add, 2L, ObjectType.Post, new Date()));
        a.add(new Log(10L, 1L, UserType.Admin, ActionType.Change, 2L, ObjectType.Post, new Date()));
        a.add(new Log(11L, 1L, UserType.Admin, ActionType.Add, 2L, ObjectType.Post, new Date()));

        a.add(new Log(12L, -1L, UserType.Anon, ActionType.Add, 1L, ObjectType.Comment, new Date()));
        a.add(new Log(13L, -1L, UserType.Anon, ActionType.Add, 2L, ObjectType.Comment, new Date()));
        a.add(new Log(14L, 2L, UserType.Admin, ActionType.Delete, 1L, ObjectType.Comment, new Date()));

        a.add(new Log(15L, 1L, UserType.Admin, ActionType.Add, 1L, ObjectType.Style, new Date()));
        a.add(new Log(16L, 1L, UserType.Admin, ActionType.Add, 2L, ObjectType.Style, new Date()));
        a.add(new Log(17L, 2L, UserType.Admin, ActionType.Change, 2L, ObjectType.Style, new Date()));
        a.add(new Log(18L, 2L, UserType.Admin, ActionType.Delete, 2L, ObjectType.Style, new Date()));
        return a;
    }
}
