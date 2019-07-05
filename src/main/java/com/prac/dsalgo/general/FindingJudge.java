package com.prac.dsalgo.general;

// https://leetcode.com/problems/find-the-town-judge/
public class FindingJudge {

	public int findJudge(int N, int[][] trust) {
		if (trust.length == 0) {
			return 1;
		}
		int[] trustArr = new int[N + 1];
		for (int[] persons : trust) {
			trustArr[persons[1]]++;
			trustArr[persons[0]]--;
		}
		for (int i = N; i > 0; i--) {
			if (trustArr[i] == N - 1) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		FindingJudge f = new FindingJudge();
		int [][]trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
		System.out.println(f.findJudge(4, trust));
	}

}
