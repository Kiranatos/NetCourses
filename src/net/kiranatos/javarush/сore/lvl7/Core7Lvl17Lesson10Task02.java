package net.kiranatos.javarush.сore.lvl7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Java Core,  7 уровень, 10 лекция
Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach. Пляжи(Beach) будут использоваться нитями, 
поэтому позаботьтесь, чтобы все методы были синхронизированы. 
Реализовать метод compareTo так, чтобы он при сравнении двух пляжей выдавал число, 
которое показывает что первый пляж лучше(позитивное число)

Old variant: package com.javarush.test.level17.lesson10.home02;
 */

public class Core7Lvl17Lesson10Task02 {
    
    public static class Beach implements Comparable<Beach> {
        private String name;      //название
        private float distance;   //расстояние
        private int quality;    //качество
        
        public Beach(String name, float distance, int quality) {
            this.name = name;
            this.distance = distance;
            this.quality = quality;
        }
        
        public synchronized String getName() { return name; }
        public synchronized void setName(String name) { this.name = name; }
        public synchronized float getDistance() { return distance; }
        public synchronized void setDistance(float distance) { this.distance = distance; }
        public synchronized int getQuality() { return quality; }
        public synchronized void setQuality(int quality) { this.quality = quality; }
        
        @Override
        public int compareTo(Beach obj) {
            int distanceParam = (int) (distance - obj.getDistance());
            int qualityParam = quality - obj.getQuality();
            
            int rop = 10000 * name.compareTo(obj.getName()) + 100 * distanceParam + qualityParam;
            
            System.out.println("obj=" + obj.getDistance() + " " + obj.getQuality() + " " + obj.getName());
            System.out.println("this=" + distance + " " + quality + " " + name);
            System.out.println("distanceParam = distance - obj.getDistance=" + distanceParam);
            System.out.println("qualityParam = quality - obj.getQuality=" + qualityParam);
            System.out.println("10000*name.compareTo(obj.getName())+100*distanceParam+qualityParam=" + rop);
            return rop;
        }

        @Override
        public String toString() {
            return "Beach{" + "name=" + name + ", \tdistance=" + distance + ", \tquality=" + quality + '}';
        }        
    }
    
    public static void main(String[] args) {
        List<Beach> b = new ArrayList<Beach>();
        b.add(new Beach("Alysta", 100, 3));
        b.add(new Beach("Fastiv", 50, 4));
        b.add(new Beach("York", 150, 30));
        b.add(new Beach("Kyiv", 300, 13));
        b.add(new Beach("Warsawa", 100, 3));
        b.add(new Beach("Stinky", 10, 500));
        b.add(new Beach("Phuket", 111, 11));
        b.add(new Beach("Malta", 100, 77));
        
        for (Beach bo: b) System.out.println(bo);
        System.out.println("\n");
        
        Collections.sort(b);
        
        System.out.println("\n");
        
        for (Beach bo: b) System.out.println(bo);
    }
}
//это так называемые повышающие множители
//в задаче возврат должен зависеть от расстояния до пляжа (чем дальше тем хуже И класса пляжа и все. Делается все в одной строчке!