package net.kiranatos.stepik.java_adaptive.jetbrains;
/* 1.54 The lucky ticket 

    The lucky ticket
Paul loves to ride public transport and after receiving the ticket, 
he immediately checks whether he got the lucky one. 
A ticket is considered a lucky one if the sum of the first three numbers 
in this ticket matches the sum of the last three numbers in the same ticket.

However, Paul does not count well in head that is why he asks you to 
write the program, which will check the equality of the sums and 
display "Lucky" if the sums match, and "Regular" if the sums differ.

A string of six digits is provided as input to the program.

You need to print out only the word "Lucky" or "Regular" with a capital letter.

Sample Input 1:     090234
Sample Output 1:    Lucky

Sample Input 2:     123456
Sample Output 2:    Regular 
*/
public class Ex0013LuckyTicket {
    public static void main(String[] args) {
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String str = "";
        try {
            str = reader.readLine();
        } catch (java.io.IOException ex) { }
        
        int a = 0, b = 0;
        for (int i = 0; i < str.length()/2; i++) {
            a += Character.getNumericValue(str.charAt(i));
            b += Character.getNumericValue(str.charAt(str.length() - i - 1)); 
        }
        if (a==b) System.out.println("Lucky");
        else System.out.println("Regular");
    }
}
