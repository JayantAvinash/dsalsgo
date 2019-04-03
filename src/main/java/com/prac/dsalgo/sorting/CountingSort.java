package com.prac.dsalgo.sorting;

/*Usage: if range of data to be sorted is known;ex: all numbers to be sorted are between 0-9
 * Algo: step 1: create a count array of all the characters;
 * step 2: modify count array to contain sum of all previous index count at every index
 * step 3: iterate through input array and put the elements at assigned indexes in sum count array and then reduce count by 1
 * 
 * */
public class CountingSort {
	
	public void sort(char input[]) {
		char output[] = new char[input.length];
		int count[] = new int[256];
		
		for(int i = 0; i < input.length; i++) {
			++count[input[i]];
		}
		
		for(int i = 1; i <=255; i++) {
			count[i] += count[i - 1];
		}
		
		for(int i = input.length - 1; i >=0; i--) {
			output[count[input[i]] - 1] = input[i];
			--count[input[i]];
		}
		for(int i = 0; i < input.length; i++) {
			input[i] = output[i];
		}
	}
	
	 public static void main(String args[]) 
	    { 
	        CountingSort ob = new CountingSort(); 
	        char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o', 
	                    'r', 'g', 'e', 'e', 'k', 's'
	                    }; 
	  
	        ob.sort(arr); 
	  
	        System.out.print("Sorted character array is "); 
	        for (int i=0; i<arr.length; ++i) 
	            System.out.print(arr[i]); 
	    }

}
