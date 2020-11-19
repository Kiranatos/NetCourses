package net.kiranatos.stepik.java_adaptive.jetbrains;

import java.io.*;


public class Ex0012_simple {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        
        String[][] s = new String[n][n];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                if ( (i==j) || (i==s.length/2) || (j==s[i].length/2) || (i==s.length-j-1)         ) {
                    s[i][j] = "*";
                }
                else s[i][j] = ".";
                
            }
        }
        
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
        
        
    }
    
}
