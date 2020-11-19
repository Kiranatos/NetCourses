package net.kiranatos.epam.summer20.p2.help;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TestStructures {
    public static void main(String[] args) {
        List ooo = new ArrayList();
        Queue que = new ArrayDeque();
        
        Stack<Object> stack = new Stack<>();
//        System.out.println(stack.pop());

        stack.add("1");
        stack.add("2");
        stack.add("3");
        Iterator<Object> iter = stack.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println(" *** ");
        //iter = stack.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        
    }    
}
