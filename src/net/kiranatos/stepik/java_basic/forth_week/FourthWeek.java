package net.kiranatos.stepik.java_basic.forth_week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class FourthWeek {
    
    public static double sqrt(double x) {
        if ( x<0 ) throw new IllegalArgumentException("Expected non-negative number, got " + x);
        return Math.sqrt(x);
    }
    
    public static String getCallerClassAndMethodName() {        
        StackTraceElement trace[] = new Throwable().getStackTrace();
        if (trace.length < 3)  return null;        
        else return trace[2].getClassName() + "#" + trace[2].getMethodName();
    }
    
    public static void main(String[] args) {
        
        ArrayList<Integer> list = new ArrayList <Integer>(Arrays.asList( 2,0,1,7 ));
        TreeSet<String> set = new TreeSet <String>(Arrays.asList( "Gamma", "Alpha", "Omega" ));

 
        
         System.out.println(set);
    }
}
