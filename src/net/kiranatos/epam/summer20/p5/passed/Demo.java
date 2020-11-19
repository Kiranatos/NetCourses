package net.kiranatos.epam.summer20.p5.passed;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo {
    static final String PATH_TO_FILE = System.getProperty("user.dir");
    static final String CP1251 = "Cp1251";
    static final String UTF_8 = "UTF-8";

    static void writeToFile(String nameFile, String text) {
        File file = new File(PATH_TO_FILE, nameFile);
        try (PrintWriter pw = new PrintWriter(file, CP1251)) {
            pw.write(text);
        } catch (IOException ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static int getRandom(int n){
        return new java.security.SecureRandom().nextInt(n);
    }

    /**
     * Усыпить поток на @milliseconds
     */
    public static void sleepMilliseconds(long milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Part1.main(new String[]{});
    }
}
