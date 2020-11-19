package net.kiranatos.epam.summer20.s2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class QuizScreeningTwo {
    public static void main(String[] args) {
        System.out.println("1 of 30. What will be the result of the following code fragment?");
//        try (FileReader inputFile = new FileReader(new File(args[0]))){     // Line1
//        } catch (FileNotFoundException | IOException e){                    // Line2
//            e.printStackTrace(); 
//        }
        /*
        Compilation succeeds
        Compilation error at //Line2
        Compilation error at //Line1 and at //Line2
        Compilation error at //Line1
        */
        
        System.out.println("\n2 of 30. What, inserted at //Line1, will sort the keys in the props HashMap?");
        HashMap props = new HashMap();
        props.put("key45", "some value");
        props.put("key12", "some other value");
        props.put("key39", "yet another value");
        Set set = props.keySet();
        //Line1        
        /*
        s = new TreeSet(s);
        s = new SortedSet(s);
        None of the above
        Collections.sort(s);
        */
        System.out.println(set);
        
        System.out.println("\n3 of 30. What will be the result of the following code fragment?");
        String[] students = {"Shreya", "Joseph"};
        try { System.out.println(students[0] + ""); }
//        System.out.println(students[1]);
        catch (ArrayIndexOutOfBoundsException e){ 
            System.out.println("Exception"); 
        }
        /*
        Shreya
        Shreya Joseph
        Compilation error
        Exception
        */
        
        System.out.println("\n4 of 30. What will be the result of the following code?");
        Deque<String> myDeque = new ArrayDeque<>();
        myDeque.add("one");
        myDeque.add("two");
        myDeque.add("three");
        System.out.println(myDeque.remove());
        /*
        The program runs, but prints no output
        one
        Compilation error
        three
        */
        System.out.println(myDeque);
        
        System.out.println("\n5 of 30. What will be the result of the following code?");
        Computer c = new Computer();
        c.storeIt(c);
        /*
        Exactly two objects are serialized
        Exactly one object is serialized
        exc
        Compilation error
        done
        */
        
        System.out.println("\n6 of 30. What will be the result of the following code?");
        //Test2.main2(null);
        /*
        In run method - thread name is: thread-0
        Runtime error of type IllegalThreadStateException
        Compilation error in //Line1
        In run method - thread name is: thread-0; In main method - thread name is: thread-0
        */
        
        System.out.println("\n7 of 30. What will be the result of the following code?");
        Morecombe.main2(null);
        /*
        Compilation error, class Turing has no start() method
        Compilation error due to malformed parameter to go() method
        Runtime error
        0 1
        */
        
        System.out.println("\n8 of 30. Which of these statements are true with respect to Thread and Runnable?");
        /*
        Thread is an abstract class that extends the abstract base class Runnable
        Thread is an abstract class
        Thread provides a default implementation for the run() method
        Runnable is an abstract class
        */
        
        System.out.println("\n9 of 30. Which are true, when writing a RecursiveTask subclass?");
        /*        
        A compute() and join() methods should be invoked on the same task
        A fork() and join() methods should be invoked on the same task
        A fork() and compute() methods should be invoked on the same task
        A compute() method should be invoked before fork() method
        A join() method should be invoked after fork() method
        A fork() method should be invoked before compute() method 
        */
        
        System.out.println("\n10 of 30. What will be the result of the following code?");
        MultipleReturn.main2(null);
        /*
        Compilation error
        20
        0
        10
        */
        
        System.out.println("\n11 of 30. What will be the result of the following code fragment, given that bw is a valid reference to a BufferedWriter?");
        BufferedWriter bw;
//        BufferedWriter b1 = new BufferedWriter(new File("f")); // Line1
//        BufferedWriter b2 = new BufferedWriter(new FileWriter("f1")); // Line2
//        BufferedWriter b3 = new BufferedWriter(new PrintWriter("f2")); // Line3
//        BufferedWriter b4 = new BufferedWriter(new BufferedWriter(bw)); // Line4
        /*
        Compilation error on multiple lines
        Compilation error only at the //Line2
        Compilation error only at the //Line3
        Compilation succeeds
        Compilation error only at the //Line1
        Compilation error only at the //Line4
        */
        
        System.out.println("\n12 of 30. What will be the result of the following code (assuming that the serializeBanana() and the deserializeBanana() methods will correctly use Java serialization)?");
        Banana.main2(null);
        /*
        restore 453
        restore 450
        restore 403
        restore 400
        */
        
        System.out.println("\n13 of 30. Consider the following program and choose the appropriate option?");
//        Map<String,int> map = new HashMap<int,String>(); //Line1
        Map<String,String> map2 = new HashMap<String,String>(); //Line2
        Map<String,String> map3 = new HashMap<>(); //Line3
//        Map<> map4 = new HashMap<String,String>(); //Line4
        /*
        Statement in //Line2 and //Line3 will compile successfully
        Statement in //Line3 and //Line4 will compile successfully
        Statement in //Line4 and //Line1 will compile successfully
        Statement in //Line1 and //Line2 will compile successfully
        */
        
        System.out.println("\n14 of 30. What will be the result of the following code?");
        //OverAndOver.main2(null);
        /*
        12
        Compilation error
        1234
        Exception output only
        123
        */
        
        System.out.println("\n15 of 30. What will be the result of the following code?");
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("apple");
        myList.add("carrot");
        myList.add("banana");
        myList.add(1, "plum");
        System.out.println(myList);
        /*
        [plum, apple, carrot, banana]
        [plum, banana, carrot, apple]
        [apple, banana, carrot, plum]
        [apple, plum, banana, carrot]
        [apple, plum, carrot, banana]
        */
        
        System.out.println("\n16 of 30. What is the range of thread priority values and what is the default priority value of a thread?");
        /*
        The range of thread priorities is 1 to 10; the default thread priority is 5
        The range of thread priorities is 1 to 5; the default thread priority is 3
        All threads have equal priority of 1; hence, the default thread priority is also 1
        Threads are implemented using co-operative multi-threading approach, and not pre-emptive multithreading; as a result, they do not have any priority in Java
        The range of thread priorities is 1 to 10; the default priority is 6
        */
        
        System.out.println("\n17 of 30. Which of the following option correctly describes the behavior of this fragment code, given that srcFile and dstFile are Strings?");
        String srcFile = "deleteBanan.ser";
        String dstFile = "deleteBanan2.ser";
        try (BufferedReader inputFile = new BufferedReader(new FileReader(srcFile));
                BufferedWriter outputFile = new BufferedWriter(new FileWriter(dstFile))){ //TRY
            int ch = 0;
            while((ch=inputFile.read())!=-1){
                outputFile.write((char)ch);
            }
        } catch(/*FileNotFoundException |*/ IOException exception){ //MULTI_CATCH
            System.err.println("Error in opening or processing file " + exception.getMessage());
        }
        /*
        Compilation error in line marked //MULTI_CATCH because IOException is the base class for FileNotFoundException
        This program will get into an infinite loop because the variable ch is declared as int instead of char
        This program will get into an infinite loop because the condition check for end-of-stream (checking != -1) is incorrect
        Compilation error in line marked //TRY because you need to use , (comma) instead of ; (semi-colon) as separator for opening multiple resources
        */
        
        System.out.println("\n18 of 30. Which of the following statements is true, given this fragment of code?");
        List<Integer> l1 = Arrays.asList(1,2,3);
        List<Integer> l2 = Arrays.asList(4,5,6);
        List<Integer> l3 = Arrays.asList();
        //Stream.of(l1,l2,l3).map(x->x+1).flatMap(x->x.stream()).forEach(System.out::print);
        /*
        The code throws an exception
        The code compiles but prints stream references
        The code does not compile
        The code compiles and prints 123456
        The code compiles and prints 234567
        The code compiles but does not print anything
        The code runs infinitly
        */
        
        System.out.println("\n19 of 30. What will happen, if assume that a thread acquires a lock on an object obj and the same thread again attempts to acquire the lock on the same object obj?");
        /*
        An exception will be thrown AlreadyLockAcquiredEsception
        It will result in a deadlock
        An exception will be thrown IllegalMonitorStateException
        Such an attempt will succeed
        */
        
        System.out.println("\n20 of 30. What will be the result of the following code?");
        LockUnlock.main2(null);
        /*
        Runtime error of type UnsupportedOperationException in the line //UNLOCK_1;
        Runtime error of type IllegalMonitorStateException in the line //UNLOCK_1;
        Lock 1 Critical section 1 Lock 2 Critical section 2 Unlock 2 Unlock 1
        Runtime error of type IllegalMonitorStateException in the line //UNLOCK_2;
        */
        
        System.out.println("\n21 of 30. What changes need to be made for this code to print the string 12345?");
        //Stream.iterate(1, x -> x++).limit(5).map(x->x).collect(Collectors.joining());        
        /*
        Change map(x->x) to map (x -> "" + x)
        Add forEach(System.out:print) after the call to collect()
        Change x->x++ to x->++x
        Wrap the entire line in a System.out.print statement
        Change Collectors.joining() to Collectors.joining("")
        None of the above. The code already prints 12345        
        */
        System.out.println(Stream.iterate(1, x -> ++x).limit(5).map(x-> "" + x).collect(Collectors.joining("")));
        Stream.iterate(1, x -> ++x).limit(5).map(x-> x).forEach(System.out::println);//.collect(Collectors.joining());        
        Stream.iterate(1, x -> ++x).limit(5).map(x-> "" + x).forEach(System.out::print);
        System.out.println("");
        
        System.out.println("\n22 of 30. What will be the result of the following code fragment?");
        Predicate<? super String> predicate = s -> s.startsWith("g");
        Stream<String> stream1 = Stream.generate(()->"growl!");
        Stream<String> stream2 = Stream.generate(()->"growl!");
        boolean b1 = stream1.anyMatch(predicate);
        boolean b2 = stream2.anyMatch(predicate);
        System.out.println(b1 + " " + b2);
        /*
        true false
        Compilation error
        true true
        Runtime error
        The code hangs
        Java.util.stream.ReferencePipeline$3@4517d9a3
        */        
        
        System.out.println("\n23 of 30. ?");
        /*
        
        */
        
        System.out.println("\n24 of 30. What will be the result of the following code fragment?");
        DoubleStream s = DoubleStream.of(1.2, 2.4);
        s.peek(System.out::println).filter(x -> x>2).count();
        /*
        Runtime error
        1
        There is no output
        1.2 and 2.4
        2
        2.4
        Compilation error
        */
        
        System.out.println("\n25 of 30. Which of the following statements are true about the pre-defined streams System.in, System.out, and System.err?");
        /*
        System.err is of type ErrorStream
        System.in is of type InputStream
        System.out is of type OutputStream
        System.in is of type FileReader
        Both System.out and System.err are of type FileWriter
        Both System.out and System.err are of type PrintStream
        */
        
        System.out.println("\n26 of 30. ?");
        /*
        
        */
        
        System.out.println("\n27 of 30. ?");
        /*
        
        */
        
        System.out.println("\n28 of 30. ?");
        /*
        
        */
        
        System.out.println("\n29 of 30. ?");
        /*
        
        */
        
        System.out.println("\n30 of 30. What will be the result of the following code fragment?");
        int a = 10;
        String name = null;
        try {
            a = name.length();
            a++;
        } catch (RuntimeException e){
            ++a;
        }
        System.out.println(a);
        /*
        Output information about an exception
        10
        12
        5
        11
        */

    }    
}

