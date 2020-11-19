package net.kiranatos.stepik.java_basic;

import java.math.BigInteger;
import java.util.Arrays;


public class SecondWeek {

public static int flipBit(int value, int bitIndex) {
    return value^(1<<(bitIndex-1)); // https://ru.wikipedia.org/wiki/%D0%91%D0%B8%D1%82%D0%BE%D0%B2%D0%BE%D0%B5_%D0%BF%D0%BE%D0%BB%D0%B5
} 

public static boolean isPalindrome(String text) {
    String s = text.replaceAll("[^A-Za-z1-9]+", "").toLowerCase();
    StringBuilder sb = new StringBuilder(s);
    return sb.toString().equals(sb.reverse().toString());
}

public static int[] mergeArrays(int[] a1, int[] a2) {
    if (a1 == null) return a2;
	if (a2 == null) return a1;
	int[] r = new int[a1.length + a2.length];
	System.arraycopy(a1, 0, r, 0, a1.length);
	System.arraycopy(a2, 0, r, a1.length, a2.length);
        Arrays.sort(r);
	return r;
}

private String printTextPerRole(String[] roles, String[] textLines) {
    StringBuilder[] sb = new StringBuilder[roles.length];
    for (int i=0; i<sb.length; i++) {
        sb[i] = new StringBuilder(roles[i] + ":\n");
    }
    
    int a = 1;
    
    for (int i=0; i<textLines.length; i++) {
        for (int j=0; j<roles.length; j++) {
            if (textLines[i].startsWith(roles[j]+":") ) {
                sb[j].append(a+")");
                sb[j].append( textLines[i].substring( roles[j].length()+1 ) );
                sb[j].append("\n");
                a++;
            }            
        }
    }
    
    StringBuilder resBuild = sb[0];
    
    for (int i=1; i<sb.length; i++) {
        resBuild.append("\n");
        resBuild.append(sb[i]);
    }
    
    return resBuild.toString();
}
    public static void main(String[] args) {
        String[] roles = {
            "Городничий",
            "Аммос Федорович",
            "Артемий Филиппович",
            "Лука Лукич"};
        String[] textLines = {
            "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
            "Аммос Федорович: Как ревизор?",
            "Артемий Филиппович: Как ревизор?",
            "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
            "Аммос Федорович: Вот те на!",
            "Артемий Филиппович: Вот не было заботы, так подай!",
            "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };
        
        System.out.println( new SecondWeek().printTextPerRole(roles, textLines) );

        
    }
    
}

/*
Городничий:
1) Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.
4) Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.

Аммос Федорович:
2) Как ревизор?
5) Вот те на!

Артемий Филиппович:
3) Как ревизор?
6) Вот не было заботы, так подай!

Лука Лукич:
7) Господи боже! еще и с секретным предписаньем!
*/