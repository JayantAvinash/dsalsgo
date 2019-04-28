package com.prac.dsalgo.structures;

public class SegmentTree {

	int[] st;

	SegmentTree(int[] arr) {
		int n = arr.length;
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int max_size = (int) Math.pow(2, h + 1) - 1;
		System.out.println("Height is:" + max_size);
		st = new int[max_size];
		constructSTUtil(arr, 0, n - 1, 0);
	}

	// A recursive function that constructs Segment Tree for array[ss..se].
	// si is index of current node in segment tree st
	private int constructSTUtil(int arr[], int ss, int se, int si) {
		if (ss == se) {
			st[si] = arr[ss];
			return st[si];
		}
		int mid = (ss + se) / 2;
		st[si] = constructSTUtil(arr, ss, mid, 2 * si + 1) + constructSTUtil(arr, mid + 1, se, 2 * si + 2);
		return st[si];
	}

	public int getSum(int n, int qs, int qe) {
		if (qs < 0 || qe >= n || qs > qe) {
			return -1;
		}
		return getSumUtil(0, n - 1, qs, qe, 0);
	}

	private int getSumUtil(int ss, int se, int qs, int qe, int si) {
		if (qs <= ss && qe >= se) {
			return st[si];
		}
		if (ss > qe || se < qs) {
			return 0;
		}
		int mid = (ss + se) / 2;
		return getSumUtil(ss, mid, qs, qe, 2 * si + 1) + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
	}

	public void updateValue(int[] arr, int i, int val) {
		if (i < 0 || i > arr.length - 1) {
			return;
		}
		int diff = val - arr[i];
		arr[i] = val;

		updateValueUtil(0, arr.length - 1, i, diff, 0);
	}

	private void updateValueUtil(int ss, int se, int i, int diff, int si) {

		if (i < ss || i > se) {
			return;
		}
		st[si] = st[si] + diff;
		if (se != ss) {
			int mid = (se + ss) / 2;
			updateValueUtil(ss, mid, i, diff, 2 * si + 1);
			updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
		}
	}

	public static void main(String[] args) {

		int arr[] = { 1, 3, 5, 7, 9, 11 };
		SegmentTree tree = new SegmentTree(arr);
		for (int i = 0; i < tree.st.length; i++) {
			System.out.print(tree.st[i] + " ");

		}
		System.out.println();
		// Print sum of values in array from index 1 to 3
		System.out.println("Sum of values in given range = " + tree.getSum(arr.length, 1, 3));
		tree.updateValue(arr, 1, 10);

		for (int i = 0; i < tree.st.length; i++) {
			System.out.print(tree.st[i] + " ");

		}
		System.out.println();
		// Find sum after the value is updated
		System.out.println("Updated sum of values in given range = " + tree.getSum(arr.length, 1, 3));
	}

}
