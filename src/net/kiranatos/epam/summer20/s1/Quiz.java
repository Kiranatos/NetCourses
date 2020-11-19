package net.kiranatos.epam.summer20.s1;

// Check Video in YouTube

public class Quiz {
    public static void main(String[] args) {
        System.out.println("Question 1 of 37: Which of the following statement are true for this code?");
        String multiStrArr[][] = new String[][]{
            {"A","B"},
            null,
            {"Jan", "Feb", null},
        };
        System.out.println(multiStrArr[2].length);
        //System.out.println(multiStrArr[1][1]);
        System.out.println(multiStrArr[2][2]);
        
        System.out.println("Question 2 of 37: What will be the result of the following code:");
        Main.main2();
        
        System.out.println("Question 3 of 37: What will be the result of the following code:");
        //BoxPrinterTest.main3();
        
        System.out.println("Question 4 of 37: What is the result of the following code?");
        int i = 5;
        i--;
        System.out.println(i++);
        
        System.out.println("Question 5 of 37: What is the result of the following code fragment?");
        int c = 7;
        int result = 4;
        result +=++c;
        System.out.println(result);
        
        System.out.println("Question 6 of 37: What will happen when you attempt to compile and run the following code?");
        A.main6();
        
        System.out.println("Question 7 of 37: Given the following definition of the classes Animal, Lion and Jumpable, select the correct combinations of assignments of a variable?");
        //Jumpable var1 = new Jumpable();
        //Jumpable var4 = new Animal7();
        //Lion var3 = new Animal7();
        Animal7 var2 = new Animal7();
        Jumpable var5 = new Lion();
        
        System.out.println("Question 8 of 37: What will be the result of the following code:");
        String varWithSpaces = " AB CB ";
        System.out.print(":");
        System.out.print(varWithSpaces.trim());
        System.out.print(":");
        System.out.println("");
        
        System.out.println("Question 9 of 37: What will be the result of the following code:");
        String letters = "ABCAB";
        System.out.println(letters.startsWith("Ab"));
        
        System.out.println("Question 10 of 37: What will be the result of the following code?");
    }    
}

/************ Question 7 of 37 **********************/
interface Jumpable{}
class Animal7{}
class Lion extends Animal7 implements Jumpable {}

/************ Question 6 of 37 **********************/
class A {
    void method1(A obj){
        System.out.println("method is invoked");
    }
    void method2(){
        System.out.println("method is invoked");
    }
    public static void main6() {
        A s1 = new A();
        s1.method2();        
    }
}

/************ Question 3 of 37 **********************/
class BoxPrinter {
    private Object val;
    public BoxPrinter(Object arg){
        val = arg;
    }
    public Object getValue(){
        return val;
    }
}
class BoxPrinterTest {
    public static void main3() {
        BoxPrinter value1 = new BoxPrinter(new Integer(10));
        Integer intValue1 = (Integer)value1.getValue();
        System.out.println(intValue1);
        BoxPrinter value2 = new BoxPrinter("Hello world");
        Integer intValue2 = (Integer)value2.getValue();
        System.out.println(intValue2);
    }
}

/************ Question 2 of 37 **********************/
class Animal2 {}
class Dog extends Animal2 {}
class Cat extends Animal2 {}
class Main {
    static int countOfCats = 0;
    public static void main2() {
        Animal2[] animals = {new Cat(), new Dog(), new Cat()};
        for (Animal2 a : animals) {
            if (a instanceof Cat)
                countOfCats++;            
        }
        System.out.println(countOfCats);
    }
}