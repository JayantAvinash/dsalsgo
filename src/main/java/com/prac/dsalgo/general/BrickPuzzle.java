package com.prac.dsalgo.general;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/red-john-is-back/problem
public class BrickPuzzle {
	
	static List<Integer> noOfPrimes = new ArrayList<>();

    // Complete the redJohn function below.
    static int redJohn(int n) {
        int maxHorizontalAlignments = n/4;
        int noOfArrangements = 0;
        for(int i = 0; i <= maxHorizontalAlignments ; i++) {
            int single = n - 4*i;
            int total = n - 3*i;
            int max = Math.max(single, i);
            int min = Math.min(single, i);
            double arrangements = 1;
            while(total != max) {
                arrangements = (arrangements*total)/min;
                total--;
                min--; 
            }
            noOfArrangements += (int)Math.round(arrangements);
        }
        return countPrimes(noOfArrangements);
    }

    static int countPrimes(int n) {
        int size = noOfPrimes.size();
        if(size < n) {
            for(int i = size + 1; i <= n; i++) {
                int x = i - 2;
                if(isPrime(i)) {
                    noOfPrimes.add(1 + (x >= 0 ? noOfPrimes.get(x) : 0));
                } else {
                    noOfPrimes.add((x >= 0 ? noOfPrimes.get(x) : 0));
                }
            }
        }
        return noOfPrimes.get(n - 1);
    }

    static boolean isPrime(int n) {
        if(n <= 1) {
            return false;
        }
        if(n <= 3) {
            return true;
        }
        if(n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for(int i = 5; i*i <= n; i += 6) {
            if(n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }


	public static void main(String[] args) {
		System.out.println(BrickPuzzle.redJohn(34));

	}

}
