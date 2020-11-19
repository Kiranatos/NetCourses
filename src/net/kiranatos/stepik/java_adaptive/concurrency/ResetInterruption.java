package net.kiranatos.stepik.java_adaptive.concurrency;

/*
Java doesn't provide any safe mechanism to stop the running thread, 
instead it provides so called interruption, which is a policy 
(or otherwise could be called the cooperation) between the running threads.

Although if the policy is unknown, or the running thread doesn't handle 
interruption exception, it should not swallow it, but instead reset 
the interruption status back 
(as methods which could throw InterruptedException clear the interruption 
status which has to be reset back).

So, in the code below how do you restore and check for the interruption 
status of the running thread?
 */
import java.util.concurrent.TimeUnit;
public class ResetInterruption implements Runnable {
    public static void main(final String[] args) throws Exception {
        final Thread thread = new Thread(new ResetInterruption());
        thread.start();
        thread.join();
        System.out.printf("Interrupted %b%n", thread.isInterrupted() );
    }
    @Override
    public void run() {
        try {
            // The interrupted status of the current thread is cleared when InterruptedException is thrown by sleep() method.
            TimeUnit.SECONDS.sleep(10);
        } catch (final InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}