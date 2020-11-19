package net.kiranatos.stepik.java_adaptive.jetbrains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Swimming pool
Ian was swimming in the pool having size of N×M feets and got tired. 
At this moment he realized that he is at a distance of X feets from 
one of the long ledge (not necessarily from the nearest one) and Y 
feets from one of the short ledges. What is the minimum distance 
(in feets) Ian needs to swim in order to reach the swimming pool ledge?

The program input contains numbers N, M, X, Y.

Sample Input:
23
52
8
43
Sample Output:
8
*/

public class Ex0009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int y1 = Integer.valueOf(br.readLine());
        int x1 = Integer.valueOf(br.readLine());
        int x,y;
        if (y1<x1) { x = x1; y = y1; }
        else { x = y1; y = x1; }
        
        y1 = Integer.valueOf(br.readLine());
        x1 = Integer.valueOf(br.readLine());
        
        int y1y2 = y - y1;
        int miny = (y1y2<y1) ? y1y2 : y1;
        
        int x1x2 = x - x1;
        int minx = (x1x2<x1) ? x1x2 : x1;
        
        System.out.println((minx<miny)?minx:miny);
    }        
   
}
