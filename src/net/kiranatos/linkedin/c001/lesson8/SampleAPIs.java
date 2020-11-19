package net.kiranatos.linkedin.c001.lesson8;

import java.lang.*;
import java.util.Arrays;

/* Course: Learning Java
By: Kathryn Hodge
https://www.linkedin.com/learning/learning-java-4/what-you-should-know?u=2113185 */

public class SampleAPIs {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 17, 25, 4, 33, 45, 12};
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        boolean[] responses = {true, false, false, true, true};
        boolean[] responses2 = {false, true, false, true, true};
        
        //sorting works with arrays of type int, double, char, byte, long, short, object
        System.out.println("Before sorting: "+ Arrays.toString(numbers));
        Arrays.sort(numbers);        
        System.out.println("After sorting: "+ Arrays.toString(numbers));        
        
        //works with arrays of type int, double, char, byte, long, short, object
        int key = 25;
        int keyPosition = Arrays.binarySearch(numbers,key);        
        System.out.println("Your key was found in position " + keyPosition);
       
        if(Arrays.equals(responses, responses2) == true)
            System.out.println("The two boolean arrays are the same.");
        else
            System.out.println("The two boolean arrays are different");
        
        //copyof and equals with arrays of type int, double, char, byte, long,
        // short, object, and boolean
        int[] numbers2 = Arrays.copyOf(numbers,numbers.length*2);
    }
}