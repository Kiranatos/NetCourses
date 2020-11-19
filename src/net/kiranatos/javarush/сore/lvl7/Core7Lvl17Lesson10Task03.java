package net.kiranatos.javarush.сore.lvl7;

/* Java Core,  7 уровень, 10 лекция
Аптека
Реализуй интерфейс Runnable в классах Apteka и Person. Все нити должны работать пока не isStopped. 
Логика для Apteka: drugsController должен сделать закупку случайного лекарства (getRandomDrug) в количестве 
(getRandomCount) и подождать 300 мс. Логика для Person: drugsController должен сделать продаж

Old variant: package com.javarush.test.level17.lesson10.home03;
 */

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

/* Аптека
Реализуй интерфейс Runnable в класах Apteka и Person.
Все нити должны работать пока не isStopped
Логика для Apteka: drugsController должен сделать закупку случайного лекарства (getRandomDrug) в количестве (getRandomCount) и подождать 300 мс
Логика для Person: drugsController должен сделать продажу случайного лекарства (getRandomDrug) в количестве (getRandomCount) и подождать 100 мс
Расставь synchronized там, где это необходимо */

public class Core7Lvl17Lesson10Task03 {
    public static DrugsController drugsController = new DrugsController();
    public static boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Thread apteka = new Thread(new Apteka());
        Thread man = new Thread(new Person(), "Мужчина");
        Thread woman = new Thread(new Person(), "Женщина");

        apteka.start();
        man.start();
        woman.start();

        Thread.sleep(1000);
        isStopped = true;
    }

    public static class Apteka implements Runnable {
        @Override
        public void run() {
            while (!isStopped) {
                //getRandomDrug();
                drugsController.buy(getRandomDrug(), getRandomCount());
                waitAMoment();
                waitAMoment();
                waitAMoment();
            }
        }
    }

    public static class Person implements Runnable {
        @Override
        public void run() {
            while (!isStopped) {
                //getRandomDrug();
                drugsController.sell(getRandomDrug(), getRandomCount());
                waitAMoment();
            }
        }
    }

    public static int getRandomCount() { return (int) (Math.random() * 3) + 1; }

    public static Drug getRandomDrug() {
        int index = (int) ((Math.random() * 1000) % (drugsController.allDrugs.size()));
        List<Drug> drugs = new ArrayList<Drug>(drugsController.allDrugs.keySet());
        return drugs.get(index);
    }

    private static void waitAMoment() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) { }
    }        
} // end of Core7Lvl17Lesson10Task03 class


class DrugsController {
    public static Map<Drug, Integer> allDrugs = new HashMap<Drug, Integer>();   // <Лекарство, Количество>

    static {
        Drug panadol = new Drug();
        panadol.setName("Панадол");
        allDrugs.put(panadol, 5);

        Drug analgin = new Drug();
        analgin.setName("Анальгин");
        allDrugs.put(analgin, 18);

        Drug placebo = new Drug();
        placebo.setName("Плацебо");
        allDrugs.put(placebo, 1);
    }

    public synchronized void sell(Drug drug, int count) {
        String name = Thread.currentThread().getName();
        if (!allDrugs.containsKey(drug)) {
            System.out.println("Нет в наличии");
        }
        Integer currentCount = allDrugs.get(drug);
        if (currentCount < count) {
            System.out.println(String.format("%s хочет %s %d шт. В наличии - %d", name, drug.getName(), count, currentCount));
        } else {
            allDrugs.put(drug, (currentCount - count));
            System.out.println(String.format("%s купил(а) %s %d шт. Осталось - %d", name, drug.getName(), count, (currentCount - count)));
        }
    }

    public synchronized void buy(Drug drug, int count) {
        System.out.println("Закупка " + drug.getName() + " " + count);
        if (!allDrugs.containsKey(drug)) {
            allDrugs.put(drug, 0);
        }
        Integer currentCount = allDrugs.get(drug);
        allDrugs.put(drug, (currentCount + count));
    }
} // end of DrugsController class

class Drug {
    private String name;
    private String description;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}