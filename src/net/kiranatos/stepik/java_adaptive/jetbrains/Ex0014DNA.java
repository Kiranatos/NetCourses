package net.kiranatos.stepik.java_adaptive.jetbrains;

/* 1.56 Сompression algorithm
 
Upon learning that DNA is not a random string, freshmen of the Bioinformatics 
Institute from the informatics group suggested using a compression algorithm 
that compresses repeated characters in a string.

Encoding is performed as follows:
s = 'aaaabbсaa' is converted into 'a4b2с1a2', that is, the groups of the 
same characters of the input string are replaced by the symbol and the 
number of its repetitions in this string.

Write a program, which reads the string, encodes it by this algorithm and 
outputs the encoded sequence. Encoding must be case sensitive.

Sample Input 1:     aaaabbcaa
Sample Output 1:    a4b2c1a2

Sample Input 2:     abc
Sample Output 2:    a1b1c1
 */
public class Ex0014DNA {
    public static void main(String[] args) {
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String str = "";
        try {
            str = reader.readLine();
        } catch (java.io.IOException ex) { }
        char c = str.charAt(0);
        StringBuilder sb = new StringBuilder(c);
        int k = 1;
        for (int i = 1; i < str.length(); i++) {
            c = str.charAt(i);
            if (c==str.charAt(i-1)) k++;
            else {
                sb.append(str.charAt(i-1));
                sb.append(k);
                k=1;
            }            
        }
        sb.append(str.charAt(str.length()-1)).append(k);        
        
        System.out.println(sb);        
    }
    
}
