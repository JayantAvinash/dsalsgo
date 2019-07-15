package com.prac.dsalgo;

public class Sample {
	
	public static void main(String[] args) {
		char c = 'a' + 1;
		System.out.println(reverse(-120));
	}
	
	
	public static int reverse(int x) {
        int n = 0;
        int temp = x;
        while(x != 0) {
            n = 10*n + x % 10;
            x /= 10;
        }
        /*if(temp < 0) {
            n = -n;
        }*/
        return n;
    }
	
}
