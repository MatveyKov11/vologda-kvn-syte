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
    ArrayList<Content> contents;
    BlockType type;
    String feature;

    public enum BlockType{
        Text, List, Image, Table, Video;

        @Override
        public String toString(){
            return switch(this){
                case BlockType.Text -> "Text";
                case BlockType.Video -> "Video";
                case BlockType.Image -> "Image";
                case BlockType.List -> "List";
                case BlockType.Table -> "Table";
                default -> "???";
            };
        }
    }
}
