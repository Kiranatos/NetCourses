package net.kiranatos.stepik.java_adaptive.jetbrains;

import java.io.*;
import java.util.*;

/*
Given real numbers a, b, c, where a ≠ 0.
Solve the quadratic equation ax2 + bx + c = 0 and output all of its roots.
If the equation has two roots, output these two roots in ascending order; if one root - output a single number; if no roots – do not output anything.
Sample Input:
1
-1
-2

Sample Output:
-1 2
*/

public class Ex0010_quadratic_equation {
    private static final double EPSILON = 0.000000000001;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.valueOf(br.readLine());
        double b = Double.valueOf(br.readLine());
        double c = Double.valueOf(br.readLine());
        
        double x1, x2, d = b*b - 4 * a * c;
        
        if (Double.doubleToLongBits(d) < 0) {}
        else if (Math.abs(d) > EPSILON) {
            x1 = (double) (( (-1.0) * b - Math.sqrt(d) ) / (2.0*a));
            x2 = (double) (( (-1.0) * b + Math.sqrt(d) ) / (2.0*a));
            if (x2>x1)
                System.out.println( x1 + " " + x2 );
            else System.out.println( x2 + " " + x1 );
            
        }
        else if (d==0) {
            x1 = (double) (( (-1.0) * b ) / (2.0*a));
            System.out.println(x1);
        }
    }
}