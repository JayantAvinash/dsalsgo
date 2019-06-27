package com.prac.dsalgo.dp;

import java.util.Set;

public class WordBreak {
	
	public int wordBreakRecursive(String A, Set<String> B) {
		for(int i = 1; i <= A.length(); i++) {
            if(B.contains(A.substring(0, i))) {
                if(i == A.length()) {
                    return 1;
                }
                int x = wordBreakRecursive(A.substring(i, A.length()), B);
                if(x == 1) {
                    return 1;
                }
            }
        }
        return 0;
	}
	
	public int wordBreak(String A, Set<String> B) {
        int l = A.length();
        boolean []position = new boolean[l + 1];
        position[0] = true;
        for(int i = 0; i < l; i++) {
            if(!position[i]) {
                continue;
            }
            for(String d : B) {
                int end = d.length() + i;
                if(end > l) {
                    continue;
                }
                if(A.substring(i, end).equals(d)) {
                    position[end] = true;
                }
                if(position[end] && end == l) {
                    return 1;
                }
            }
        }
        return position[l] ? 1 : 0;
    }
	
	
	// if dictionary is too large
	public int wordBreakV2(String A, Set<String> S) {
        int l = A.length();
        boolean []position = new boolean[l + 1];
        position[0] = true;
        for(int i = 0; i < l; i++) {
            if(position[i]) {
                for(int j = i + 1; j <= l; j++) {
                    if(S.contains(A.substring(i, j))) {
                        position[j] = true;
                    }
                    if(j == l && position[j]) {
                        return 1;
                    }
                }
            }
        }
        return position[l] ? 1 : 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
