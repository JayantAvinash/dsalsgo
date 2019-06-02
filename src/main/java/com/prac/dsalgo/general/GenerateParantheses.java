package com.prac.dsalgo.general;

import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/problems/generate-parentheses/
public class GenerateParantheses {
	
	public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAllCombinations(0, 0, combinations, n, "");
        return combinations;
    }
    
    public void generateAllCombinations(int left, int right, List<String> combinations, int n, String s) {
        if(right == n) {
            combinations.add(s);
            return;
        }
        if(left < n) {
            generateAllCombinations(left + 1, right, combinations, n, s + "(");
        }
        if(right < n && right < left) {
            generateAllCombinations(left, right + 1, combinations, n, s + ")");
        }
    }

	public static void main(String[] args) {
		GenerateParantheses g = new GenerateParantheses();
		System.out.println(g.generateParenthesis(3));

	}

}
