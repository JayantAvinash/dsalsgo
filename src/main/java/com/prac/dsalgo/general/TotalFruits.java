package com.prac.dsalgo.general;

public class TotalFruits {
	
	public int totalFruit(int[] tree) {
        if(tree == null || tree.length < 3) {
            return tree == null ? 0 : tree.length;
        }
        int max = 0;
        int firstStart = 0, secondStart = 0, firstEnd = 0, secondEnd = 0;;
        int firstVal = tree[0], secondVal = Integer.MAX_VALUE;
        for(int i = 1; i < tree.length ; i++) {
            if(tree[i] == firstVal) {
                firstEnd = i;
                continue;
            } else if(secondVal == Integer.MAX_VALUE) {
                secondStart = i;
                secondVal = tree[i];
                secondEnd = i;
            } else if(tree[i] == secondVal) {
                secondEnd = i;
                continue;
            } else {
                 max = Math.max(max, i - firstStart);
                if(tree[i - 1] == secondVal) {  
                    firstVal = secondVal;
                    firstStart = firstEnd + 1;
                    firstEnd = secondEnd;
                    
                } else {
                    firstStart = secondEnd + 1;
                    
                }
                secondVal = tree[i];
                secondStart = i;
                secondEnd = i;
            }
            
        }
        return Math.max(tree.length - firstStart, max);
    }

	public static void main(String[] args) {
		TotalFruits t = new TotalFruits();
		int []arr = {1,2,3,2,2};
		System.out.println(t.totalFruit(arr));
	}

}
