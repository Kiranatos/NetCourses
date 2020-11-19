package net.kiranatos.stepik.java_adaptive.jetbrains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex0016SIMPLE {
    public static void main(String[] args) {
        /*java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        try {
            String str = reader.readLine();
            String[] s = str.split(" ");
            int a = Integer.parseInt(s[0]);            
            int b = Integer.parseInt(s[1]);
            System.out.println(a+b);
        } catch (java.io.IOException ex) { }
        */
        List<Integer> list = new ArrayList<>(Arrays.asList(55,75,2,3,1,2,3,4,5,66,78,2,1,6,12));
        System.out.println(maxElem(list));
        
    }    
    
    
    public static Integer maxElem(List<Integer> list){
                
        return java.util.Collections.max(list);
    }
}
