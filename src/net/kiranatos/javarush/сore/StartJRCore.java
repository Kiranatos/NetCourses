package net.kiranatos.javarush.сore;

import net.kiranatos.OzoHelper;
import net.kiranatos.javarush.сore.lvl7.Core7Lvl17Lesson10Task08_Bankomat;

public class StartJRCore {    
    private static String theChoice;
    
    public static void main(String[] args)  {
        OzoHelper.printMe(null, 
                "Раздел «Java Core» 11-20 уровень",
                "1) Level 17 Lesson10 Task 08. Банкомат. Пример работи нитей и класса BigDecimal",
                "2) Level 17 Lesson10 Task 13. Ресторан. Пример работи нитей и класса java.util.concurrent.ConcurrentLinkedQueue",
                "",
                "",
                "",
                "___");
        
        theChoice = OzoHelper.getRead();
        System.out.println("Your choice: " + theChoice);
        
        switch (theChoice) {
            case "1": 
                Core7Lvl17Lesson10Task08_Bankomat.main(null);
                break;
            case "2":
                net.kiranatos.javarush.сore.lvl7.Core7Lvl17Lesson10Task13_Restaurant.main(null);
                break;
            case "3": 
                //sortStart();
                break;
            case "4": 
                //timeAndDateStart();
                break;
            case "5": 
                //lambdaStart();
                break;
            case "6": 
                //fontsStart();
                break;
            case "7": 
                //multithreadingStart();                
                break;
            case "8": 
                //net.kiranatos.e08random.TestRandom.main(null);
                break;
            case "9": 
                System.out.println("Error");
                break;
            case "exit": 
                System.exit(0);
                break;
            default: 
                System.out.println("Incorrect choice !!!");
                //Start_Ex_WithoutPlugInLibs.main(null);
                break;
        }         
    }    
}


/*
 
    package com.javarush.test.level15.lesson02.task04; - интереный недо-патерн с интерфейсом и абстрактным классом

package com.javarush.test.level15.lesson12.bonus02; - интереный недо-патерн с интерфейсом

package com.javarush.test.level15.lesson09.task05; - извращение со статическим блоком

package com.javarush.test.level16.lesson07.task05; - манипуляция с нитями

package com.javarush.test.level16.lesson13.bonus03; - hentai threads + Thread.UncaughtExceptionHandler

package com.javarush.test.level17.lesson02.task01; - приклад як нитки працюють/заважають без синхронізації


        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            System.out.println(element);
        }

    
    Core7Lvl17Lesson10Task03
    Core7Lvl17Lesson10Task05 - непонятная хрень    
*/