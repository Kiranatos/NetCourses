package net.kiranatos.stepik.java_adaptive.concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
Make the following code below thread safe.
Hint: there are various concurrent data structures available in java.util.concurrent package.
 */
public class ThreadSafe6Quiz {
    public static class ThreadSafe6 {
        private final Map< String, String > data = new ConcurrentHashMap<>();
        public void putIfAbsent(final String key, final String value) {
            data.putIfAbsent(key, value);
        }
    }
}
