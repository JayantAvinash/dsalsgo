package com.prac.dsalgo.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
https://leetcode.com/problems/combination-sum/
*/public class CombinationSum {
	
	//dp solution
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer, List<List<Integer>>> combinations = new HashMap<>();
        combinations.put(0, new ArrayList());
        for(int candidate : candidates) {
        	for(int i = 1; i <= target; i++) {
        		if(i >= candidate && combinations.containsKey(i - candidate)) {
        			List<List<Integer>> combos = combinations.get(i - candidate);
                    List<List<Integer>> currentCombos = new ArrayList<>();
                    for (List<Integer> combo : combos) {
                    	List<Integer> currentCombo = new ArrayList<>(combo);
                        currentCombo.add(candidate);
                        currentCombos.add(currentCombo);
                    }
                    if(currentCombos.isEmpty()) {
                        List<Integer> currentCombo = new ArrayList<>();
                        currentCombo.add(candidate);
                        currentCombos.add(currentCombo);
                    }
                    List<List<Integer>> currentList = combinations.get(i);
                    if(currentList != null) {
                        currentCombos.addAll(currentList);
                    }
                    combinations.put(i, currentCombos);
        		}
        	}
        }
        if(combinations.containsKey(target)) {
            return combinations.get(target);
        }
        return new ArrayList<>();
    }
	
	public List<List<Integer>> combinationSumBackTracking(int[] candidates, int target) {
		List<List<Integer>> all = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		findCombinations(all, current, candidates, 0, target);
		return all;
	}

	private void findCombinations(List<List<Integer>> all, List<Integer> current, int[] candidates, int index, int target) {
		System.out.println(target);
		if(target == 0) {
			all.add(new ArrayList<>(current));
		} else if(target > 0) {
			for(int i = index; i < candidates.length; i++) {
					current.add(candidates[i]);
					findCombinations(all, current, candidates, i, target - candidates[i]);
					current.remove(current.size() - 1);
			}
		}
		
	}

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] candidates = {2,3,6,7};
		System.out.println(cs.combinationSumBackTracking(candidates, 7));
	}

}
