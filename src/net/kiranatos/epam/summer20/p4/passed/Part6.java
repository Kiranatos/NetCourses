package net.kiranatos.epam.summer20.p4.passed;

import java.io.*;
import java.util.logging.*;

public class Part6 {
    private static final String NAME_OF_FILE = "part6.txt";
    private static final String STR_STOP = "stop";
    private static final String STR_CYRL = "cyrl";
    private static final String STR_LATN = "latn";
    private static final String REGEX_CYRL = "(?iu)[а-яіїєёы]+";
    private static final String REGEX_LATN = "(?iu)[a-z]+";
    
    
    public static void main(String[] args) {
        File file = Demo.checkFileOrCreateByDefault(NAME_OF_FILE);
        
        String strFromFile = Demo.readFromFile(file);
        
        String strCyrl = "Cyrl: " + Part3.getAppropriateString(strFromFile, REGEX_CYRL);
        String strLatn = "Latn: " + Part3.getAppropriateString(strFromFile, REGEX_LATN);        
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while(!STR_STOP.equalsIgnoreCase(input = reader.readLine().toLowerCase())) {                
                switch (input) {
                    case STR_CYRL : System.out.println(strCyrl);
                    break;
                    case STR_LATN : System.out.println(strLatn);
                    break;                    
                    default: System.out.println("smth: Incorrect input");
                }                
            }            
        } catch (IOException ex) {
            Logger.getLogger(Part3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int uslessMethodForJUnitTestAdd(int a, int b) {
        return a+b;        
    }
}