package net.kiranatos.epam.summer20.p5.passed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Spam {
    private Thread[] threads;
    static String readForSonar;

    public static void main(final String[] args) {
        String[] messages = new String[] { "Java", "Python" , "C++", "C#", "Ruby", "Pascal"};
        int[] times = new int[] { 333, 1222, 900, 1500, 3000, 500  };
        Spam spam = new Spam(messages, times);
        spam.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            readForSonar = reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Spam.class.getName()).log(Level.SEVERE, null, ex);
        }

        spam.stop();

        for (int i = 0; i < spam.threads.length; i++) {
            try {
                spam.threads[i].join();
            } catch (InterruptedException e) {
                Logger.getLogger(Spam.class.getName()).log(Level.SEVERE, null, e);
                Thread.currentThread().interrupt();
            }
        }
    }

    public Spam(final String[] messages, final int[] delays) {
        if ((messages != null) && (delays != null) && (messages.length == delays.length)) {
            threads = new Thread[messages.length];
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Worker(messages[i], delays[i]);
            }
        }
    }

    public void start() {
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }

    public void stop() {
        for (int i = 0; i < threads.length; i++) {
            threads[i].interrupt();
        }
    }

    private static class Worker extends Thread {
        int delay;
        String message;

        public Worker(String message, int delay) {
            this.delay = delay;
            this.message = message;
        }

        @Override
        public void run() {
            while (!this.isInterrupted()){
                System.out.println(message);
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Spam.class.getName()).log(Level.SEVERE, null, ex);
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
