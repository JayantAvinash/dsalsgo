package com.prac.dsalgo.general;

public class RotateString {
	
	public boolean rotateString(String A, String B) {
        if(A == null && B == null) {
            return true;
        }
        if(A == null || B == null) {
            return false;
        }
        int lengthA = A.length();
        int lengthB = B.length();
        if(lengthA == 0 && lengthB == 0) {
            return true;
        }
        if(lengthA != lengthB) {
            return false;
        }
        int i = 0, j = 0;
        while(i < lengthA && A.charAt(i) != B.charAt(j)) {
            i++;
        }
        if(i >= lengthA) {
            return false;
        }
        while(j < lengthB && A.charAt(i) == B.charAt(j)) {
            i++;
            j++;
            if(i == lengthA) {
                i = 0;
            }
        }
        if(j < lengthB) {
            return false;
        }
        return true;
    }

	public static void main(String[] args) {
		RotateString rs = new RotateString();
		System.out.println(rs.rotateString("abcde", "cdeba"));

	}

}
