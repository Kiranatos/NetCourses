package net.kiranatos.stepik;

public class SolveMe {
    public static void main(String[] args) {
        boolean x;
        x = one() == 1 || two() == 2 || three() == 6;
    }
    
    static int one()    { System.out.println("one");    return 1;}
    static int two()    { System.out.println("two");    return 2;}
    static int three()  { System.out.println("three");  return 3;}
    static int four()   { System.out.println("four");   return 4;}
    static int five()   { System.out.println("five");   return 5;}
    static int six()    { System.out.println("six");    return 6;}
}