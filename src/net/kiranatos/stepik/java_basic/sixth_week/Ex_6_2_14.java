package net.kiranatos.stepik.java_basic.sixth_week;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/*
Реализуйте метод, вычисляющий симметрическую разность двух множеств.

Метод должен возвращать результат в виде нового множества. 
Изменять переданные в него множества не допускается.

Пример
Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
*/
public class Ex_6_2_14 {
    
    private static <T> void printM(Set<T> t){
        System.out.print("[");
        Iterator<?> it = t.iterator();
        while (it.hasNext()) { 
            //Collections.addAll(t2, it.next());
            //t1.add((T)it.next());
            int a = (Integer)it.next();             
            System.out.print(a + " : ");            
        }
        System.out.println("]");
    }
    
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {        
        Set<T> t1 = new HashSet<>(set1);
        Set<T> t2 = new HashSet<>(set2);
        Set<T> t3 = new HashSet<>();

        Iterator<?> it = t1.iterator();
        while (it.hasNext()) { 
            T t = (T)it.next();
            if (!t2.contains(t)) {
                t3.add(t);    
            }
        }
        
        it = t2.iterator();
        while (it.hasNext()) { 
            T t = (T)it.next();
            if (!t1.contains(t)) {
                t3.add(t);    
            }
        }
        return t3;
    }
    
    public static void main(String[] args) {
        
        Set<Integer> s1 = new HashSet<Integer>(Arrays.asList(1,2,3));
        //System.out.println(s1.size());        
        Set<Integer> s2 = new HashSet<Integer>(Arrays.asList(0, 1,2));
      
        /*
        Iterator<Integer> it = s1.iterator();
        while (it.hasNext()) { 
            int a = it.next(); 
            System.out.print(a + " , ");
        }*/

        //System.out.println();
        
        Set<Integer> s3 = Ex_6_2_14.symmetricDifference(s1, s2);
        printM(s3);
        
        
    }
    
}
