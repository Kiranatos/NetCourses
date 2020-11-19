package net.kiranatos.stepik.java_basic.sixth_week;

import java.util.*;


/*
Напишите программу, которая прочитает из System.in последовательность 
целых чисел, разделенных пробелами, затем удалит из них все числа, 
стоящие на четных позициях, и затем выведет получившуюся последовательность 
в обратном порядке в System.out.

Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.

В этом задании надо написать программу целиком, включая import'ы, декларацию 
класса Main и метода main.

Sample Input:
1 2 3 4 5 6 7

Sample Output:
6 4 2
 */
public class Ex_6_2_15 {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner("1 2 3 4 5 6 7 8");
        List<Integer> list = new ArrayList<Integer>();
        
        int index=0;
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (!(index %2==0)) list.add(n);
            index++;            
        }        
        Collections.reverse(list);
        
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) { 
            System.out.print(it.next() + " ");
        }
        System.out.flush();
    }
    
}
