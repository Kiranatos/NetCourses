package net.kiranatos.epam.summer20.p4.passed;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.*;

public class Demo {
    private static final InputStream STD_IN = System.in;
    static final String PATH_TO_FILE = System.getProperty("user.dir");
    static final String CP1251 = "Cp1251";
    static final String UTF_8 = "UTF-8";    
    private static final String[] SITH_CODE = {
        "Peace is a lie, there is only passion.",
        "Through passion, I gain strength.",
        "Through strength, I gain power.",
        "Through power, I gain victory.",
        "Through victory, my chains are broken.",
        "The Force shall free me.",
        " *** *** ",
        "Я - Серце Тьми.",
        "Я не знаю страху.",
        "Але вселяю його в душі своїх ворогів.",
        "Я - руйнівник світів.",
        "Я знаю могутність Темної Сторони.",
        "Я - вогонь ненависті.",
        "Весь всесвіт схиляється переді мною.",
        "Я довіряю себе пітьмі.",
        "Бо я знайшов справжнє життя.",
        "У загибелі Світла." };
    
    public static void main(String[] args) {
        System.out.println("=========================== PART1");
        Part1.main(new String[]{});
        System.out.println("=========================== PART2");
        Part2.main(new String[]{});
        System.out.println("=========================== PART3");
        
        System.setIn(new ByteArrayInputStream(
                "char^String^int^double^stop".replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
        Part3.main(new String[]{});
        
        System.setIn(STD_IN);
        System.out.println("=========================== PART4");
        Part4.main(new String[]{});
        System.out.println("=========================== PART5");
        
        System.setIn(new ByteArrayInputStream(
                "table ru^table en^apple ru^stop".replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
        Part5.main(new String[]{});
        
        System.setIn(STD_IN);
        System.out.println("=========================== PART6");
        
        System.setIn(new ByteArrayInputStream(
                "Latn^Cyrl^asdf^latn^cyrl^stop".replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
        Part6.main(new String[]{});
        
        System.setIn(STD_IN);
    }
    
    public static File checkFileOrCreateByDefault(String nameFile) {
        File file = new File(Demo.PATH_TO_FILE, nameFile);
        if (!file.exists()) {
            createFile(file);
        }
        return file;
    }
        
    static void writeToFile(String nameFile, String text) {  
        File file = new File(PATH_TO_FILE, nameFile);
        try (PrintWriter pw = new PrintWriter(file, CP1251)) {
            pw.write(text);            
        } catch (IOException  ex) {
            Logger.getLogger(Part1.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    static String readFromFile(File file) {         
        String string = "error";
        try (InputStream fileInputStream = new FileInputStream(file);
                Reader reader = new InputStreamReader(fileInputStream, Demo.CP1251);) {
            char[] arr = new char[(int)file.length()];
            int pointer = reader.read();
            for (int i = 0; (pointer > 0)&&(i < arr.length) ; i++) {
                arr[i] = (char)pointer;
                pointer = reader.read();
            }            
            string = new String(arr);        
        } catch (IOException ex) {
            Logger.getLogger(Part1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return string;
    }
    
    static String readFromFile(String nameFile) { 
        File file = new File(PATH_TO_FILE, nameFile);
        return readFromFile(file);
    }
    
    private static void createFile(File file) {        
        try (PrintWriter pw = new PrintWriter(file, Demo.CP1251)) {
            for (String s : SITH_CODE) {
                pw.write(s);
                pw.println();                
            }
        } catch (IOException  ex) {
            Logger.getLogger(Part1.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}