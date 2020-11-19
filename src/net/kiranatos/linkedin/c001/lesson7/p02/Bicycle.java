package net.kiranatos.linkedin.c001.lesson7.p02;

/* Course: Learning Java
By: Kathryn Hodge
https://www.linkedin.com/learning/learning-java-4/what-you-should-know?u=2113185 */

public interface Bicycle {
    //  wheel revolutions per minute
    void changePedalRate(int newValue);

    void changeGear(int newValue);

    void speedUp(int increment);

    void applyBrakes(int decrement);
}


