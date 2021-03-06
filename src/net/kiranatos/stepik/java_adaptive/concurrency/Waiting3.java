package net.kiranatos.stepik.java_adaptive.concurrency;

/*
2.12 Waiting for the threads to complete (ex. 2)
Aliaksandr Kazlou, из курса Java. Java concurrency
Make the necessary changes to have the counter set always to 50 when it is printed.
 */
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
public class Waiting3 {
    private static final int POOL_SIZE = 50;
    public static void main(final String[] args) throws Exception {
        final ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        final AtomicInteger counter = new AtomicInteger(0);
        final CyclicBarrier ready = new CyclicBarrier (POOL_SIZE, () -> System.out.println(counter.get()));
        for (int i = 0; i < POOL_SIZE; i++) {
            executor.submit(() -> {
                counter.incrementAndGet();
                System.out.printf("Thread %s is completed%n", Thread.currentThread().getName());
                try {
                    ready.await();
                } catch (final Exception ex) {
                    if (ex instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }
        executor.shutdown();
    }
}
