package net.kiranatos.epam.summer20.p4.passed;

import java.io.*;
import java.util.logging.*;
import java.util.regex.*;

public class Part3 {    
    private static final String NAME_OF_FILE = "part3.txt";    
    private static final String REGEX_STRING = "(?iu)[а-яa-zіїєё]{2,}";
    private static final String REGEX_CHAR = "(?iu)\\b[а-яa-zіїєё]{1}\\b";
    private static final String REGEX_DOUBLE = "[0-9]*\\.[0-9]*";
    private static final String REGEX_INT = "\\s[0-9]+\\s";
    private static final String STR_STOP = "stop";
    private static final String STR_CHAR = "char";
    private static final String STR_INT = "int";
    private static final String STR_DOUBLE = "double";
    private static final String STR_STRING = "string";
    
    static String getAppropriateString(String line, String regex) {        
        StringBuilder sb = new StringBuilder();
        Matcher mName = Pattern.compile(regex).matcher(line);
        while (mName.find()) {
            sb.append(mName.group().trim()).append(" ");
        }
        return sb.toString();        
    }

    public static void main(String[] args) {    
        String strFromFile = Demo.readFromFile(NAME_OF_FILE);
        
        String strStr = getAppropriateString(strFromFile, REGEX_STRING);
        String strChar = getAppropriateString(strFromFile, REGEX_CHAR);
        String strInt = getAppropriateString(strFromFile, REGEX_INT);
        String strDou = getAppropriateString(strFromFile, REGEX_DOUBLE);
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while(!STR_STOP.equalsIgnoreCase(input = reader.readLine().toLowerCase())) {                
                switch (input) {
                    case STR_CHAR : System.out.println(strChar);
                    break;
                    case STR_DOUBLE : System.out.println(strDou);
                    break;
                    case STR_INT : System.out.println(strInt);
                    break;
                    case STR_STRING : System.out.println(strStr);
                    break;                       
                    default: System.out.println("Incorrect input");
                }                
            }            
        } catch (IOException ex) {
            Logger.getLogger(Part3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int uslessMethodForJUnitTestMyltiply(int a, int b) {
        return a*b;
    }
}