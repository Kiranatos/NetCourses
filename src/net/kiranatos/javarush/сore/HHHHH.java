package net.kiranatos.javarush.сore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые-самые
Java Syntax,  7 уровень,  6 лекция 
*/

public class HHHHH {
     public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        
        List<String> list = new ArrayList <String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

        int min = 0, max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() < list.get(min).length())
                min = i;
            if (list.get(i).length() > list.get(max).length())
                max = i;
        }
        
        if (min < max)
            System.out.println(list.get(min));
        else System.out.println(list.get(max));
                
        

    }
}
