package net.kiranatos.epam.summer20.p1.myexperiment2;

public interface MyMBean {
    String getMyName();
    void setSomeValue(int value1);
    int getSomeValue();
    void writeToConsole(String message);
    String concat(String str1, String str2);    
}
