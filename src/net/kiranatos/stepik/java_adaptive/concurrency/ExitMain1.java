package net.kiranatos.stepik.java_adaptive.concurrency;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
Make the corresponding change in the program below to allow the program to 
terminate after all threads are completed.
*/

public class ExitMain1 {
    private static final int POOL_SIZE = 50;
    public static void main(final String[] args) throws Exception {
        final ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            executor.submit(() -> System.out.printf("Running %s%n", Thread.currentThread().getName()));
        }
        executor.shutdown();
        //executor.shutdownNow();
        //executor.awaitTermination(10, TimeUnit.SECONDS);
    }
}