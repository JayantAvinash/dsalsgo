package com.prac.dsalgo.arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/create-maximum-number/
public class CreateMaxNumber {

	public int[] maxNumberRecursive(int[] nums1, int[] nums2, int k) {
		List<Integer> n = new ArrayList<>();
		n = maxNumberRecursive(nums1, nums2, 0, 0, k, n);
		int[] arr = new int[k];
		for (int i = 0; i < k; i++) {
			arr[i] = n.get(i);
		}
		return arr;
	}

	private List<Integer> maxNumberRecursive(int[] nums1, int[] nums2, int from1, int from2, int k,
			List<Integer> currNum) {
		if (k == 0) {
			return currNum;
		}
		int skip2 = k - (nums1.length - from1) - 1;
		int skip1 = k - (nums2.length - from2) - 1;
		skip1 = skip1 > 0 ? skip1 : 0;
		skip2 = skip2 > 0 ? skip2 : 0;
		int max1 = from1;
		for (int i = from1 + 1; i < nums1.length - skip1; i++) {
			if (nums1[i] > nums1[max1]) {
				max1 = i;
			}
		}
		int max2 = from2;
		for (int i = from2 + 1; i < nums2.length - skip2; i++) {
			if (nums2[i] > nums2[max2]) {
				max2 = i;
			}
		}
		if (max1 >= nums1.length) {
			currNum.add(nums2[max2]);
			return maxNumberRecursive(nums1, nums2, from1, max2 + 1, k - 1, currNum);
		} else if (max2 >= nums2.length) {
			currNum.add(nums1[max1]);
			return maxNumberRecursive(nums1, nums2, max1 + 1, from2, k - 1, currNum);
		} else if (nums1[max1] > nums2[max2]) {
			currNum.add(nums1[max1]);
			return maxNumberRecursive(nums1, nums2, max1 + 1, from2, k - 1, currNum);
		} else if (nums1[max1] < nums2[max2]) {
			currNum.add(nums2[max2]);
			return maxNumberRecursive(nums1, nums2, from1, max2 + 1, k - 1, currNum);
		} else {
			List<Integer> l1 = new ArrayList<>(currNum);
			l1.add(nums1[max1]);
			l1 = maxNumberRecursive(nums1, nums2, max1 + 1, from2, k - 1, l1);
			List<Integer> l2 = new ArrayList<>(currNum);
			l2.add(nums2[max2]);
			l2 = maxNumberRecursive(nums1, nums2, from1, max2 + 1, k - 1, l2);
			return (l1.toString().compareTo(l2.toString()) > 0 ? l1 : l2);
		}
	}

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] result = new int[k];
		for (int k1 = Math.max(0, k - nums2.length); k1 <= Math.min(k, nums1.length); k1++) {
			int k2 = k - k1;
			int[] list1 = getlist(nums1, k1);
			int[] list2 = getlist(nums2, k2);
			int[] localresult = new int[k];
			help(list1, list2, localresult);
			if (comparelist(localresult, 0, result, 0))
				result = localresult;
		}
		return result;
	}

	private int[] getlist(int[] list, int k) {
		int[] result = new int[k];
		int len = 0;
		for (int index = 0; index < list.length; index++) {
			while (len > 0 && (k - len) < (list.length - index) && list[index] > result[len - 1])
				len--;
			if (len < k)
				result[len++] = list[index];
		}
		return result;
	}

	private void help(int[] list1, int[] list2, int[] result) {
		int index1 = 0, index2 = 0;
		int index = 0;
		while (index1 < list1.length && index2 < list2.length) {
			if (comparelist(list1, index1, list2, index2))
				result[index++] = list1[index1++];
			else
				result[index++] = list2[index2++];
		}
		while (index1 < list1.length)
			result[index++] = list1[index1++];
		while (index2 < list2.length)
			result[index++] = list2[index2++];
	}

	private boolean comparelist(int[] list1, int index1, int[] list2, int index2) {
		while (index1 < list1.length && index2 < list2.length) {
			if (list1[index1] > list2[index2])
				return true;
			if (list1[index1] < list2[index2])
				return false;
			index1++;
			index2++;
		}
		if (index1 < list1.length)
			return true;
		if (index2 < list2.length)
			return false;
		return true;
	}

	public static void main(String[] args) {
		CreateMaxNumber c = new CreateMaxNumber();
		int[] nums1 = { 3, 4, 6, 5 };
		int[] nums2 = { 9, 1, 2, 5, 8, 3 };
		int[] arr = c.maxNumber(nums1, nums2, 5);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
