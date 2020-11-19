package net.kiranatos.epam;

import java.math.BigDecimal;
import java.util.Objects;

/*
урывки задач from old, ruined epam course "Java. Fundamentals. Januaru 1 2019"
https://learn.by/
*/

public class RuinedCourse_001 {
    static int z02 = 2;
    public static void result(int i){ i *= 10; z02 += 2; }
    
    public static class A {
        int a;
        A(int a) { this.a = a; }
    }
    
    public static void main(String[] args) {
        char z01 = '1';
        result(z01);
        System.out.println(z01 + " " + z02);
        System.out.println("\n==============================");
        int _int, _2_, $int;
        System.out.println("==============================");
        double m1 = 5_000_000.75;
        int m4 = 5_000_000;
        int m5 = 0_10;
        System.out.println("==============================");
        double d1 = 0.0f;
        Double d2 = new Double(.0f);
        // ERROR Double d3 = 0.0f;
        // ERROR Double d4 = new Double("1L");
        Double d5 = 0.d;
        // ERROR Double d6 = 1L;
        System.out.println("==============================");
        int i1 = Integer.parseInt("14");
        Integer i2 = 85;
        // ERROR int i3 = Integer.decode('12');
        int i4 = Integer.valueOf("21");
        // ERROR int i5 = Integer.valueOf(null);
        int i6 = new Integer("15");
        System.out.println("==============================");
        // ERROR System.out.println(new Integer(null));
        // ERROR System.out.println(new String(null));
        System.out.println(new String("null"));
        // ERROR System.out.println((char[])null);
        System.out.println((true ? null : 0));
        System.out.println((String)null);
        System.out.println("==============================");
        Byte b001 = new Byte("3");
        System.out.println(b001.floatValue() + " " + b001.getClass().getName());
        System.out.println("==============================");
        Double d001 = Double.POSITIVE_INFINITY;
        double d002 = d001.intValue() + Double.NEGATIVE_INFINITY;
        System.out.println(d002);
        System.out.println("==============================");
        Integer number = 32;
        // Binary number format
        String convert = Integer.toBinaryString(number);
        System.out.print(convert + " ");
        // Octagonal number format
        convert = Integer.toOctalString(number);
        System.out.print(convert + " ");
        // Hexadecimal number format
        convert = Integer.toHexString(number).toUpperCase();
        System.out.print(convert + " ");
        System.out.println("\n==============================");
        int aa = 129;
        byte bb = 3;
        Object aabb01 = (byte)aa + bb;
        Object aabb02 = (byte)(aa + bb);
        System.out.println(aabb01.getClass().getName() + " value: " + aabb01); 
        System.out.println(aabb02.getClass().getName() + " value: " + aabb02); 
        System.out.println("\n==============================");
        long a002 = 2147483647000L;
        int b002 = 1;
        b002 += a002;
        Object ab = (Object) b002;
        System.out.println(ab.getClass().getName() + " value: " + ab);
        System.out.println("\n==============================");
        long ax = Long.remainderUnsigned(-2,3);
        int bx = Integer.remainderUnsigned(-2,3);
        int cx = -2 % 3;
        System.out.print(ax + " " + bx + " " + cx);
        System.out.println("\n==============================");
        double ac, bc, cc, dc, sum, sumBC, comAB;
        ac = -3.0 / 0;
        bc =  3.0 / 0;
        cc = 0 / 4.0;
        dc = 0 / 0.0;
        sum = ac + bc + cc + dc;
        sumBC = bc + cc;
        comAB = ac * bc;
        System.out.print(sum + " " + sumBC + " " + comAB);
        System.out.println("\n==============================");
        BigDecimal b1v = new BigDecimal("23.43");
        BigDecimal b2v = new BigDecimal("23.43");
        BigDecimal b3v = new BigDecimal("24");
        System.out.println(b1v.compareTo(b2v) == 0); //1
        System.out.println(b1v.compareTo(b3v) == 1); //2
        System.out.println(b1v.equals(b2v)); //3
        System.out.println(b1v.equals(new BigDecimal("23.43"))); //4
        System.out.println(b1v == b2v); //5
        b2v = b2v.add(new BigDecimal("0.57"));
        System.out.println(b3v.equals(b2v)); //6
        System.out.println("\n==============================");
        Integer i1v = 128;
        Integer i2v = 128;
        System.out.print(i1v == i2v);
        Integer i3v = 127;
        Integer i4v = 127;
        System.out.print(i3v == i4v);
        System.out.println("\n==============================");
        sum = 0;
        for(int i = 1, sum3 = 0; i <= 100; sum += i++);
        System.out.println("sum = " + sum);
        int ik = 1;
        sum = 0;
        for( ; ik <= 100 ; ) sum += ik++;
        System.out.println("sum = " + sum);
        System.out.println("\n========== Home task: investigate Object and Objects classes ====================");
        A ab1 = new A(1);
        A ab2 = new A(1);
        System.out.print(ab1 == ab2);
        System.out.print(", " + ab1.equals(ab2));
        System.out.print(", " + Objects.equals(ab1, ab2));
        System.out.print(", " + Objects.deepEquals(ab1, ab2));
        System.out.println("\n==============================");
        
  
    }    
}
