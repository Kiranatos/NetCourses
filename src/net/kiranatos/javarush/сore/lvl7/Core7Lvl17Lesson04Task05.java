package net.kiranatos.javarush.сore.lvl7;

/* Java Core,  7 уровень,  4 лекция 
МВФ
Singleton паттерн - синхронизация в методе. Класс IMF - это Международный Валютный Фонд. 
Внутри метода getFund создайте синхронизированный блок. 
Внутри синхронизированного блока инициализируйте поле imf так, чтобы метод getFund всегда возвращал один и тот же объект. 

Old variant: package com.javarush.test.level17.lesson04.task05;
 */

/* МВФ
Singleton паттерн - синхронизация в методе
IMF - это Международный Валютный Фонд
Внутри метода getFund создайте синхронизированный блок
Внутри синхронизированного блока инициализируйте переменную imf так, чтобы метод getFund всегда возвращал один и тот же объект */

public class Core7Lvl17Lesson04Task05 {
    public static class IMF {
        private static IMF imf;
        private IMF() { }
        
        public static IMF getFund() {
            //add your code here - добавь код тут
            synchronized(IMF.class){
                if(imf == null) imf = new IMF();
            }
            return imf;
        }        
    }
}
