package com.prac.dsalgo.general;

public class IntegerPalindrome {
	
	public boolean isPalindromeV0(int x) {
        if(x < 0) {
            return false;
        }
        if(x/10 == 0) {
            return true;
        }
        int noOfDigits = 0;
        int y  = x;
        while(y > 0) {
            y /= 10;
            noOfDigits++;
        }
        int quotient = 0;
        int remainder = 0;
        if(noOfDigits % 2 == 0) {
            quotient = x / (int)Math.pow(10, noOfDigits/2);
        } else {
            quotient = x / (int)Math.pow(10, (noOfDigits/2) + 1);
        }
        remainder = x % (int)Math.pow(10, noOfDigits/2);
        int z = (noOfDigits/2);
        while(z > 0) {
           int r = remainder % 10;
            int q = quotient/(int)Math.pow(10,(z - 1));
            if(q != r) {
                return false;
            }
             remainder /= 10;
            quotient = quotient % (int)Math.pow(10,(z - 1));
            z--;
        }
        return true;
    }
	
	public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x < 10) return true;
        
        long val = 0;
        int y = x;
        
        while (y > 0) {
            val = val * 10 + y%10;
            y/=10;
        }
        
        return val == x;
    }

	public static void main(String[] args) {
		IntegerPalindrome ip = new IntegerPalindrome();
		System.out.println(ip.isPalindrome(343));

	}

}
