package net.kiranatos.stepik.java_basic.fifth_week;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/*
Реализуйте метод, который зачитает данные из InputStream и 
преобразует их в строку, используя заданную кодировку.

Пример
InputStream последовательно возвращает четыре байта: 48 49 50 51.
Метод, вызванный для такого InputStream и кодировки ASCII, 
должен вернуть строку "0123".
*/

public class Ex_5_3_12 {
    
    public static String readAsString(InputStream inputStream, Charset charset) 
            throws IOException {
        int next, i = 0;
        byte[] b = new byte[inputStream.available()];
        while ( (next=inputStream.read()) != -1) {
            b[i] = (byte)next;
            i++;
        }        
        return new String(b, charset);
    }
    
    public static void main(String[] args) throws IOException {
        
        byte[] data1 = {65, 13, 10, 10, 13};
        InputStream iS = new ByteArrayInputStream(data1);
        System.out.println(readAsString(iS, Charset.forName("ASCII")));
        
        byte[] data2 = {48, 49, 50, 51};
        iS = new ByteArrayInputStream(data2);
        System.out.println(readAsString(iS, Charset.forName("ASCII")));
    
        
    }
    
}
