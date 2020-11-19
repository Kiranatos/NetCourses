package net.kiranatos.linkedin.c001.lesson4;

import java.io.*;
import java.util.*;

/* Course: Learning Java
By: Kathryn Hodge
https://www.linkedin.com/learning/learning-java-4/what-you-should-know?u=2113185

This program reads numbers from a text file and then prints the average
It also has error handling for file io and divide by zero */

public class ErrorHandling {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName;
        Scanner in = new Scanner(System.in);
        System.out.println("What is the file name: ");
        inputFileName = in.nextLine();
        Scanner inFile = null;
        double total = 0;
        int count = 0;
        try {
            inFile = new Scanner(new File(inputFileName));
            while(inFile.hasNextDouble())            {
                total = inFile.nextDouble();
                // count++;
            }
            System.out.printf("The average is: %8.2f",(total/count));
            System.out.println();
        } catch(FileNotFoundException file) {
            System.out.println("Input file was not found, try again.");
            //remove the comment below to print the stack trace
            //file.printStackTrace();
        } finally {
            try {
                inFile.close();
            } catch(NullPointerException e) {
                System.out.println("Null Pointer exception has occurred.");
            }   
        }
    }
}
