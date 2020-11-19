package net.kiranatos.epam.summer20.p5;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SandBox {
    
    public static void main(String[] args) throws IOException {
        
//        byte[] a = System.lineSeparator().getBytes(StandardCharsets.UTF_8);
//        System.out.println(a.length);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
        
         //кладем данные в строку
         StringBuilder sb = new StringBuilder();
         sb.append("Lena").append('\n');
         sb.append("Olya").append('\n');
         sb.append("Anya").append('\n');
         String data = sb.toString();
         
         //Оборачиваем строку в класс ByteArrayInputStream
         InputStream is = new ByteArrayInputStream(data.getBytes());
         
         //подменяем in
         System.setIn(is);
         //вызываем обычный метод, который не подозревает о наших манипуляциях
         readAndPrintLine();
    }
    
    public static void readAndPrintLine() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        while (true) {
            String line = reader.readLine();
            if (line == null) { 
                System.out.println(" BREAK "); break; 
            }
            System.out.println(line);
        }
        reader.close();
        isr.close();
    }    
}
