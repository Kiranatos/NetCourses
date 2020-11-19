package net.kiranatos.stepik.java_adaptive.jetbrains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
In the Bioinformatics Institute a competition is held between 
the computer science and biology students. The winners will 
get a large and tasty pie. The team of biology students consists 
of A students, computer science team — B students.

It is necessary to pre-cut the pie so that it would be possible
to distribute the pieces of the pie to any team that won the 
competition, with each member of this team should get the same 
number of pieces of the pie. And since you do not want to cut 
the pie into the too many small pieces, you need to find the 
minimum suitable number.

Write a program, which helps to find this number.

The program gets the size of the teams (two positive integers A
and B, each number is entered in a separate line) and should 
output the smallest number D, which is divisible by both numbers 
without remainder.

Sample Input 1:
7
5
Sample Output 1:
35

Sample Input 2:
15
15
Sample Output 2:
15

Sample Input 3:
12
16
Sample Output 3:
48
*/

public class Ex0004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.valueOf(br.readLine());            
        int b = Integer.valueOf(br.readLine());
        int min, max = a*b;
        if (a<b) min = b;
        else min = a;
        
        for (int i = min; i < max; i++) {
            if ( (i % a == 0) & (i % b == 0)) {
                max = i;
                break;
            }
        }
                
        System.out.println(max);
    }    
}
