package com.prac.dsalgo;

import java.util.Arrays;
import java.util.Stack;

public class Sample {
	
	public static void mergeSort(int []arr, int from, int to) {
        if(from >= to) {
            return;
        }
        int mid = (from + to)/2;
        mergeSort(arr, from, mid);
        mergeSort(arr, mid + 1, to);
        mergeArrays(arr, from, to, mid);
    }
    
    public static void mergeArrays(int []arr, int from, int to, int mid) {
        int []tempArr = new int[to - from + 1];
        int i = from, j = mid + 1;
        int k = 0;
        while(i <= mid && j <= to) {
            if(arr[i] < arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                tempArr[k++] = arr[j++];
            }
        }
        while(i <= mid) {
            tempArr[k++] = arr[i++];
        }
        while(j <= to) {
            tempArr[k++] = arr[j++];
        }
        k = 0;
        for(int l = from; l <= to; l++) {
            arr[l] = tempArr[k++];
        }
    }
	public static void main(String[] args) {
		int []arr = {5, 4, 3, 2, 1};
		mergeSort(arr, 0, 4);
		System.out.println(Arrays.toString(arr));
	}
}
