package com.kvn_syte.server.entities;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.kvn_syte.server.entities.Column.ValueType;

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
        Custom, Reward, Schedule, Team, Contest, Result;

        @Override
        public String toString(){
            return switch (this) {
                case TableType.Contest -> "Contest";
                case TableType.Reward -> "Reward";
                case TableType.Schedule -> "Schedule";
                case TableType.Team -> "Team";
                case TableType.Result -> "Result";
                case TableType.Custom -> "Custom";
                default -> "???";
            };
        }
    }

    private ArrayList<Column> getColumn(TableType t){
        ArrayList<Column> c = new ArrayList<>();
        switch(t){
            case TableType.Team:
                c.add(new Column(0L, 0L, 1L, "Команда", ValueType.Text));
                c.add(new Column(0L, 0L, 2L, "Описание", ValueType.Text));
                break;
            case TableType.Contest:
                c.add(new Column(0L, 0L, 1L, "Конкурс", ValueType.Text));
                c.add(new Column(0L, 0L, 2L, "Описание", ValueType.Text));
                break;
            case TableType.Schedule:
                c.add(new Column(0L, 0L, 1L, "Игра", ValueType.Text));
                c.add(new Column(0L, 0L, 2L, "Дата", ValueType.Data));
                break;
            case TableType.Reward:
                c.add(new Column(0L, 0L, 1L, "Награда", ValueType.Text));
                c.add(new Column(0L, 0L, 2L, "Кому", ValueType.Text));
                break;
            default:
        }
        return c;
    }

    public ArrayList<Table> testData(){
        ArrayList<Table> a = new ArrayList<>();

        ArrayList<Column> c1 = getColumn(TableType.Team);
        ArrayList<Cell> r1_1 = new ArrayList<>();
        r1_1.add(new Cell(0L, 0L, 1L, 1L, "35 элемент"));
        r1_1.add(new Cell(0L, 0L, 2L, 1L, "---"));
        ArrayList<Cell> r2_1 = new ArrayList<>();
        r2_1.add(new Cell(0L, 0L, 1L, 2L, "Люди ФСИНем"));
        r2_1.add(new Cell(0L, 0L, 2L, 2L, "---"));
        ArrayList<Cell> r3_1 = new ArrayList<>();
        r3_1.add(new Cell(0L, 0L, 1L, 3L, "Мамины пирожочки"));
        r3_1.add(new Cell(0L, 0L, 2L, 3L, "---"));
        ArrayList<ArrayList<Cell>> r1 = new ArrayList<>();
        r1.add(r1_1);
        r1.add(r2_1);
        r1.add(r3_1);
        a.add(new Table(0L, "Команды, прошедшие в полуфинал", TableType.Team, c1, r1));

        ArrayList<Column> c2 = getColumn(TableType.Contest);
        ArrayList<Cell> r1_2 = new ArrayList<>();
        r1_2.add(new Cell(0L, 0L, 1L, 1L, "Визитка"));
        r1_2.add(new Cell(0L, 0L, 2L, 1L, "---"));
        ArrayList<Cell> r2_2 = new ArrayList<>();
        r2_2.add(new Cell(0L, 0L, 1L, 2L, "Разминка"));
        r2_2.add(new Cell(0L, 0L, 2L, 2L, "---"));
        ArrayList<Cell> r3_2 = new ArrayList<>();
        r3_2.add(new Cell(0L, 0L, 1L, 3L, "Капитанский конкурс"));
        r3_2.add(new Cell(0L, 0L, 2L, 3L, "---"));
        ArrayList<Cell> r4_2 = new ArrayList<>();
        r4_2.add(new Cell(0L, 0L, 1L, 4L, "Музыкальное домашнее задание"));
        r4_2.add(new Cell(0L, 0L, 2L, 4L, "---"));
        ArrayList<ArrayList<Cell>> r2 = new ArrayList<>();
        r2.add(r1_2);
        r2.add(r2_2);
        r2.add(r3_2);
        r2.add(r4_2);
        a.add(new Table(0L, "Конкурсы полуфинала", TableType.Contest, c2, r2));

        ArrayList<Column> c3 = getColumn(TableType.Schedule);
        ArrayList<Cell> r1_3 = new ArrayList<>();
        r1_3.add(new Cell(0L, 0L, 1L, 1L, "Кубок работающей молодёжи"));
        r1_3.add(new Cell(0L, 0L, 2L, 1L, "14.10.2026"));
        ArrayList<Cell> r2_3 = new ArrayList<>();
        r2_3.add(new Cell(0L, 0L, 1L, 2L, "Музыкальный фестиваль"));
        r2_3.add(new Cell(0L, 0L, 2L, 2L, "11.11.2026"));
        ArrayList<ArrayList<Cell>> r3 = new ArrayList<>();
        r3.add(r1_3);
        r3.add(r2_3);
        a.add(new Table(0L, "Расписание игр сезона", TableType.Schedule, c3, r3));

        ArrayList<Column> c4 = getColumn(TableType.Reward);
        ArrayList<Cell> r1_4 = new ArrayList<>();
        r1_4.add(new Cell(0L, 0L, 1L, 1L, "Лучшая мужская роль"));
        r1_4.add(new Cell(0L, 0L, 2L, 1L, "Симеон Калантаев из 'Люди ФСИНем'"));
        ArrayList<Cell> r2_4 = new ArrayList<>();
        r2_4.add(new Cell(0L, 0L, 1L, 2L, "Лучшая женская роль"));
        r2_4.add(new Cell(0L, 0L, 2L, 2L, "Александра Нивина из '35 элемент'"));
        ArrayList<ArrayList<Cell>> r4 = new ArrayList<>();
        r4.add(r1_4);
        r4.add(r2_4);
        a.add(new Table(0L, "Награды финала", TableType.Reward, c4, r4));

        ArrayList<Column> c5 = getColumn(TableType.Result);
        c5.add(new Column(0L, 0L, 1L, "Команда", ValueType.Text));
        c5.add(new Column(0L, 0L, 2L, "Визитка", ValueType.Number));
        c5.add(new Column(0L, 0L, 3L, "Разминка", ValueType.Number));
        c5.add(new Column(0L, 0L, 4L, "Домашка", ValueType.Number));
        c5.add(new Column(0L, 0L, 5L, "Итого", ValueType.Number));
        ArrayList<Cell> r1_5 = new ArrayList<>();
        r1_5.add(new Cell(0L, 0L, 1L, 1L, "35 Элемент"));
        r1_5.add(new Cell(0L, 0L, 2L, 1L, "5"));
        r1_5.add(new Cell(0L, 0L, 3L, 1L, "5"));
        r1_5.add(new Cell(0L, 0L, 4L, 1L, "5"));
        r1_5.add(new Cell(0L, 0L, 5L, 1L, "15"));
        ArrayList<Cell> r2_5 = new ArrayList<>();
        r2_5.add(new Cell(0L, 0L, 1L, 2L, "Нас теперь трое"));
        r2_5.add(new Cell(0L, 0L, 2L, 2L, "3"));
        r2_5.add(new Cell(0L, 0L, 3L, 2L, "3"));
        r2_5.add(new Cell(0L, 0L, 4L, 2L, "3"));
        r2_5.add(new Cell(0L, 0L, 5L, 2L, "9"));
        ArrayList<ArrayList<Cell>> r5 = new ArrayList<>();
        r5.add(r1_5);
        r5.add(r2_5);
        a.add(new Table(0L, "Результаты финала", TableType.Result, c5, r5));

        ArrayList<Column> c6 = getColumn(TableType.Result);
        c6.add(new Column(0L, 0L, 1L, "Предмет", ValueType.Text));
        c6.add(new Column(0L, 0L, 2L, "1-ая четверть", ValueType.Number));
        c6.add(new Column(0L, 0L, 3L, "2-ая четверть", ValueType.Number));
        c6.add(new Column(0L, 0L, 4L, "3-ая четверть", ValueType.Number));
        ArrayList<Cell> r1_6 = new ArrayList<>();
        r1_6.add(new Cell(0L, 0L, 1L, 1L, "Русский"));
        r1_6.add(new Cell(0L, 0L, 2L, 1L, "5"));
        r1_6.add(new Cell(0L, 0L, 3L, 1L, "5"));
        r1_6.add(new Cell(0L, 0L, 4L, 1L, "5"));
        ArrayList<Cell> r2_6 = new ArrayList<>();
        r2_6.add(new Cell(0L, 0L, 1L, 2L, "Литература"));
        r2_6.add(new Cell(0L, 0L, 2L, 2L, "3"));
        r2_6.add(new Cell(0L, 0L, 3L, 2L, "3"));
        r2_6.add(new Cell(0L, 0L, 4L, 2L, "3"));
        ArrayList<ArrayList<Cell>> r6 = new ArrayList<>();
        r6.add(r1_6);
        r6.add(r2_6);
        a.add(new Table(0L, "Оценки", TableType.Result, c6, r6));

        return a;
    }
}
