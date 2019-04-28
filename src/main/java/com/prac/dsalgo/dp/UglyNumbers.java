package com.prac.dsalgo.dp;

/**
 * @author jayant Numbers whose only prime factors are 2,3 or 5
 */
public class UglyNumbers {

	public int getNthUglyNumber(int n) {
		int count = 1;
		int i = 1;
		while (count < n) {
			i++;
			if (isUgly(i)) {
				count++;
			}
		}
		return i;
	}

	private boolean isUgly(int i) {
		i = maxDivide(i, 2);
		i = maxDivide(i, 3);
		i = maxDivide(i, 5);
		return i == 1;
	}

	private int maxDivide(int i, int j) {
		while (i % j == 0) {
			i /= j;
		}
		return i;
	}

	public int getNthUglyNumberDP(int n) {
		int[] uglies = new int[n];
		uglies[0] = 1;
		int i2 = 0, i3 = 0, i5 = 0;
		int nxt_mul_2 = 2 * uglies[i2], nxt_mul_3 = 3 * uglies[i3], nxt_mul_5 = 5 * uglies[i5],next_ugly_number = 1;
		for(int i = 1; i < n; i++) {
			next_ugly_number = Math.min(nxt_mul_2, Math.min(nxt_mul_3, nxt_mul_5));
			uglies[i] = next_ugly_number;
			if(next_ugly_number == nxt_mul_2) {
				i2++;
				nxt_mul_2 = 2*uglies[i2];
			}
			if(next_ugly_number == nxt_mul_3) {
				i3++;
				nxt_mul_3 = 3*uglies[i3];
			}
			if(next_ugly_number == nxt_mul_5) {
				i5++;
				nxt_mul_5 = 5*uglies[i5];
			}
		}
		return next_ugly_number; 
	}

	public static void main(String[] args) {
		UglyNumbers un = new UglyNumbers();
		System.out.println(un.getNthUglyNumberDP(150));
	}
}
