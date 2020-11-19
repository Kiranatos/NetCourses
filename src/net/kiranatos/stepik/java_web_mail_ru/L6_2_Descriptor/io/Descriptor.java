package net.kiranatos.stepik.java_web_mail_ru.L6_2_Descriptor.io;

import java.io.Serializable;

public class Descriptor implements Serializable {
    private final String name;
    private final int age;

    public Descriptor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Descriptor{name='" + name + "', age=" + age + '}';
    }
}
