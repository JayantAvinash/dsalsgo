package com.prac.dsalgo.structures;

public class SegmentTreeMinValue {
	
	int []st;
	
	SegmentTreeMinValue(int[] arr) {
		int h = (int)Math.ceil(Math.log(arr.length)/Math.log(2));
		int max_size = (int)Math.pow(2, h + 1) - 1;
		st = new int[max_size];
		constructSegmentTreeUtil(arr, 0, arr.length - 1, 0);
	}

	private int constructSegmentTreeUtil(int[] arr, int ss, int se, int si) {
		if(ss == se) {
			st[si] = arr[ss];
			return st[si];
		}
		int mid = (ss + se)/2;
		st[si] = Math.min(constructSegmentTreeUtil(arr, ss, mid, 2*si + 1), constructSegmentTreeUtil(arr, mid + 1, se, 2*si + 2));
		return st[si];
	}
	
	int getMinValueInrange(int n, int qs, int qe) {
		if(qs < 0 || qe >= n || qs > qe) {
			return -1;
		}
		return getMinValueInRangeUtil(0, n - 1, qs, qe, 0);
	}

	private int getMinValueInRangeUtil(int ss, int se, int qs, int qe, int si) {
		if(qs > se || qe < ss) {
			return Integer.MAX_VALUE;
		}
		if(qs <=ss && qe >= se) {
			return st[si];
		}
		int mid = (ss + se)/2;
		return Math.min(getMinValueInRangeUtil(ss, mid, qs, qe, 2*si + 1), getMinValueInRangeUtil(mid + 1, se, qs, qe, 2*si + 2));
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 3, 2, 7, 9, 11};
		SegmentTreeMinValue tree = new SegmentTreeMinValue(arr);
		System.out.println("Min value in range 1 to 3 is:" + tree.getMinValueInrange(arr.length, 0, 3));
	}

}
