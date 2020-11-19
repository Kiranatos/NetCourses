package net.kiranatos.stepik.java_basic.sixth_week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Напишите метод, находящий в стриме минимальный и максимальный элементы 
в соответствии порядком, заданным Comparator'ом.

Найденные минимальный и максимальный элементы передайте 
в minMaxConsumer следующим образом:
minMaxConsumer.accept(min, max);
Если стрим не содержит элементов, то вызовите
minMaxConsumer.accept(null, null);
*/
public class Ex_6_4_12 {
    public static <T> void findMinMax(
        Stream<? extends T> stream,
        Comparator<? super T> order,
        BiConsumer<? super T, ? super T> minMaxConsumer) {
        
        T[] arr = (T[])stream.sorted(order).toArray();  //T[] arr = (T[])new Object[ARRAY_LENGTH];        
        if (arr.length>0) minMaxConsumer.accept(arr[0], arr[arr.length-1]);
        else minMaxConsumer.accept(null, null);

        
        //Stream<? extends T> copy1 = stream.distinct();
        //Stream<? extends T> copy2 = stream.distinct();
        //if (order==null) { minMaxConsumer.accept(null, null); }
        //else if (stream.count()>0) {
     /*       Optional<? extends T> max = copy1.max(order);
            Optional<? extends T> min = copy2.min(order);
            
            minMaxConsumer.accept(max.get(), min.get());
        }
        else { minMaxConsumer.accept(null, null); }
*/
    // your implementation here
}
    public static void main(String[] args) {        
        Stream<Integer> stream = Stream.iterate(13, n -> n * n/10%1000).limit(20);        
        Comparator<Integer> order = (Integer o1, Integer o2) -> o1.compareTo(o2);
        
        BiConsumer<Integer, Integer> minMaxConsumer = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer max, Integer min) {
                System.out.println("Max =" + max);
                System.out.println("Min =" + min);
            }
        };
        
        findMinMax(stream, order, minMaxConsumer);
    }
    
}
