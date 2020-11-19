package net.kiranatos.javarush.сore.lvl7;

/* Java Core,  7 уровень,  6 лекция 
Заметки для всех
Класс Note будет использоваться нитями. Поэтому сделай так, чтобы лист notes находился в общей памяти,
т.е не будет кэшироваться потоками в свою локальную область памяти. 

Old variant: package com.javarush.test.level17.lesson06.task01; */

import java.util.ArrayList;
import java.util.List;

/* Заметки для всех
Класс Note будет использоваться нитями.
Поэтому сделай так, чтобы лист notes находился в общей памяти */

public class Core7Lvl17Lesson06Task01 {
    public static class Note {

        public volatile List<String> notes = new ArrayList<String>();

        public void addNote(int index, String note) {
            System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
            notes.add(index, note);
            System.out.println("Уже добавлена заметка [" + note + "]");
        }

        public void removeNote(int index) {
            System.out.println("Сейчас будет удалена заметка с позиции " + index);
            String note = notes.remove(index);
            System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
        }
    }   
}