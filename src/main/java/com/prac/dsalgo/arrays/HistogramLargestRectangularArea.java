package com.prac.dsalgo.arrays;

import java.util.Stack;

// alternate solution is by segment tree(Minimum segment tree)
// https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
public class HistogramLargestRectangularArea {

	public static int getMaxArea(int[] hist) {
		int maxArea = 0;
		int l = hist.length;
		int i = 0;
		Stack<Integer> s = new Stack<>();
		while (i < l) {
			if (s.isEmpty() || hist[s.peek()] <= hist[i]) {
				s.push(i++);
			} else {
				int currTop = s.pop();
				int currArea = hist[currTop] * (s.isEmpty() ? i : i - s.peek() - 1);
				maxArea = Math.max(maxArea, currArea);
			}
		}
		while (!s.isEmpty()) {
			int currTop = s.pop();
			int currArea = hist[currTop] * (s.isEmpty() ? i : i - s.peek() - 1);
			maxArea = Math.max(maxArea, currArea);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println("Maximum area is " + getMaxArea(hist));

	}

}
