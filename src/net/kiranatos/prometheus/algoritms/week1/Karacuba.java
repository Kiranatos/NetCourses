package net.kiranatos.prometheus.algoritms.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Karacuba {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите 1-е число:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1 = reader.readLine();
        System.out.println("Введите 2-е число:");
        String num2 = reader.readLine();
        System.out.println("Длина 1-го числа: " + num1.length());
        System.out.println("Длина 2-го числа: " + num2.length());        
    }
}
