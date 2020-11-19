package net.kiranatos.stepik;

public class ForPrimitiveTest {
    
    public static void main(String[] args) {
        
        int a = 1;
        int b = 2;
        int c = 3;
        boolean d = --c < b++ || a == b % c && a++ == 2;
        
        c = 10;
        
        a = b % c;

        System.out.println(" a = " + a + " b = " + b + " c = " + c + " d = " + d);
        
        // \u000a\u0020System\u002eout.\u0070rintln("Hello Kitty!"\u0029;
        
        bitMoves();
        
    }
    
    private static void bitMoves() {
        //http://arduino.on.kg/bitShift
        //https://habrahabr.ru/post/225901/
        System.out.println("****************************************");
        int a = 3;
        System.out.println("Битовый сдвиг <<");
        System.out.println(a<<1); //3 * 2^1 = 6
        System.out.println(a<<2); //3 * 2^2 = 12
        System.out.println(a<<3); //3 * 2^3 = 24
        System.out.println(a<<-2);//???
        System.out.println("Битовый сдвиг >>");
        System.out.println("Битовый сдвиг <<<");
    }
    
}
