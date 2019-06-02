package com.prac.dsalgo.general;

public class SumIntegerString {
	
	public String addStrings(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int l = Math.min(l1, l2);
        if(l1 == 0) {
            return num2;
        }
        if(l2 == 0) {
            return num1;
        }
        StringBuilder finalSum = new StringBuilder();
        int trail = 0;
        for(int i = 1; i <= l; i++) {
            int x1 = num1.charAt(l1-i) - '0';
            int x2 = num2.charAt(l2-i) - '0';
            int s = x1 + x2 + trail;
            trail = s /10;
            int current = s % 10;
            finalSum.append(current);
        }
        if(l1 > l) {
            for(int i = l + 1; i <= l1 ;i++) {
                int x1 = num1.charAt(l1-i) - '0';
                int s = x1 + trail;
                trail = s /10;
                int current = s % 10;
                finalSum.append(current);
            }
        } else if(l2 > l) {
            for(int i = l + 1; i <= l2;i++) {
                int x1 = num2.charAt(l2-i) - '0';
                int s = x1 + trail;
                trail = s /10;
                int current = s % 10;
                finalSum.append(current);
            }
        }
        if(trail > 0) {
        	finalSum.append(trail);
        }
        return finalSum.reverse().toString();
    }

	public static void main(String[] args) {
		SumIntegerString sis = new SumIntegerString();
		System.out.println(sis.addStrings("39", "984"));

	}

}