// 20 of 30
class LockUnlock {
    public static void main2(String[] args) {
        Lock lock = new ReentrantLock();
        try{
            System.out.print("Lock 1 ");
            lock.lock();
            System.out.print("Critical section 1 ");
            System.out.print("Lock 2 ");
            lock.lock();
            System.out.print("Critical section 2 ");
        } finally {
            lock.unlock();
            System.out.print("Unlock 2 ");
            lock.unlock();
            System.out.print("Unlock 1 ");
        }
    }
}

// 14 of 30
class OverAndOver{
    static String s = "";
    public static void main2(String[] args) {
        try{
            s+="1";
            throw new Exception();
        } catch (Exception e){
            s+="2";
        } finally {
            s+="3";
            doStuff();
            s+="4";
        }
        System.out.println(s);
    }
    static void doStuff(){
        int x = 0;
        int y = 7/x;
    }
}

// 12 of 30
class Food implements Serializable{
    int good = 3;
}
class Fruit extends Food{
    int juice = 5;
}
class Banana extends Fruit{
    int yellow = 4;
    public static void main2(String[] args) {
        Banana b = new Banana();
        Banana b2 = new Banana();
        b.serializeBanana(b);
        b2 = b.deserializeBanana();
        System.out.println("restore " + b2.yellow + b2.juice + b2.good);
    }
    // other methods
    void serializeBanana(Banana banan){
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("deleteBanan.ser"));
            os.writeObject(banan);        
            os.close();        
        } catch (IOException ex) {
            Logger.getLogger(Banana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Banana deserializeBanana(){
        Banana banan = null;
        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("deleteBanan.ser"));
            banan = (Banana)os.readObject();        
            os.close();        
        } catch (IOException ex) {
            Logger.getLogger(Banana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Banana.class.getName()).log(Level.SEVERE, null, ex);
        }
        return banan;
    }
}

