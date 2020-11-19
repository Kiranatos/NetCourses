package net.kiranatos.stepik.java_adaptive.jetbrains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Ex0007 {
    /*  Floor-space of the room
    Residents of the Malevia country often experiment with the plan of their
    rooms. Rooms can be triangular, rectangular and round. To quickly calculate 
    the floorage it is required to write a program, which gets the type 
    of the room shape and the relevant parameters as input - 
    the program should output the area of the resulting room.
    
    The value of 3.14 is used instead of the number pi in Malevia.
    
    Input format used by the Malevians:
    triangle
    a
    b
    c    
    where a, b and c — lengths of the triangle sides.
    
    rectangle
    a
    b
    where a and b — lengths of the rectangle sides.
    
    circle
    r    
    where r — circle radius.
    
    Sample Input 1:
    rectangle
    4
    10
    Sample Output 1:
    40.0
    
    Sample Input 2:
    circle
    5
    Sample Output 2:
    78.5
    
    Sample Input 3:
    triangle
    3
    4
    5
    Sample Output 3:
    6.0
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int a = Integer.valueOf(br.readLine());
        double rez = 0;
        if (s.equals("triangle")) {            
            int b = Integer.valueOf(br.readLine());
            int c = Integer.valueOf(br.readLine());
            double p = (a + b + c)/2.0;
            System.out.println("p:"  + p);
            rez = Math.sqrt( p*(p-a)*(p-b)*(p-c) );
        }
        else if (s.equals("rectangle")) {
             int b = Integer.valueOf(br.readLine());
             rez = a * b;
        }
        else if (s.equals("circle")) {
            rez = 3.14 * a * a;
        }
        
        System.out.println(rez);
        //System.out.printf("%.2f\n",rez);
    }
    
    
    
/*
Write a program that uses regular expressions to check whether the 
input string is a phone number.
A phone number has the following form: 19∗∗∗∗∗∗∗∗∗, where ∗
is any number from 0 to 9.
The program should print Yes or No.

Sample Input:  19123456789
Sample Output: Yes
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        if (s.matches("19[0-9]{9}")) System.out.println("Yes");
        else System.out.println("No");
    }    
*/
}
