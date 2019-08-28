package com.prac.dsalgo.general;

/*https://leetcode.com/problems/rotated-digits/
*/public class GoodNumbers {

	public int rotatedDigits(int N) {
		String[] arr = new String[N];
		int count = 0;
		for (int i = 1; i <= N; i++) {
			arr[i - 1] = getStatus(i, arr);
			if ("good".equals(arr[i - 1])) {
				count++;
			}
		}
		return count;
	}

	public String getStatus(int n, String[] arr) {
		if (arr[n - 1] != null) {
			return arr[n - 1];
		}
		if (n < 10) {
			if (n == 0 || n == 1 || n == 8) {
				arr[n - 1] = "eligible";
			} else if (n == 2 || n == 5 || n == 6 || n == 9) {
				arr[n - 1] = "good";
			} else {
				arr[n - 1] = "bad";
			}
		} else {
			int k = n % 10;
			if (k == 3 || k == 4 || k == 7) {
				arr[n - 1] = "bad";
			} else {
				String status = getStatus(n / 10, arr);
				if ("bad".equals(status)) {
					arr[n - 1] = status;
				} else if ("eligible".equals(status)) {
					if (k == 2 || k == 5 || k == 6 || k == 9) {
						arr[n - 1] = "good";
					} else {
						arr[n - 1] = "eligible";
					}
				} else {
					arr[n - 1] = "good";
				}
			}
		}
		return arr[n - 1];
	}

	public static void main(String[] args) {
		GoodNumbers g = new GoodNumbers();
		System.out.println(g.rotatedDigits(20));

	}

}
