package net.kiranatos.javarush.сore.lvl7;

/* Java Core,  7 уровень,  4 лекция 
Синхронизированный президент
И снова Singleton паттерн - синхронизация в статическом блоке Внутри класса OurPresident 
в статическом блоке создайте синхронизированный блок. 
Внутри синхронизированного блока инициализируйте president. 

Old variant: package com.javarush.test.level17.lesson04.task04;
 */

/* Синхронизированный президент
И снова Singleton паттерн - синхронизация в статическом блоке
Внутри класса OurPresident в статическом блоке создайте синхронизированный блок.
Внутри синхронизированного блока инициализируйте president. */

public class Core7Lvl17Lesson04Task04 {
    public static class OurPresident {

        private static OurPresident president;

        private OurPresident() { }

        static {
            synchronized(OurPresident.class){
                president = new OurPresident();
            }
        }

        public static OurPresident getOurPresident() {
            return president;
        }
    }    
}
