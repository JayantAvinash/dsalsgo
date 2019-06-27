package com.prac.dsalgo.general;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberWithExclusions {
	
	public int getPositiveRandom(int limit, int []exclusions) {
		Random r = new Random();
		int size = limit - exclusions.length;
		int num = r.nextInt(size);
		Arrays.sort(exclusions);
		for(int ex : exclusions) {
			if(num < ex) {
				break;
			}
			num++;
		}
		return num;
	}

	public static void main(String[] args) {
		int []exclusions = {0,2,3,4,6,7,8};
		RandomNumberWithExclusions r = new RandomNumberWithExclusions();
		System.out.println(r.getPositiveRandom(9, exclusions));

	}

}
