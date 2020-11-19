package net.kiranatos.stepik.java_basic.fifth_week;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
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
public class Ex_5_3_13_Main2 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        double summ = 0e6;
        while(scan.hasNext()){
            String s = scan.next();
            try {                
                //System.out.println(s);
                summ += Double.parseDouble(s); 
                //System.out.println(summ);
            } catch(RuntimeException e) { }
            //System.out.println(summ);
            //System.out.printf("%.6f ", summ);
        }
        System.out.printf("%.6f ", summ);
        System.out.flush();
    } 
}
