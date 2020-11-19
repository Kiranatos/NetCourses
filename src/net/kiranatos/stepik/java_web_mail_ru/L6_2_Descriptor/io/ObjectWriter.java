package net.kiranatos.stepik.java_web_mail_ru.L6_2_Descriptor.io;

import java.io.*;

public class ObjectWriter {
    
    private static final String stringPath      = "./src/stepik/java_web_mail_ru/L6_2_Descriptor/io/string.bin";
    private static final String descriptorPath  = "./src/stepik/java_web_mail_ru/L6_2_Descriptor/io/descriptor.bin";
    
    public static void main(String[] args) {
        stringExample();
        descriptorExample();
    }

    private static void stringExample() {
        write("Ph'nglui mglw'nafh Cthulhu R'lyeh wgah'nagl fhtagn", stringPath);
        String fromFile = (String) read(stringPath);
        System.out.println(fromFile);
    }

    private static void descriptorExample() {
        Descriptor descriptor = new Descriptor("Anna", 15);
        write(descriptor, descriptorPath);
        Descriptor fromFile = (Descriptor) read(descriptorPath);
        System.out.println(fromFile);
    }

    public static void write(Object object, String fileName) {
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            BufferedOutputStream bout = new BufferedOutputStream(out);
            ObjectOutputStream dout = new ObjectOutputStream(bout);
            dout.writeObject(object);
            dout.flush();
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static Object read(String fileName) {
        try (FileInputStream out = new FileInputStream(fileName)) {
            BufferedInputStream bout = new BufferedInputStream(out);
            ObjectInputStream dout = new ObjectInputStream(bout);
            return dout.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
