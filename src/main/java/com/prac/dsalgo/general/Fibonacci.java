package com.prac.dsalgo.general;

public class Fibonacci {
	
	public int fibRecursive(int n) {
		if(n <= 1) {
			return n;
		}
		return fibRecursive(n - 1) + fibRecursive(n - 2);
	}
	
	public int fibDP(int n) {
		int a = 0, b = 1,c;
		if(n == 0) {
			return 0;
		}
		for(int i = 2; i <= n;i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
	
	public static void main (String args[]) 
    { 
		Fibonacci f = new Fibonacci();
        System.out.println(f.fibRecursive(9)); 
    } 

}
