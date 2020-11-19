package net.kiranatos.stepik.java_adaptive.concurrency;

/*
3.123 Terminate a thread
 Aliaksandr Kazlou, из курса Adaptive Java
What is the legal way to terminate the Java thread in the context of the program below?
*/

import java.util.concurrent.TimeUnit;
public class TerminateThread {
    public static void main(final String[] args) throws Exception {
        final Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted() ) {
                try {
                    System.out.println("Running");
                    TimeUnit.SECONDS.sleep(1);
                } catch (final InterruptedException ex) {
                    break;
                }
            }
            System.out.println("Terminated");
        });
        thread.start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Terminate a thread");
        thread.interrupt();
    }
}