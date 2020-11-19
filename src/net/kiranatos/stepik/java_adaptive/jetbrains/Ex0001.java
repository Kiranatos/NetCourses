package net.kiranatos.stepik.java_adaptive.jetbrains;

import java.util.*;

/* The list of strings is given.
List<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
Convert it to the string array by name strArray.
The code for displaying the array is already written.

Sample Output:
Mr.Green
Mr.Yellow
Mr.Red
*/

public class Ex0001 {

    public static void main(String[] args) {

        List<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));

        String[] strArray = new String[nameList.size()];
        nameList.toArray(strArray);

        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }      
        
        List<Object> arrr = new ArrayList<>(Arrays.asList(2,"Ivan" ,"Ivanov","Java Developer", new Integer(2),3.0,4000));
        Object[] ray = new Object[arrr.size()];
        arrr.toArray(ray);
        System.out.println(ray.length);
        
        
        String s = "1 Ivan Ivanov Java Developer 3.0 4000";
        String[] sM = s.split(" ");
        
        String line = "1 Ivan Ivanov Java Developer 3.0 4000";
        List<String> devList = Arrays.asList(line.split("\\n")); 
        System.out.println(devList); 
        Object[] dev = new Object[devList.size()]; 
        System.out.println(Arrays.toString(dev)); 
        
    }
}