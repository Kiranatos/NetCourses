package net.kiranatos.stepik.java_adaptive.jetbrains;

import java.util.*;

public class Ex0008 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 3, 2));

        System.out.println("list1.subList(1, 2).equals(list2.subList(2, 3))? " + 
                            list1.subList(1, 2).equals(list2.subList(2, 3)));
        System.out.println("sub: " + list1.subList(0, 2));
        
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 3, 2));
        System.out.println("set1.equals(set2)? " + set1.equals(set2));
        
        
        /* A list with numbers from 0 to 20 is given.
        Remove numbers less than 10 from it without additional lists or arrays usage.
        Modify the code so that it does not raise the ConcurrentModificationException.
        
        Hint ! Use the Iterator.        */
        List<Integer> delList = new ArrayList<>();
        for (int i = 0; i < 20; i++) { delList.add(i); }
        
        /* change this code which raises ConcurrentModificationException
        for (Integer num : delList) {
            if (num < 10) delList.remove(num);
        }
        */
        Iterator<Integer> it = delList.iterator();
        while (it.hasNext()) { 
            if (it.next()<10) it.remove(); 
        }



        System.out.println(delList);
        
    }
}
