package net.kiranatos.softserve;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JavaTest1 {
    static Long h;
    
    public static void main(String[] args) {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        
        int gg = 0xA;
        System.out.println(gg);
        
        //question1();
        //question2();
        question3();
    }
    
    public static void question3() {
        int cycle = 0;                
        int y = 0;
        int k;
        for (k = 2; k <= 6; k++) {
            y = y + k;            
            cycle++;
        }
        System.out.println("y = " + y); // 20
        System.out.println("k = " + k); // 7
        System.out.println("Cycle executes: " + cycle); // 5
    }
    
    public static void question2() {
        int cycle = 0;                
        int y = 2;
        int k;
        for (k = 4; k >= 1; k--) {
            y = y * k;            
            cycle++;
        }
        System.out.println("y = " + y); // 48
        System.out.println("k = " + k); // 0
        System.out.println("Cycle executes: " + cycle); // 4
    }
    
    public static void question1() {
        int cycle = 0;                
        int y = 0;
        int k;
        for (k = 4; k >= 3; k--) {
            y = y + k;
            y = y * 10;
            cycle++;
        }
        System.out.println("y = " + y); // 430
        System.out.println("k = " + k); // 2
        System.out.println("Cycle executes: " + cycle); // 2
    }
}
