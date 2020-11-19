package net.kiranatos.stepik.java_adaptive.jetbrains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Leap year

The problem is to find whether the given year is a leap year.
Just a reminder: leap years are those years, the number of which 
is either divisible by 4, but not divisible by 100, or divisible 
by 400 (for example, the year 2000 is a leap year, but the year 
2100 will not be a leap year).

The program should work correctly for the years 1900 ≤ n ≤ 3000.

Output "Leap" (case-sensitive) if the given year is a leap, 
and "Regular" otherwise.

Sample Input 1:
2100
Sample Output 1:
Regular

Sample Input 2:
2000
Sample Output 2:
Leap
*/
public class Ex0005 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.valueOf(br.readLine());         
        
        if (a % 4 == 0) {
            if ((a % 100==0)& (a % 400!=0)) System.out.println("Regular");
            else System.out.println("Leap");
        }
        else System.out.println("Regular");
        
    }
    
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.valueOf(br.readLine());         
        switch (a) {
            case 1: 
                System.out.println("You have chosen a square");
                break;
            case 2: 
                System.out.println("You have chosen a circle");
                break;
            case 3: 
                System.out.println("You have chosen a triangle");
                break;
            case 4: 
                System.out.println("You have chosen a rhombus");
                break;
            default: 
                System.out.println("There is no such shape!");
                break;
        }

    }
    
    public static void main(final String[] args) {
          System.out.println(Thread.currentThread().getName());
    }*/
}
