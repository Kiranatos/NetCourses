package net.kiranatos.epam.summer20.p5.passed;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part5 {
    static final String FILE_NAME = "part5.txt";
    static int k = 10;
    static Thread[] threads = new Thread[k];
    static RandomAccessFile fileRandomAccessFile;

    static class MyTread extends Thread {
        @Override
        public void run() {
            synchronized (fileRandomAccessFile) {
            try {
                for (int i = 0; i < 20; i++) {
                    fileRandomAccessFile.writeBytes(this.getName());
                }
                fileRandomAccessFile.writeBytes(System.lineSeparator());
            } catch (IOException e) {
                Logger.getLogger(Part5.class.getName()).log(Level.SEVERE, null, e);
            }}
        }
    }

    public static void main(final String[] args) {
        File file = new File(Demo.PATH_TO_FILE, FILE_NAME);
        if (file.exists()) {
            try {
                Files.deleteIfExists(Paths.get(file.getPath()));
            } catch (IOException e) {
                Logger.getLogger(Part5.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        for (int i = 0; i < k; i++) {
           threads[i] = new MyTread();
           threads[i].setName(String.valueOf(i));
        }

        try {
            fileRandomAccessFile = new RandomAccessFile(file, "rw");
        } catch (IOException e) {
            Logger.getLogger(Part5.class.getName()).log(Level.SEVERE, null, e);
        }

        for (int i = 0; i < k; i++) {
            threads[i].start();
            Demo.sleepMilliseconds(1);
        }

        for (int i = 0; i < k; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Logger.getLogger(Part5.class.getName()).log(Level.SEVERE, null, e);
                Thread.currentThread().interrupt();
            }
        }

        try {
            fileRandomAccessFile.seek(0);
            for (int i = 0; i < fileRandomAccessFile.length(); i++) {
                System.out.print((char)fileRandomAccessFile.read()); // читает с той позиции, где остановился курсор
            }
            fileRandomAccessFile.close();
        } catch (IOException e) {
            Logger.getLogger(Part5.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}