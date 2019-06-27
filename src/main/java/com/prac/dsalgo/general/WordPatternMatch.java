package com.prac.dsalgo.general;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/word-pattern/
public class WordPatternMatch {

	public boolean wordPattern(String pattern, String str) {
		char[] patternArr = pattern.toCharArray();
		String[] strArray = str.split(" ");
		if (patternArr.length != strArray.length) {
			return false;
		}
		Map<Character, String> patternWord = new HashMap<>();
		Set<String> words = new HashSet<>();
		for (int i = 0; i < patternArr.length; i++) {
			if (patternWord.containsKey(patternArr[i])) {
				String word = patternWord.get(patternArr[i]);
				if (!word.equals(strArray[i])) {
					return false;
				}
			} else {
				if (words.add(strArray[i])) {
					patternWord.put(patternArr[i], strArray[i]);
				} else {
					return false;
				}

			}
		}
		return true;
	}

	public static void main(String[] args) {
		WordPatternMatch w = new WordPatternMatch();
		System.out.println(w.wordPattern("abba", "dog cat cat dog"));
	}

}
