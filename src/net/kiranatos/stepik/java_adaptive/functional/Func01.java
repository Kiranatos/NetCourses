package net.kiranatos.stepik.java_adaptive.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

/* 2.2 Writing simple lambda expressions
========================Exercise One========================
Write a lambda expression that accepts two integers arguments and returns 
max of them.
Try not to use the Math library.
Solution format. Submit your lambda expression in any valid format 
with ';' on the end.

Examples: (x, y) -> x + y; (x) -> { return x; };
Sample Input:   1 4
Sample Output:  4
========================Exercise Two========================
Write a lambda expression that accepts a long value and returns a next even
number.
It is guaranteed an input number is non-negative.
Solution format. Submit your lambda expression in any valid format 
with ';' on the end.

Examples: x -> x; (x) -> x; (x) -> { return x; };
Sample Input 1:     2
Sample Output 1:    4

Sample Input 2:     317
Sample Output 2:    318
 */
public class Func01 {
    public static void main(String[] args) {        
        int constant = 100;
        Function<Integer, Integer> adder = x -> x + constant;
        
        System.out.println(adder.apply(200));
        System.out.println(adder.apply(300));
        
        new Thread( () -> { System.out.println("Hello from thread");}).start();
        
        
        //BiFunction<Integer, Integer, Integer> adder2 = (x, y) -> x + y;
        BiFunction<Integer, Integer, Integer> adder2 = (x, y) -> (x>y) ? x : y;
        System.out.println(adder2.apply(10, 20));
        System.out.println(adder2.apply(300, 400));
        System.out.println(adder2.apply(1, 4));
        
        Function<Long, Long> adder3 = x -> ((x+1)%2==0) ? x+1 : x+2;
        
        System.out.println(adder3.apply(2L));
        System.out.println(adder3.apply(4L));
        System.out.println(adder3.apply(317L));
        
        
    }    
}