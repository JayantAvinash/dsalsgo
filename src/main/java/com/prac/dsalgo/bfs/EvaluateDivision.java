package com.prac.dsalgo.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/evaluate-division/
public class EvaluateDivision {

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		if (queries == null || queries.size() == 0) {
			return new double[0];
		}
		double[] d = new double[queries.size()];
		if (equations == null || equations.size() == 0) {
			Arrays.fill(d, -1);
			return d;
		}
		Map<String, Map<String, Double>> m = new HashMap<>();
		for (int i = 0; i < equations.size(); i++) {
			m.putIfAbsent(equations.get(i).get(0), new HashMap<>());
			m.putIfAbsent(equations.get(i).get(1), new HashMap<>());
			m.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
			m.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
		}

		for (int i = 0; i < queries.size(); i++) {
			d[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), 1, m, new HashSet<String>());
		}

		return d;
	}

	private double bfs(String num, String den, double v, Map<String, Map<String, Double>> m, Set<String> s) {
		if (!m.containsKey(num) || !m.containsKey(den) || !s.add(num)) {
			return -1;
		}
		if (num.equals(den)) {
			return v;
		}
		Map<String, Double> associated = m.get(num);
		for (String key : associated.keySet()) {
			double d = bfs(key, den, v * associated.get(key), m, s);
			if (d != -1) {
				return d;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<>();
		equations.add(Arrays.asList("a", "b"));
		equations.add(Arrays.asList("b", "c"));
		double[] values = { 2.0, 3.0 };
		List<List<String>> queries = new ArrayList<>();
		queries.add(Arrays.asList("a", "c"));
		queries.add(Arrays.asList("b", "a"));
		queries.add(Arrays.asList("a", "e"));
		queries.add(Arrays.asList("a", "a"));
		queries.add(Arrays.asList("x", "x"));

		EvaluateDivision e = new EvaluateDivision();
		double[] val = e.calcEquation(equations, values, queries);
		for (int i = 0; i < val.length; i++) {
			System.out.print(val[i] + " ");
		}

	}

}
