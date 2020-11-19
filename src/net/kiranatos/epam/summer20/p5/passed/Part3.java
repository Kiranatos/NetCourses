package net.kiranatos.epam.summer20.p5.passed;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Part3 {
    private int counter;
    private int counter2;
    private int numberOfThreads;
    private int numberOfIterations;
    private Thread[] threads;

    public Part3(int numberOfThreads, int numberOfIterations) {
        this.numberOfThreads = numberOfThreads;
        this.numberOfIterations = numberOfIterations;
        threads = new Thread[numberOfThreads];
        counter = numberOfThreads;
        counter2 = numberOfIterations;
    }

    public void compare() {
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(this::inside);
            threads[i].start();
        }
        waiting();
    }

    public void compareSync() {
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                synchronized (this) {
                    inside();
                }
            });
            threads[i].start();
        }
        waiting();
    }

    public static void main(final String[] args) {
        Part3 part3 = new Part3(5, 5);
        part3.compare();
        part3.compareSync();
    }



    private void inside() {

                for (int j = 0; j < numberOfIterations; j++) {
                    System.out.println(counter == counter2);
                    counter++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Logger.getLogger(Part3.class.getName()).log(Level.SEVERE, null, e);
                        Thread.currentThread().interrupt();
                    }
                    counter2++;
                }




    }

    private void waiting() {
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Logger.getLogger(Part3.class.getName()).log(Level.SEVERE, null, e);
                Thread.currentThread().interrupt();
            }
        }
    }
}