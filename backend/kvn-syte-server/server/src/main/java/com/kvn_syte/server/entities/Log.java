package com.kvn_syte.server.entities;

import com.kvn_syte.server.entities.Log.ActionType;

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

        public String toString(){
            switch (this){
                case UserType.Anon:
                    return "Anon";
                case UserType.Admin:
                    return "Admin";
                case UserType.Editor:
                    return "Editor";
                default:
                    return "???";
            }
        }
    }

    public enum ActionType{
        Add, Change, Delete, Block;

        public String toString(){
            switch (this){
                case ActionType.Add:
                    return "Add";
                case ActionType.Change:
                    return "Change";
                case ActionType.Delete:
                    return "Delete";
                case ActionType.Block:
                    return "Block";
                default:
                    return "???";
            }
        }
    }

    public enum ObjectType{
        User, Table, Style, Post, Comment;

        public String toString(){
            switch (this){
                case ObjectType.User:
                    return "User";
                case ObjectType.Table:
                    return "Table";
                case ObjectType.Style:
                    return "Style";
                case ObjectType.Post:
                    return "Post";
                case ObjectType.Comment:
                    return "Comment";
                default:
                    return "???";
            }
        }
    }
}
