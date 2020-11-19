package net.kiranatos.stepik.java_adaptive.jetbrains;

/* 1.71 Replacement

At some point, you got tired of using the file names with spaces and you have 
decided to write a program that renames all files that contain spaces in their 
names by replacing the groups of spaces by the underscore symbol "_".

First, you need to write a program that reads the string and replaces the 
group of white space characters by underscore symbols.

Input format:       Single line, containing arbitrary symbols, including spaces.
Output format:      Modified string.

Sample Input 1:     my file name.txt
Sample Output 1:    my_file_name.txt

Sample Input 2:     string     with        multi spaces
Sample Output 2:    string_with_multi_spaces

Sample Input 3:     single
Sample Output 3:    single
*/

public class Ex0015_s1_71_Replacement {
    public static void main(String[] args) {
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String str = "";
        try {
            str = reader.readLine();
        } catch (java.io.IOException ex) { }
        
        
        char c;
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (Character.isSpaceChar(c)) {
                if (!flag) {
                    sb.append("_");
                    flag = true;
                }
            }
            else { 
                sb.append(c);
                flag = false;
            }
        }        
        
        System.out.println(sb);        
    }
    
}
