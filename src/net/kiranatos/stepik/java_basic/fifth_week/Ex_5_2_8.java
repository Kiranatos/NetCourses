package net.kiranatos.stepik.java_basic.fifth_week;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ex_5_2_8 {
    
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        // your implementation here
        int res = 0;
        int next;
        while ( (next=inputStream.read()) != -1) {
            //System.out.print((char)next);
            //System.out.println(next);
            res = Integer.rotateLeft(res, 1) ^ next;            
        }        
        return res;
    }
    
    public static void main(String[] args) throws IOException {
        InputStream iS = Files.newInputStream(Paths.get("F:\\test2.txt"));
        System.out.println(checkSumOfStream(iS));

        byte[] data = {1,2,3,4,5};        
        InputStream iS2 = new ByteArrayInputStream(data);
        System.out.println(checkSumOfStream(iS2));
        
        byte[] data2 = {0x33, 0x45, 0x01};      // = 71  
        //0x33 = 51, 0x45 = 69, 0x01 = 1
        iS2 = new ByteArrayInputStream(data2);
        System.out.println(checkSumOfStream(iS2));
    }
}
