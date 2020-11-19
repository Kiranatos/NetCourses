package net.kiranatos;

public class Test {
   static  final int number = 10;
   
    
   public static void main(String ARGS[]) {
//        Test  t = new Test();
//        int number = 15;
//        System.out.println(t.test(number, Test.number));
//boolean a = true;
//boolean b = true;
//boolean c = false;
//       System.out.println(!a||b&&c);
//       

//       for (short i = 32766; i < 032767; i++) {
//           System.out.print(i);
//           System.out.println("dd");
//           
C c = new C();
c.print();
       }
   }

   

class A {
    public void print(){
        System.out.println("A print()");
    }
}

class B extends A {
    public void print(){
        System.out.println("B print()");
    }
}

class C extends B {
    public void print(){
        super.print();                
        System.out.println("C print()");
    }
}

