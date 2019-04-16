package com.prac.dsalgo.sorting;

import java.util.Arrays;

public class BasicSorts {

	public void selectionSort(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			int max = i;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[max]) {
					max = j;
				}
			}
			if (i != max) {
				int temp = arr[i];
				arr[i] = arr[max];
				arr[max] = temp;
			}
		}
	}

	public void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean swap = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swap = true;
				}
			}
			if (!swap) {
				break;
			}
		}
	}

	public void recursiveBubbleSort(int[] arr) {
		recursiveBubbleSort(arr, arr.length - 1);
	}

	private void recursiveBubbleSort(int[] arr, int to) {
		if (to == 0) {
			return;
		}
		boolean swap = false;
		for (int i = 0; i < to; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
				swap = true;
			}
		}
		if (!swap) {
			return;
		}
		recursiveBubbleSort(arr, to - 1);
	}

	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int key = arr[i];
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	public void binaryInsertionSort(int array[]) {
		for (int i = 1; i < array.length; i++) {
			int x = array[i];

			// Find location to insert using binary search
			int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

			// Shifting array to one location right
			System.arraycopy(array, j, array, j + 1, i - j);

			// Placing element at its correct location
			array[j] = x;
		}
	}

	public void recursiveInsertionSort(int[] arr) {
		recursiveInsertionSort(arr, 1);
	}

	private void recursiveInsertionSort(int[] arr, int from) {
		if (from >= arr.length) {
			return;
		}
		int j = from - 1;
		int curVal = arr[from];
		while (j >= 0 && arr[j] > curVal) {
			arr[j + 1] = arr[j];
			j--;
		}
		arr[j + 1] = curVal;
		recursiveInsertionSort(arr, from + 1);
	}

	public void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	private void mergeSort(int[] arr, int i, int j) {
		if (i == j) {
			return;
		}
		int mid = (i + j) / 2;
		mergeSort(arr, i, mid);
		mergeSort(arr, mid + 1, j);
		mergeArrays(arr, i, mid, j);
	}

	private void mergeArrays(int[] arr, int left, int mid, int right) {
		int lPtr = 0, rPtr = 0;
		int[] lArr = new int[mid - left + 1];
		int[] rArr = new int[right - mid];
		System.arraycopy(arr, left, lArr, 0, mid - left + 1);
		System.arraycopy(arr, mid + 1, rArr, 0, right - mid);

		while (lPtr < (mid - left + 1) && rPtr < (right - mid)) {
			if (lArr[lPtr] <= rArr[rPtr]) {
				arr[left + lPtr + rPtr] = lArr[lPtr];
				lPtr++;
			} else {
				arr[left + lPtr + rPtr] = rArr[rPtr];
				rPtr++;
			}
		}
		if (lPtr == (mid - left + 1)) {
			while (rPtr < (right - mid)) {
				arr[left + lPtr + rPtr] = rArr[rPtr];
				rPtr++;
			}
		} else {
			while (lPtr < (mid - left + 1)) {
				arr[left + lPtr + rPtr] = lArr[lPtr];
				lPtr++;
			}
		}
	}

	public void quickSort(int[] arr) {
		quickSortRightPivot(arr, 0, arr.length - 1);
	}

	private void quickSortMidPivot(int[] arr, int i, int j) {
		if (i >= j) {
			return;
		}
		int pivot = arr[(i + j) / 2];
		int low = i, high = j;
		while (low <= high) {
			while (arr[low] < pivot) {
				low++;
			}
			while (arr[high] > pivot) {
				high--;
			}
			if (low <= high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				low++;
				high--;
			}
		}
		quickSortMidPivot(arr, i, high);
		quickSortMidPivot(arr, low, j);
	}

	private void quickSortRightPivot(int[] arr, int i, int j) {
		if (i < j) {
			int partition = partition(arr, i, j);
			quickSortRightPivot(arr, i, partition - 1);
			quickSortRightPivot(arr, partition + 1, j);
		}
	}

	private int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = pivot;
		arr[right] = temp;
		return i + 1;
	}

	public static void main(String[] args) {
		int arr[] = { 4, 25, 23, 22, 11, 2, 1 };

		BasicSorts bs = new BasicSorts();
		bs.quickSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
