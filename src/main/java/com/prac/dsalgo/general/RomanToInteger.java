package com.prac.dsalgo.general;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public int romanToInt(String s) {
		Map<String, Integer> m = new HashMap<>();
		m.put("I", 1);
		m.put("V", 5);
		m.put("X", 10);
		m.put("L", 50);
		m.put("C", 100);
		m.put("D", 500);
		m.put("M", 1000);
		m.put("IV", 4);
		m.put("IX", 9);
		m.put("XL", 40);
		m.put("XC", 90);
		m.put("CD", 400);
		m.put("CM", 900);
		int l = s.length();
		int n = 0;
		int i = 0;
		while (i < l) {
			if (i + 2 <= l && m.containsKey(s.substring(i, i + 2))) {
				n += m.get(s.substring(i, i + 2));
				i += 2;
			} else {
				n += m.get(s.substring(i, i + 1));
				i++;
			}
		}
		return n;

	}

	public static void main(String[] args) {
		RomanToInteger r = new RomanToInteger();
		System.out.println(r.romanToInt("MCMXCIV"));

	}

}
