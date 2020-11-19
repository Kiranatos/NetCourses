package net.kiranatos.stepik.java_collections_framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* 2.1 ArrayList basic
Дмитрий Леванов, из курса Java. Collections Framework. — 2 Practical Lessons.

On static List<String> changeList(List<String> list) method you must do:
    find the longest string in list
     -if you use method max of class Collections : don't forget to implement a comparator for this method
       Collections.max(list, (s1,s2)->{...})
       by default, this method compares strings alphabetically!
    -of course you can use other approaches(for example comparison in a for-loop)

    replace all list items with this row
    return modified list

Sample Input:       hi hello goodmorning ass
Sample Output:      goodmorning
                    goodmorning
                    goodmorning
                    goodmorning
*/

public class Ex_2_1_ArrayListBasic {
    static List<String> changeList(List<String> list){
        String s = Collections.max(list, (String s1, String s2) -> s1.length() > s2.length() ? 1 : 
                s1.length() == s2.length() ? 0 : -1);
        
        int size = list.size();
        
        Iterator<String> it = list.iterator();
        while (it.hasNext()) { 
            it.next(); 
            it.remove();
        }
//list.clear();

        for (int i = 0; i < size; i++) list.add(s);
        /*
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < size; i++) list2.add(s);
        */
        return list;
    }
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("hi", "hello", "goodmorning", "ass", "goodTOrning"));
        
        changeList(list);
        
        for (String el : changeList(list)) {
            System.out.println(el);            
        }
        
    }

}
