package com.prac.dsalgo.arrays;

import java.util.HashSet;
import java.util.Set;

public class PairOfNumbersWithGivenSum {
	
	public boolean checkIfPairExists(int []arr, int n) {
		Set<Integer> elem = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++) {
			if(elem.contains(n - arr[i])) {
				return true;
			} else {
				elem.add(arr[i]);
			}
		}
		return false;
		
	}

}