// 10 of 30
class MultipleReturn {
    int getInt() {
        try {
            String[] students = {"William", "Phillip"};
            System.out.println(students[5]);
        } catch (Exception e) {
            return 10;
        } finally {
            return 20;
        }        
    }
    public static void main2(String[] args) {
        MultipleReturn var = new MultipleReturn();
        System.out.println(var.getInt());
    }
}

// 7 of 30
class Morecombe{
    public static void main2(String[] args) {
        Morecombe m = new Morecombe();
        m.go(new Turing() { } );
    }
    public void go(Turing t){
        t.start();
        try {
            t.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Morecombe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
class Turing extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println(i + "");
        }
    }
}

// 6 of 30
class Test2 extends Thread {
    @Override
    public void run() {
        System.out.println("In run method - thread name is:" + 
                Thread.currentThread().getName() + ";");
    }
    
    public static void main2(String[] args) {
        Thread myThread = new Test2();
        myThread.start();
        myThread.start(); // Line1
    }    
}

// 5 of 30
class Keyboard {}
class Computer implements Serializable {
    private Keyboard k = new Keyboard();    
    void storeIt(Computer c){
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("myFile"));
            os.writeObject(c);
            os.close();
            System.out.println("done");
        } catch (Exception x){            
            System.out.println("exc");
        }
    }
}


