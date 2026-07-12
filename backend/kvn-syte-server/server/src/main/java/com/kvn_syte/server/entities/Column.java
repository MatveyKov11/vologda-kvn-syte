package com.kvn_syte.server.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Column {
    Long id;
    Long tableId;

    Long position;
    String title;
    ValueType valueType;

    enum ValueType {
        Number, Text;

        @Override
        public String toString(){
            return switch (this){
                case ValueType.Number -> "Number";
                case ValueType.Text -> "Text";
                default -> "???";
            };
        }
    }
}
