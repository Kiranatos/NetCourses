package net.kiranatos.stepik.java_web_mail_ru.L7_2;

public class CallCounter {
    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}
