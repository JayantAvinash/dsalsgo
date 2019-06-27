package com.prac.dsalgo.general;

public class StringToInt {

	public int myAtoi(String str) {
		if (str == null) {
			return 0;
		}
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		}

		char[] strArr = str.toCharArray();
		if (strArr[0] != '-' && strArr[0] != '+' && (strArr[0] - '0') < 0 && (strArr[0] - '0') > 9) {
			return 0;
		}

		boolean negative = strArr[0] == '-';
		int num = 0;
		int range = Integer.MAX_VALUE / 10;
		for (int i = 0; i < strArr.length; i++) {
			int digit = strArr[i] - '0';
			if (digit < 0 || digit > 9) {
				if (i == 0 && (strArr[i] == '-' || strArr[i] == '+')) {
					continue;
				} else {
					break;
				}
			}
			if (num > range) {
				if (negative) {
					return Integer.MIN_VALUE;
				} else {
					return Integer.MAX_VALUE;
				}
			} else if (num == range) {
				if (negative && digit > 8) {
					return Integer.MIN_VALUE;
				} else if (!negative && digit > 7) {
					return Integer.MAX_VALUE;
				}
			}
			num = 10 * num + digit;

		}
		return negative ? -1 * num : num;
	}

	public static void main(String[] args) {
		StringToInt atoi = new StringToInt();
		System.out.println(atoi.myAtoi("-2147483647"));
		System.out.println(Integer.MIN_VALUE);

	}

}
