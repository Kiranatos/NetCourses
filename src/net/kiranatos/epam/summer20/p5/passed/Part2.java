package net.kiranatos.epam.summer20.p5.passed;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part2 {
    private static final InputStream STD_IN = System.in;

    public static void main(final String[] args) {
        System.setIn(new MyInputStream());
        Thread t = new Thread(() -> Spam.main(new String[]{}));
        t.start();


        try {
            t.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Part2.class.getName()).log(Level.SEVERE, null, ex);
            Thread.currentThread().interrupt();
        }

        System.setIn(STD_IN);
    }

    static class MyInputStream extends InputStream {

        @Override
        public int read() throws IOException {
            int a = -1;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Part2.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt();
            }
            return a;
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            return -1;
        }
    }
}