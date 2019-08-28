package com.prac.dsalgo.general;

//https://leetcode.com/problems/maximize-distance-to-closest-person/
public class MaxDistanceToClosest {

	public int maxDistToClosest(int[] seats) {
		int lastIndex = -1;
		int max = 0;
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 1) {
				int current = i - (lastIndex == -1 ? 0 : lastIndex);
				current = (lastIndex == -1 ? current : current / 2);
				if (current > max) {
					max = current;
				}
				lastIndex = i;
			}
		}
		if (seats[seats.length - 1] == 0) {
			int current = (seats.length - 1 - (lastIndex == -1 ? 0 : lastIndex));
			if (current >= max) {
				max = current;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		MaxDistanceToClosest m = new MaxDistanceToClosest();
		int[] arr = { 0, 1, 1, 1, 0, 0, 1, 0, 0 };
		System.out.println(m.maxDistToClosest(arr));

	}

}
