package net.kiranatos.linkedin.c001.lesson1_2_3;

import java.util.Scanner;

/* Course: Learning Java
By: Kathryn Hodge
https://www.linkedin.com/learning/learning-java-4/what-you-should-know?u=2113185 */

public class NameAndAge {
    public static void main(String[] args) {
        String prompt =  args[0];
        System.out.println(prompt);
        String name;
        int age;
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        age = in.nextInt();
        System.out.println("Hello, " + name + " nice to meet you\nYou are "
                + age + " years old!");
    }
}