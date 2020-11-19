package net.kiranatos.epam.summer20.p4.passed;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class Part5 {
    private static final String RU_PROP = "resources_ru.properties";
    private static final String EN_PROP = "resources_en.properties";
    private static final String STR_ERR = "Incorrect input";
    private static final String STR_STOP = "stop";
    private static final String STR_RU = "ru";
    private static final String STR_EN = "en";
    private static final String CURRENT_DIR = System.getProperty("user.dir");
        
    private static ResourceBundle fromFile(String fileName) {        
        try (FileInputStream fis = new FileInputStream(CURRENT_DIR + "/src/main/" + fileName)) {
            return new PropertyResourceBundle(fis);
        } catch (IOException ex) {
            Logger.getLogger(Part5.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ResourceBundle.getBundle(EN_PROP);
    }

    public static void main(String[] args) {
        
        ResourceBundle ruProp = fromFile(RU_PROP);
        ResourceBundle enProp = fromFile(EN_PROP);        
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while(!STR_STOP.equalsIgnoreCase(input = reader.readLine().toLowerCase())) {
                String[] arr = input.split(" ");
                if (arr.length > 1) {                    
                    switch (arr[1]) {
                        case STR_RU : System.out.println(ruProp.getString(arr[0]));
                        break;
                        case STR_EN : System.out.println(enProp.getString(arr[0]));
                        break;                    
                        default: System.out.println(STR_ERR);
                    }
                } else System.out.println(STR_ERR);
            }            
        } catch (IOException ex) {
            Logger.getLogger(Part3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int uslessMethodForJUnitTestCalculateBAB(int a, int b) {
        return b+a+b;
    }
}