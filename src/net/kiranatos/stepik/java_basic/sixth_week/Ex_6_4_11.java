package net.kiranatos.stepik.java_basic.sixth_week;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * Напишите метод, возвращающий стрим псевдослучайных целых чисел. 
 * Алгоритм генерации чисел следующий:
 * 
 * 1. Берется какое-то начальное неотрицательное число (оно будет передаваться 
 * в ваш метод проверяющей системой).
 * 2. Первый элемент последовательности устанавливается равным этому числу.
 * 3. Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(R2n), 
 * где mid — это функция, выделяющая второй, третий и четвертый разряд 
 * переданного числа. Например, mid(123456)=345
 * 
 * Пример
 * pseudoRandomStream(13) должен вернуть стрим, состоящий из следующих чисел:
 * 13=169 16=256
 * 13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)
 */
public class Ex_6_4_11 {
    
    public static IntStream pseudoRandomStream(int seed) {
        IntStream is = IntStream.iterate(seed, n -> n * n/10%1000);
               // .map((int n) -> (n/10)%1000);
        return is;
    }
    
    public static void main(String[] args) {
        int sum = IntStream.iterate(1, n->n+1)
                .filter( n -> n%5==0 && n%2!=0 )
                .limit(10)                
                .map(n->n*n)                
                .sum();
        
        IntStream is = pseudoRandomStream(13);
        int[] d = is.limit(20).toArray();
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }
    }
}
