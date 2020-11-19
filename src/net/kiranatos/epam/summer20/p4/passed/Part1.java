package net.kiranatos.epam.summer20.p4.passed;

import java.io.*;
import java.util.logging.*;
import java.util.regex.*;

public class Part1 {
        
    private static final String NAME_OF_FILE = "part1.txt";    
    private static final String REGEX_FIRST_LETTER = "(?iu)\\b[а-яa-zіїєё]{2}(?=[а-яa-zіїєё]{2,})";
    private static final Pattern PATTERN = Pattern.compile(REGEX_FIRST_LETTER);    
    
    public static void main(String[] args) {
        File file = Demo.checkFileOrCreateByDefault(NAME_OF_FILE);
        try (InputStream fileInputStream = new FileInputStream(file);
                Reader reader = new InputStreamReader(fileInputStream, Demo.CP1251);) {
            char[] arr = new char[(int)file.length()];
            int pointer = reader.read();
            for (int i = 0; (pointer > 0)&&(i < arr.length) ; i++) {
                arr[i] = (char)pointer;
                pointer = reader.read();
            }
            String line = new String(arr);
            
            Matcher mName = PATTERN.matcher(line);
            StringBuffer sb = new StringBuffer();
            while (mName.find()) {            
                mName.appendReplacement(sb, "");            
            }
            mName.appendTail(sb);
            System.out.println(sb.toString());
        } catch (IOException ex) {
            Logger.getLogger(Part1.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static int uslessMethodForJUnitTestMinus(int a, int b) {
        return a-b;
    }
}