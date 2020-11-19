package net.kiranatos.www;

import java.util.Scanner;

/* Ввести с консоли число в бинарном формате. Перевести его в int и вывести на экран (“10” -> 2).*/

public class BitTest_01 {
    // метод перевода целого числа в бинарный формат
    private static String toBinaryString (int x) {
        return String.format("%32s", Integer.toBinaryString(x));
    } 
    
    private static int countBit (int x) { // метод подсчета количества едениц (битов)
        int count = 0;
        for (int i = 0; i <32; i++) {
            count += x & 1;
            x = x >> 1;
        }
        return count;
    }
    
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println ("Enter your number: ");
        int a = sc.nextInt ();
        System.out.println ("Number in binary format is " + Integer.toBinaryString(a) +
                " Number of one unit is " + countBit (a));
        sc.close ();
    }
}
