package net.kiranatos.stepik.java_adaptive.concurrency;

/*
3.128 Make the following code thread-safe (ex. 1)
Aliaksandr Kazlou, из курса Adaptive Java 
Make the following code below thread safe.
Hint: consider one of the low level memory synchronization mechanism.
 */
import java.util.concurrent.TimeUnit;
public class ThreadSafe1Quiz {
    public static void main(final String[] args) throws Exception {
        final ThreadSafe1 runnable = new ThreadSafe1();
        new Thread(runnable).start();
        TimeUnit.SECONDS.sleep(5);
        runnable.cancel();
    }
    public static class ThreadSafe1 implements Runnable {
        private volatile boolean done;
        @Override
        public void run() {
            while (!done) {
                System.out.println("Running");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (final InterruptedException ex) {
                    // reset the interruption status
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Done");
        }
        public void cancel() {
            done = true;
        }
    }
}