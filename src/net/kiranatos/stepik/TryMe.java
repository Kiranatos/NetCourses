package net.kiranatos.stepik;

public class TryMe {
    public static void main(String[] args) {
        int x = 0;
        x = one() + four() % three() - (two() + one());
        System.out.println(x);
    }

    static int one() { System.out.print("fee"); return 1;}
    static int two() { System.out.print("fi"); return 2;}
    static int three() { System.out.print("fo"); return 3;}
    static int four() { System.out.print("fum"); return 4;}
}