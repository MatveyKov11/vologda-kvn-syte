package com.kvn_syte.server.entities;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Table {
    Long id;

    String title;
    TableType type;
    ArrayList<Column> columns;
    ArrayList<ArrayList<Cell>> cells;

    public enum TableType{
        Custom, Reward, Schedule, Team, Contest;

        @Override
        public String toString(){
            return switch (this) {
                case TableType.Contest -> "Contest";
                case TableType.Reward -> "Reward";
                case TableType.Schedule -> "Schedule";
                case TableType.Team -> "Team";
                case TableType.Custom -> "Custom";
                default -> "???";
            };
        }
    }
}
