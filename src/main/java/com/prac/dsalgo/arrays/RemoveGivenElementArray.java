package com.prac.dsalgo.arrays;


/*Solution to problem:
	https://leetcode.com/problems/remove-element/
*/public class RemoveGivenElementArray {
	
	//swapping with last element
	/*public int removeElement(int[] nums, int val) {
        int last = nums.length- 1;
        if(last < 0) {
            return 0;
        }
        for(int i = 0; i <= last; i++) {
            if(nums[i] == val) {
                while(last > i && nums[last] == val) {
                    last--;
                }
                if(last > i) {
                    nums[i] = nums[last];
                    last--;
                } else {
                    break;
                }
                
            }
        }
        if(nums[last] == val) {
            return last;
        }
        return last + 1;
    }*/
	
	public int removeElement(int[] nums, int val) {
		int n = 0;
		for (int i = 0; i < nums.length; i++) {
			nums[n] = nums[i];
			if (nums[i] != val) {
				n++;
			}
		}
		return n;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 2, 3 };
		RemoveGivenElementArray r = new RemoveGivenElementArray();
		int l = r.removeElement(nums, 2);
		for (int i = 0; i < l; i++) {
			System.out.print(nums[i] + " ");
		}

	}

}
