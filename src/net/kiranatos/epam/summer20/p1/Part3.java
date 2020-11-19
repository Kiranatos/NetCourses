package net.kiranatos.epam.summer20.p1;

/* Task 3 Class name: com.epam.rd.java.basic.practice1.Part3
——————————————————————————————
Write a class that implements functionality of displaying of the command line 
parameters in console (display using a space between them), the result should 
not end with a space. */

public class Part3 {
    public static void main(String[] args) {
        if (0 < args.length)
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (args.length-1 != i) System.out.print(" ");
            }
    }    
}