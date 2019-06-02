package com.prac.dsalgo.general;

public class NonDivisibleSubset {
	
	static int nonDivisibleSubset(int k, int[] S) {
        int []remainder = new int[k];
        for(int i = 0; i < S.length; i++) {
            remainder[S[i] % k]++;
        }
        int subsets = 0;
        if(remainder[0] >= 1) {
            subsets++;
        }
        for(int i = 1; i <= k/2; i++) {
            if(i != k - i) {
                subsets += Math.max(remainder[i], remainder[k - i]);
            } else {
                subsets += Math.min(remainder[i], 1);
            }
        }
        return subsets;
    }

	public static void main(String[] args) {
		int[] S = {19,10,12,10,24,25,22};
		System.out.println(nonDivisibleSubset(4, S));

	}

}
