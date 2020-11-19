package net.kiranatos.stepik.java_adaptive.jetbrains;

import java.io.*;
import java.util.*;



public class Ex0003 {
 public static int main;
    public static void main(String[] args) {
       
    }
    
    /*
    Desks
    Some school have decided to create three new math groups and 
    equip classrooms for them with the new desks. Only two students 
    may sit at any desk. The number of students in each of the three 
    groups is known. Output the smallest amount of desks, which will 
    need to be purchased. Each new group sits in its own classroom.
    
    Input data format
    The program receives the input of the three non-negative integers: 
    the number of students in each of the three classes 
    (the numbers do not exceed 1000).
    
    Sample Input 1:
    20
    21
    22    
    Sample Output 1: 32
    
    Sample Input 2:
    16
    18
    20
    Sample Output 2: 27
    */
    public static void mainThree(){
        int x1 = 0, x2 = 0, x3 = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));            
            x1 = Integer.valueOf(br.readLine());            
            x2 = Integer.valueOf(br.readLine());
            x3 = Integer.valueOf(br.readLine());
        } catch (Exception e){ e.printStackTrace(); }
                
        if (x1%2!=0) x1 = 1 + x1/2;
        else x1 = x1/2;
        
        if (x2%2!=0) x2 = 1 + x2/2;
        else x2 = x2/2;
        
        if (x3%2!=0) x3 = 1 + x3/2;
        else x3 = x3/2;
        
        int summ = x1+x2+x3;
        System.out.println(summ);
    }
    
    /*
    You are given two coordinates on a chess board of the first queen and 
    two of the second. Find out, whether two queens hit each other or not.
    
    INPUT
    Four integer numbers x1,y1,x2,y2    are being typed.
    
    OUTPUT
    Type "YES" (uppercase) if they hit each other or "NO" if the don't.
    
    Sample Input 1:     1 1 3 3
    Sample Output 1:    YES
    
    Sample Input 2:     1 1 4 3
    Sample Output 2:    NO
    
    Sample Input 3:     2 2 5 2
    Sample Output 3:    YES
    */
    public static void mainTwo(){
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] nums = br.readLine().split(" ");
            x1 = Integer.valueOf(nums[0]);
            y1 = Integer.valueOf(nums[1]);
            x2 = Integer.valueOf(nums[2]);
            y2 = Integer.valueOf(nums[3]);
        } catch (Exception e){ e.printStackTrace(); }
        
        if ( (x1==x2) | (y1==y2) ) { System.out.println("YES");}
        else if (Math.abs(x1-x2)==Math.abs(y1-y2)) { System.out.println("YES");}
        else { System.out.println("NO");}

    }
    
    
    
    /*
    There is a queue of 4 elements. Put in it one more element - 
    the number 5, and then get 2 items out of the queue.   
    Sample Output:    [3, 4, 5]
    */    
    public static void mainOne(){
        Deque<Integer> queue = new ArrayDeque<>(Arrays.asList(1,2,3,4));
        queue.add(5);
        queue.pop();
        queue.pop();
        System.out.println(queue);
    }
    
}
