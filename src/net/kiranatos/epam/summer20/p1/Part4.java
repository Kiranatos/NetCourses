package net.kiranatos.epam.summer20.p1;

/* Task 4 Class name: com.epam.rd.java.basic.practice1.Part4
——————————————————————————————
Write a class that implements functionality of defining the greatest common 
divisor of two whole positive numbers passed to the application as the command 
line parameters. */

public class Part4 {
    public static void main(String[] args) {
        if (2 != args.length) System.out.println("!!! Error 01 no elem !!!");
        int a = 0, b = 0;
        try {
                a = Math.abs(Integer.valueOf(args[0]));
                b = Math.abs(Integer.valueOf(args[1]));
            } catch (NumberFormatException e){ 
                System.out.println("!!! Error 02 no elem !!!");                
            }
        
//        Demo.showMe(getNOD(a,b));
//        Demo.showMeLikeLog(getNOD(a,b));
//        Demo.showMeFaster(getNOD(a,b));
//        Demo.showMeBufferedWriter(getNOD(a,b));
//        Demo.showMePrintStream(getNOD(a,b));
//        java.io.PrintStream myOut = System.out;
//        myOut.format("%d",getNOD(a,b));
//        System.out.format("%d",getNOD(a,b));
    }
    
    private static int getNOD(int a, int b) {
        if (a == b) return a;
        if (a == 0) return b;
	if (b == 0) return a;
        
        if ((~a & 1) != 0) {
            if ((b & 1) != 0) return getNOD(a >> 1, b);
            else return getNOD(a >> 1, b >> 1) << 1;
        }
        if ((~b & 1) != 0) return getNOD(a, b >> 1);
        if (a > b) return getNOD((a - b) >> 1, b);
        return getNOD((b - a) >> 1, a);
    }
}