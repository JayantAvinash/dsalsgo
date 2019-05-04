package com.prac.dsalgo.general;

public class SubArraySumDivisibleByK {

	public static void main(String[] args) {
		SubArraySumDivisibleByK s = new SubArraySumDivisibleByK();
		int []arr = {4,5,0,-2,-3,1};
		System.out.println(s.noOfSubArraysDivisibleByKDP(arr, 5));

	}
	
	//O(n^2)
	int noOfSubArraysDivisibleByKDP(int []A, int K) {
		long [][]sumArray = new long[A.length][A.length];
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            sumArray[i][i] = A[i];
            if(sumArray[i][i] % K == 0) {
                count++;
            }
        }
        for(int total = 2; total <= A.length; total++) {
            for(int i = 0; i < A.length - total + 1; i++) {
                int j = i + total - 1;
                sumArray[i][j] = sumArray[i][j - 1] + A[j];
                if(sumArray[i][j] % K == 0) {
                    count++;
                }
            }
        }
        return count;
	}
	
	//O(n + k)
	int noOfSubArraysDivisibleByK(int []A, int K) {
		int continuousSum = 0;
        int[] mod = new int[K];
        for(int i = 0; i < A.length; i++) {
            continuousSum += A[i];
            mod[((continuousSum % K) + K)%K]++;
        }
        int count = 0;
        for(int i = 0; i < K; i++) {
            if(mod[i]  > 1) {
                count += mod[i]*(mod[i] - 1)/2;
            }
        }
        count += mod[0];
        return count;
	}

}
