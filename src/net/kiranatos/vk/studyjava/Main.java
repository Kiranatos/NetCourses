package net.kiranatos.vk.studyjava;

import java.util.ArrayList;
import java.util.List;

/**
 * https://vk.com/wall-58178357_8517
 */
public class Main {
   List<Integer>  list;

    Main() {
        list = new ArrayList<Integer>();
        someVoid(list);
    }
    
    void someVoid(List<Integer>  lit){
        lit.add(0);
        lit = null;
    }
    
    public static void main(String[] args) {
        Main test = new Main();
        System.out.println("Size is: " + test.list.size());
    }   
}
