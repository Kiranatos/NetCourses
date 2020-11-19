package net.kiranatos.javarush.сore.lvl7;

/* Java Core,  7 уровень, 10 лекция
ApplicationContext
ApplicationContext будет доступен множеству нитей.
Сделать так, чтобы данные не терялись: подумай, какое ключевое слово необходимо поставить и где.

Old variant: package com.javarush.test.level17.lesson10.home07;
 */
import java.util.HashMap;
import java.util.Map;

public class Core7Lvl17Lesson10Task07 {
    public static void main(String[] args) {
        
    }
}

//это интерфейс-маркер
interface Bean { }

abstract class ApplicationContext<GenericsBean extends Bean> {
    private Map<String, GenericsBean> container = new HashMap<String, GenericsBean>();
    //Map<Name, some class implemented Bean interface>

    protected ApplicationContext() { parseAllClassesAndInterfaces(); }

    public synchronized GenericsBean getByName(String name) {  return container.get(name); }

    public synchronized GenericsBean removeByName(String name) {
        return container.remove(name);
    }

    protected abstract void parseAllClassesAndInterfaces();
}