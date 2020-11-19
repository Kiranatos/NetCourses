package net.kiranatos.stepik.java_basic.fifth_week;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Path path = Paths.get("F:\\test1.txt");        
        InputStream iS1 = new FileInputStream(path.toFile());
        InputStream iS2 = Files.newInputStream(path);
        //InputStream iS3 = new FileInputStream(path);
        //InputStream iS4 = Paths.newInputStream(path);
        
        File file1 = new File("F:\\test1.txt");
        System.out.println(file1.exists());
        System.out.println(file1.isFile());
        System.out.println(file1.isDirectory());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());
        
        File file3 = new File("E:\\My Files\\Завантаження\\Видео");
        String[] sss = file3.list();
        File[] fff = file3.listFiles();
        
        //Создание директории
        File dir = new File("a");
        boolean success = dir.mkdir(); // может создать только одну
        File dir2 = new File("a/b/c/d"); 
        success = dir2.mkdirs(); // длясозданиянескольких
        //Удаление
        dir.delete(); //Если в папке есть файлы, то удаления не произойдёт
        //Переименование
        success = file3.renameTo(file1); //Также может получится перенос файла
        
        System.out.println("================================");
        
        
        Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);
        writer.write("Ы");        
        writer.flush();
        
        System.out.println();

  
    }
}
