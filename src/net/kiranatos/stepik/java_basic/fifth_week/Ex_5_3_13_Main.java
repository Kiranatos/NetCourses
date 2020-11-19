package net.kiranatos.stepik.java_basic.fifth_week;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/*
Напишите программу, читающую текст из System.in и выводящую в System.out сумму 
всех встреченных в тексте вещественных чисел с точностью до шестого знака после 
запятой. Числом считается последовательность символов, отделенная от окружающего 
текста пробелами или переводами строк и успешно разбираемая 
методом Double.parseDouble.

На этот раз вам надо написать программу полностью, т.е. объявить класс 
(с именем Main — таково ограничение проверяющей системы), метод main, 
прописать все import'ы.

Sample Input 1:
1 2 3
Sample Output 1:
6.000000

Sample Input 2:
a1 b2 c3
Sample Output 2:
0.000000

Sample Input 3:
-1e3
18 .111 11bbb
Sample Output 3:
-981.889000
 */
public class Ex_5_3_13_Main {
    public static void main(String[] args) throws IOException {
        //ctrl+D - завершение ввода
        /*
        https://unicode-table.com/ru/0053/
        Номер в Юникоде	U+0053
        Кодировка 	hex 	dec (bytes) 	dec 	binary
        UTF-8    	53 	83       	83 	01010011        
        */
        System.out.println("Буква S");
        System.out.println((char)0x53);
        System.out.println((char)83);
        System.out.println('\u0053');
        System.out.println("Число: " + 0x53);
        
        /*
        https://unicode-table.com/ru/5929/
        Номер в Юникоде	U+5929
        Кодировка 	hex             dec (bytes) 	dec             binary
        UTF-8           E5 A4 A9 	229 164 169 	15049897 	11100101 10100100 10101001
        */        
        System.out.println("Буква 天");
        System.out.println((char)0xE5A4A9);
        System.out.println((int)'天');
        System.out.println('\u5929');
        System.out.println("Число: " + 0xE5A4A9);
        byte[] b = {(byte)229, (byte)164, (byte)169};
        //char cs = (char)0xE5A4A9);
        String s = new String(b, Charset.forName("UTF-32"));
        System.out.println(s);
        
        
        
        int next;
        System.out.println(System.getProperty("line.separator").getBytes().length);
        ArrayList<Integer> bytesList = new ArrayList <Integer>();

        while ( (next=System.in.read()) != /*-1*/(int)'+') {
            bytesList.add(next);            
            
            /*
            if ( (next==13) && ((next=System.in.read()) != -1) ) { 
                if (next!=10) { System.out.write(13);  System.out.write(next); }
                else System.out.write(next);//data.add(next); 
            } else if (next==32) {}            
            else System.out.write(next);*/
        }        
        String doubleStr = getTotal(bytesList);
        System.out.println("===== " + doubleStr + " =====");
        
        System.out.write(System.getProperty("line.separator").getBytes());
        System.out.flush();
    }    
    
    private static String getTotal(ArrayList<Integer> bList) {
        String res;
        byte[] b = new byte[bList.size()];
        int i = 0;
        Iterator<Integer> it = bList.iterator();		
        while (it.hasNext()) {             
            b[i] = (byte)it.next().intValue();             
            System.out.print(b[i] + " / ");
            i++;
        }

        res = new String(b);
        double summ = 0e6;
        System.out.println(res.replace(System.getProperty("line.separator"), " "));

        String[] mS1 = res.replaceAll(System.getProperty("line.separator"), " ").split(" ");
        for (String str : mS1) {
            System.out.println(" [" + str + "] ");
            try {
                summ += Double.parseDouble(str); 
            } catch (NumberFormatException e) {}
        }
        System.out.println(summ);
        return String.valueOf(summ);
    }
}
