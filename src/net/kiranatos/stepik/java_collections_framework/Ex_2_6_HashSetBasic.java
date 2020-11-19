package net.kiranatos.stepik.java_collections_framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* 2.6 HashSet. Basic operations 
Дмитрий Леванов, из курса Java. Collections Framework. — 2 Practical Lessons.

Additional code,son!
    1.Given a string as "1 2 3 4 5 6 ..." . String[] strings contains of element 
from given string ("1","2",..).
Add all elements from String[] strings to Set<Integer> set.
    2.Add all the elements from helpList to set .
    3.Using Iterator remove/filter(Stream API)/"method-of-all-collections" 
all elements greater than 10(>) from set and return modified set.

Sample Input:   1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
Sample Output:
1
2
3
4
5
6
7
8
9
10  */

public class Ex_2_6_HashSetBasic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        List<Integer> helpList = getList();
        Set<Integer> set = new HashSet<>();
        //add elements from strings to set
        for (String q : strings) {
            set.add(Integer.parseInt(q));
        }
        for (Integer q : helpList) {
            set.add(q);
        }
        //add elements from helpList to set
        set = removeAllNumbersMoreThan10(set);
        set.forEach(System.out::println);
    }
    
    public static Set<Integer> removeAllNumbersMoreThan10(Set<Integer> set){
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) { 
            if (it.next() > 10 ) it.remove();
        }
        //put your code here
        return set;
    }
    
    private static List<Integer> getList() {
        return new ArrayList<Integer>(Arrays.asList(20,22,33,55 ));
    }
}
