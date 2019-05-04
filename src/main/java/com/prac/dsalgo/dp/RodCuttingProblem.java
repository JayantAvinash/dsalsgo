package com.prac.dsalgo.dp;

public class RodCuttingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
		RodCuttingProblem rcp = new RodCuttingProblem();
		System.out.println(rcp.maxPriceRecursive(arr, arr.length));
		System.out.println(rcp.maxPrice(arr));
	}
	
	public int maxPriceRecursive(int[] price, int length) {
		if(length == 0) {
			return 0;
		}
		int maxprice = 0;
		for(int i = 0; i < length; i++) {
			maxprice = Math.max(maxprice, price[i] + maxPriceRecursive(price, length - i - 1));
		}
		return maxprice;
	}
	
	public int maxPrice(int []price) {
		int length = price.length;
		int[] maxPriceArr = new int[length];
		maxPriceArr[0] = price[0];
		for(int i = 1; i < length; i++) {
			for(int j = 0; j < i; j++) {
				maxPriceArr[i] = Math.max(maxPriceArr[i], price[j] + maxPriceArr[i - j - 1]);
			}
			maxPriceArr[i] = Math.max(maxPriceArr[i], price[i]);
		}
		return maxPriceArr[length - 1];
	}
	
	
}
