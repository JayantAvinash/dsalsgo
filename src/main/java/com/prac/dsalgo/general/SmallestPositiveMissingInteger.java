package com.prac.dsalgo.general;

public class SmallestPositiveMissingInteger {
	
	public int solution(int[] A) {
        // write your code in Java SE 8
        
        int max = 0;
        for(int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
        }
        
        if(max <= 0) {
            return 1;
        }
        boolean []res = new boolean[max];
        for(int i = 0; i < A.length; i++) {
            if(A[i] > 0) {
                res[A[i] - 1] = true;
            }
        }
        for(int i = 0; i < max; i++) {
            if(!res[i]) {
                return i + 1;
            }
        }
        return max + 1;
    }

	public static void main(String[] args) {
		SmallestPositiveMissingInteger s = new SmallestPositiveMissingInteger();
		int []arr = { 2, 3, -7, 6, 8, 1, -10, 15 };
		System.out.println(s.solution(arr));

	}

}
