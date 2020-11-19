package net.kiranatos.stepik.java_adaptive.jetbrains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Функция Ейлера
http://www.javascripter.net/math/calculators/eulertotientfunction.htm
For each of the entered number N, find the number of integers from 1 to N, 
relatively prime (coprime) to N.

Sample Input:   748337821
Sample Output:  557766000  */
public class Ex0011 {
    
    private static int phi(int n) {
	int ret = 1;
	for(int i = 2; i * i <= n; ++i) {
		int p = 1;
		while(n % i == 0) {
			p *= i;
			n /= i;
		}
		if((p /= i) >= 1) ret *= p * (i - 1);
	}
	return (--n)!=0 ? n * ret : ret;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.valueOf(br.readLine());
        System.out.println(phi(a));        
    }
    
}
