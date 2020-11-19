package net.kiranatos.epam.summer20.p1.myexperiment1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class Test1 {
    public static void main(String[] args) 
            throws IOException, Exception  {
//        System.out.println("Hello World");
        
        PrintStream myOut = null;
//        myOut.println("War World");
        
        Class clazz = Class.forName(System.class.getName());
////        
////        Field field = clazz.getClass().getDeclaredField("out");
//        
//        //System.out = "";
//        //myOut.println("War World");
//        
//        Field mySecretOut = null;
//        Field[] declaredFields = System.class.getDeclaredFields();
//        List<Field> staticFields = new ArrayList<Field>();
//        for (Field field : declaredFields) {
//            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
//                staticFields.add(field);
//                System.out.println(field.getName());
//                String s = field.getName();
//                //if (s.equals("out")) myOut = field.get(s);
//                
//            }
//        }
//        
        Field f = System.class.getField("out");
        //f.get(clazz);
        myOut = (PrintStream)f.get(clazz);
        myOut.print("ddd");
        
    }    
}
