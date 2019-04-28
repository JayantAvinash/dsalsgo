package com.prac.dsalgo.structures;

public class MinHeap {

	int position;
	int[] heapArray;
	int size;

	public MinHeap(int size) {
		this.size = size;
		heapArray = new int[size + 1];
		heapArray[0] = Integer.MIN_VALUE;
	}

	public void insert(int a) {
		position++;
		if (position > size) {
			System.out.println("Array already full");
		}
		heapArray[position] = a;
		heapifyUp();
	}

	private void heapifyUp() {
		int current = position;
		while (current > 0 && heapArray[current] < heapArray[current / 2]) {
			int temp = heapArray[current / 2];
			heapArray[current / 2] = heapArray[current];
			heapArray[current] = temp;
			current /= 2;
		}
	}
	
	public int extractMin() {
		if(position > 0) {
			int min = heapArray[1];
			heapArray[1] = heapArray[position];
			heapArray[position] = 0;
			position--;
			heapifyDown(1);
			return min;
		}
		return heapArray[0];
	}

	private void heapifyDown(int i) {
		int minIndex = i;
		if(2*i <= position && heapArray[2*i] < heapArray[minIndex]) {
			minIndex = 2*i;
		}
		if(2*i + 1 <= position && heapArray[2*i + 1] < heapArray[minIndex]) {
			minIndex = 2*i + 1;
		}
		if(minIndex == i) {
			return;
		}
		int temp = heapArray[minIndex];
		heapArray[minIndex] = heapArray[i];
		heapArray[i] = temp;
		heapifyDown(minIndex);
	}
	
	public void display() {
		if(position > 0) {
			for(int i = 1; i < heapArray.length; i++) {
				System.out.print(heapArray[i] + "\t");
			}
		}
	}
	
	public void createHeap(int[] a) {
		if(a.length > 0) {
			for(int i = 0; i < a.length; i++) {
				insert(a[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		int arrA [] = {3,2,1,7,8,4,10,16,12};
		System.out.print("Original Array : ");
		for(int i=0;i<arrA.length;i++){
			System.out.print("  " + arrA[i]);
		}
		MinHeap mh = new MinHeap(arrA.length);
		System.out.print("\nMin-Heap : ");
		mh.createHeap(arrA);		
		mh.display();
		System.out.print("Extract Min :");
		for(int i=0;i<arrA.length;i++){
			System.out.print("  " + mh.extractMin());
		}
	}

}
