package net.kiranatos.stepik.java_adaptive.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Func11Simple {
    
    public static void main(String[] args) {
        System.out.println("\t2.4 Calculating production of all numbers in the range");
        /*2.4 Calculating production of all numbers in the range
        Write a lambda expression that accepts two long arguments as a range 
        borders and calculates (returns) production of all numbers in this range
        inclusively). It's guaranteed that 0 <= left border <= right border. if 
        left border == right border then the result is any border.
        
        Solution format. Submit your lambda expression in any valid format with 
        ";" on the end.        
        Examples: (x, y) -> x + y; (x, y) -> { return x + y; };
        Sample Input 1:     0 1
        Sample Output 1:    0
        Sample Input 2:     2 2
        Sample Output 2:    2
        Sample Input 3:     1 4
        Sample Output 3:    24
        Sample Input 4:     5 15
        Sample Output 4:    54486432000        */
        BiFunction<Long, Long, Long> task2_4 = (a, b) -> {
            long s=1;
            if (a==b) s = a;
            else for (long i = a; i <= b; i++) s*=i;            
            return s;
        };
        //аналогичные решения других пользователей
        //(x, y) -> LongStream.range(x, y + 1).reduce((l, r) -> l * r).orElse(x);
        //(l, r) -> LongStream.rangeClosed(l, r).reduce(1L, (acc, x) -> acc * x);
        //LongBinaryOperator operator =(x, y) -> LongStream.rangeClosed(x, y).reduce(1, x == y ?(left, right) -> right :/*only right*/(left, right) -> left * right);
        //LongBinaryOperator operator2 = (x, y) -> LongStream.rangeClosed(x, y).reduce(x == y ?(left, right) -> left :(left, right) -> left * right).getAsLong();        
        System.out.println(task2_4.apply(0L, 1L));
        System.out.println(task2_4.apply(2L, 2L));
        System.out.println(task2_4.apply(1L, 4L));
        System.out.println(task2_4.apply(5L, 15L));
        
        /*********************************************************************/
        System.out.println("\t2.5 Getting distinct strings");
        /*2.5 Getting distinct strings
        Write a lambda expression that accepts a list of strings and returns 
        new list of distinct strings (without repeating). The order of elements 
        in the result list may be any (elements will be sorted by the testing 
        system).
        If the input list doesn't contain any strings then the result list 
        should be empty.
        Hints: it is possible to use sets, maps, lists and so on for helping.
        Solution format. Submit your lambda expression in any valid format 
        with ';' on the end.
        Examples: x -> x; (x) -> { return x; };
        Sample Input 1:     java scala java clojure clojure
        Sample Output 1:    clojure java scala
        Sample Input 2:     the three the three the three an an a
        Sample Output 2:    a an the three        */        
        String[] sM1 = new String[]{"java", "scala", "java", "clojure", "clojure"};
        String[] sM2 = new String[]{"the", "three", "the", "three", "the", "three", "an", "an", "a"};        
        MyFunction task2_5_wrong = (s) -> {
            java.util.Set <String> set = new java.util.TreeSet <> (java.util.Arrays.asList(s));
            return set.toArray(new String[set.size()]);
        };        
        for(String sk : task2_5_wrong.apply(sM1) ) System.out.print(" " + sk);
        System.out.println();
        for(String sk : task2_5_wrong.apply(sM2) ) System.out.print(" " + sk);
        System.out.println();
        
        
        List<String> list1 = new ArrayList<>(Arrays.asList(sM1));
        List<String> list2 = new ArrayList<>(Arrays.asList(sM2));
        Function2_5 task2_5 = (list) -> {
            List<String> result_list = new ArrayList<String>();
            for (String k : list) {
                if (!result_list.contains(k)) result_list.add(k);
            }
            return result_list;
        };                
        for(String sk : task2_5.apply(list1) ) System.out.print(" " + sk);
        System.out.println();
        for(String sk : task2_5.apply(list2) ) System.out.print(" " + sk);
        System.out.println();
        
        /*********************************************************************/
        System.out.println("\t2.6 Writing closures");
        /* 2.6 Writing closures
        Using closure write a lambda expression that calculates ax*x+b*x+c
        where a, b, c are context final variables. They will be available in 
        the context during testing. Note, the result is double.
        
        Solution format. Submit your lambda expression in any valid format 
        with ';' on the end.
        Examples: (x, y) -> x + y; (x, y) -> { return x + y; }       */
        
        int a=3, b=3, c=5;
        Function<Double,Double> task2_6_1 = (x) -> { return a*x*x+b*x+c; };
        System.out.println(task2_6_1.apply(1d));
        
        /* Using closure write a lambda expression that adds prefix (before) 
        and suffix (after) to its single string argument; prefix and suffix 
        are final variables and will be available in the context during testing.
        
        All whitespaces on the both ends of the argument must be removed. 
        Do not trim prefix, suffix and the result string.
        
        Solution format. Submit your lambda expression in any valid format 
        with ; on the end.
        
        Examples: (x, y) -> x + y; (x, y) -> { return x + y; }        */
        String prefix = "super", suffix="man";
        Function<String,String> task2_6_2 = (x) -> prefix+x.trim()+suffix;
        System.out.println(task2_6_2.apply(" spider "));
        System.out.println(task2_6_2.apply(" alco "));
    }
}

interface MyFunction {
	String[] apply(String... t);
}
interface Function2_5 {
	List<String> apply(List<String> t);
}
