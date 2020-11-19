package net.kiranatos.stepik.java_adaptive.functional;

/*      2.3 Too many arguments
Artyom Burylov, из курса Java.
Functional programming — 2 Practical lessons "Java. Functional programming"

Write a lambda expression that accepts seven (!) string arguments and returns 
a string in upper case concatenated from all of them (in the order of arguments).

Note. The correct solution may not work in your local environment because 
you don't have suitable functional interface. The testing system has the 
interface and can test your solution.

Solution format. Submit your lambda expression with seven arguments in 
any valid format with ; on the end.

Examples (only with two args): (x, y)  -> x + y; (x, y) -> { return x + y; };

Sample Input:
The lambda has too many string arguments.

Sample Output:
THELAMBDAHASTOOMANYSTRINGARGUMENTS.
*/

public class Func02 {
    public static void main(String[] args) {
        //Правельное решение:
        SevenFunction<String> sFunc = 
                (s1, s2, s3, s4, s5, s6, s7) -> (s1+s2+s3+s4+s5+s6+s7).toUpperCase();        
        System.out.println(sFunc.apply("The", "lambda", "has", "too", "many", "string", "arguments."));
              
    }    
}

@FunctionalInterface
interface SevenFunction<T>{
    T apply(T t1, T t2, T t3, T t4, T t5, T t6, T t7);
}