package net.kiranatos.linkedin.c001.lesson4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* Course: Learning Java
By: Kathryn Hodge
https://www.linkedin.com/learning/learning-java-4/what-you-should-know?u=2113185 */

public class APISolution {
    public static void main(String[] args) {
        //create SimpleDateFormat Object to convert the date in particular string format    
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date dt = new Date();
        
        // format method is used to convert the date in MM/dd/yyyy format
        System.out.println("Date in MM/dd/yyyy format: " + df.format(dt));
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);
        System.out.println("France time: "+df2.format(dt));
    }
}
