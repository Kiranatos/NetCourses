package net.kiranatos.stepik.java_basic.sixth_week;

import java.util.*;
import java.util.function.Consumer;


public class TestForEachOrdered {    
    public static void main(String[] args) {
        List<String> messages = Arrays.asList( "one", "secondMessage", "thirdMessage" );
        
        messages.stream().forEachOrdered((String p) -> { System.out.println("Lyambda " + p); });
        
        ClassA<String> a = new ClassA<>();
        
        messages.stream().forEachOrdered(a);
        
    }    
}

class ClassA<T> implements Consumer<String> {

    @Override
    public void accept(String t) {
        System.out.println("Consumer " + t);
    }
 }
