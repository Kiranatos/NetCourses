package net.kiranatos.stepik.java_basic.third_week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ThirdWeek {
    
    public static void main(String[] args) {
       /* A a = new A();
        B b = new B();
        a = (A) b;
        
        S c = new C();
        a = (A) c;*/
       
       List<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
       Set<String> nameSet = new TreeSet<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
       for(String s: nameSet) { System.out.println(s); }
    }
    
}


class Z {}
class X extends Z {}

class A implements S {
    public Z metod1(){ return null; }
}

class B extends A {
    
    public X metod1(){ return null; }
}

class C implements S{}

interface S {}