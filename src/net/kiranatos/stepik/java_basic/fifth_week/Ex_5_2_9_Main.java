package net.kiranatos.stepik.java_basic.fifth_week;

import java.io.*;
import java.util.ArrayList;

/*
По историческим причинам на разных платформах принят 
разный способ обозначения конца строки в текстовом файле. 
На Unix-системах конец строки обозначается символом с кодом 
10 ('\n'), на Windows — двумя последовательными символами с кодами 
13 и 10 ('\r' '\n').

Напишите программу, которая будет преобразовывать переводы строк из 
формата Windows в формат Unix. Данные в формате Windows подаются программе 
в System.in, преобразованные данные должны выводиться в System.out.
На этот раз вам надо написать программу полностью, т.е. объявить класс 
(с именем Main — таково ограничение проверяющей системы), метод main, 
прописать все import'ы.

Требуется заменить все вхождения пары символов '\r' и '\n' на один 
символ '\n'. Если на входе встречается одиночный символ '\r', за которым 
не следует '\n', то символ '\r' выводится без изменения.

Кодировка входных данных такова, что символ '\n' представляется байтом 10, 
а символ '\r' — байтом 13. Поэтому программа может осуществлять фильтрацию 
на уровне двоичных данных, не преобразуя байты в символы.

Из-за буферизации данных в System.out в конце вашей программы надо явно 
вызвать System.out.flush(). Иначе часть выведенных вами данных не будет 
видна проверяющей системе.

Пример

Из System.in зачитаны следующие байты: 65 13 10 10 13. 
Внимание! Это не строка "65 13 10 10 13", а последовательность чисел, 
возвращаемая методом System.in.read().

В System.out должны быть выведены байты: 65 10 10 13

*/

public class Ex_5_2_9_Main {
    public static void main(String[] args) throws IOException {
        
        //InputStream iS = System.in;
        
      /*  InputStreamReader iS = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(iS);
        System.out.println(reader.read());
        */
        
    /*    byte[] data2 = {65, 13, 10, 10, 13};
        //InputStream iS = new ByteArrayInputStream(data2);
        
        
        ArrayList<Integer> data = new ArrayList <Integer>();*/

        //byte[] dataRes = new byte[iS.available()];
        //int i =0;
        
        int next;
        while ( (next=System.in.read()) != -1) {
            if ( (next==13) && ((next=System.in.read()) != -1) ) { 
                if (next!=10) { System.out.write(13);  System.out.write(next); }
                else System.out.write(next);//data.add(next); 
            }
            else System.out.write(next);
            
            
            //System.out.print((char)next);
            //System.out.println(next);
            //res = Integer.rotateLeft(res, 1) ^ next;
           // dataRes[i] = (byte)next;
           // i++;
            //System.out.println(" [Цикл " + next + "] ");
            //PrintStream ps;
            //PrintStream extends FilterOutputStream
            //FilterOutputStream extends OutputStream {
        }
        System.out.flush();
        /*
        byte[] dataRes = new byte[data.size()];
        for (int i =0; i<data.size(); i++) dataRes[i]= (byte)data.get(i).intValue();
        System.out.write(data2);
        */
        
        /*
        OutputStream oS = new PrintStream(System.out);
        oS.write(dataRes);
        
        System.out.flush();
        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.read());
        */


        
    }
}
