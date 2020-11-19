package net.kiranatos.stepik.java_adaptive.functional.theory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;

public class ForMyTestLearning {
    
    public static void main(String[] args) {
        System.out.println("COMPOSING FUNCTIONS:");
        Function<Integer, Integer> adder = x -> x + 10;
        Function<Integer, Integer> multiplier = x -> x * 5;                
        // f.compose(g).apply(x) is the same as f(g(x)), сперва расчитывает multiplier, потом adder.
        System.out.println("result: " + adder.compose(multiplier).apply(5) ); //5*5 + 10
        System.out.println("result: " + adder.apply( multiplier.apply(5) ) );
        // f.andThen(g).apply(x) is the same as g(f(x)), сперва расчитывает adder, потом multiplier.
        System.out.println("result: " + adder.andThen(multiplier).apply(5)); //(5+10) * 5
        System.out.println("result: " + multiplier.apply(adder.apply(5)) );
        
        System.out.println("\nCOMPOSING PREDICATES:");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            numbers.add(i);
        }
        IntPredicate isEven = x -> x % 2 == 0;
        IntPredicate dividedBy3 = x -> x % 3 == 0;
        IntPredicate pred = isEven.negate().or(dividedBy3);
        // print all odd values and even values that can be divided by 3.
        numbers.forEach(val -> {
            if (pred.test(val)) System.out.print(val + " ");
        });
    }    
}

/* 
Разобрать статьи и литературу: https://stepik.org/lesson/46367/step/2?unit=24403


1.2 => 2.1 - 2.6
1.3 => 2.7 - 2.14
1.4 => 2.15 - 2.19
1.5 => 2.20 - 2.24
1.6 => 2.25 - 2.29
1.7 => 2.30 - 2.31
1.8 => 2.32 - 2.35
1.9 => 2.36 - 2.39
*/