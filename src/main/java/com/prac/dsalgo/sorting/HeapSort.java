package com.prac.dsalgo.sorting;

public class HeapSort {

	public void sort(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			heapify(arr, i, 0);
		}
	}

	private void heapify(int[] arr, int n, int i) {
		int largest = i;
		int lChild = 2 * i + 1;
		int rChild = 2 * i + 2;
		if (lChild < n && arr[lChild] > arr[largest]) {
			largest = lChild;
		}
		if (rChild < n && arr[rChild] > arr[largest]) {
			largest = rChild;
		}
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, n, largest);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 4, 25, 23, 22, 11, 2, 1 };
		HeapSort hs = new HeapSort();
		hs.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

}
