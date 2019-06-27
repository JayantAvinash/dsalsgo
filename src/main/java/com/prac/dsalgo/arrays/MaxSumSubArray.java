package com.prac.dsalgo.arrays;

public class MaxSumSubArray {
	
	//O(n) approach
	public int maxSubArray(int[] nums) {
		int overallMax = 0, currentSum = 0, maxElement = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            maxElement = Math.max(maxElement, nums[i]);
            if(currentSum + nums[i] > 0) {
                currentSum += nums[i];
                overallMax = Math.max(overallMax, currentSum);
            } else {
                currentSum = 0;
            }
        }
        return overallMax == 0 ? maxElement : overallMax;
	}
	
	
	// Divide and Conquer approach nlogn
	private int maxSubArraySum(int[] nums, int from, int to) {
		if (from == to) {
			return nums[from];
		}
		int mid = (from + to) / 2;

		return Math.max(Math.max(maxSubArraySum(nums, from, mid), maxSubArraySum(nums, mid + 1, to)),
				crossMidSum(nums, from, mid, to));
	}

	private int crossMidSum(int[] nums, int from, int mid, int to) {
		int left_sum = Integer.MIN_VALUE, sum = 0;
		for (int i = mid; i >= 0; i--) {
			sum += nums[i];
			left_sum = Math.max(left_sum, sum);
		}
		sum = 0;
		int right_sum = Integer.MIN_VALUE;
		for (int i = mid + 1; i <= to; i++) {
			sum += nums[i];
			right_sum = Math.max(right_sum, sum);
		}
		return left_sum + right_sum;
	}

	public static void main(String[] args) {
		MaxSumSubArray m = new MaxSumSubArray();
		int []arr = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(m.maxSubArray(arr));
		System.out.println(m.maxSubArraySum(arr, 0, arr.length - 1));
	}

}
