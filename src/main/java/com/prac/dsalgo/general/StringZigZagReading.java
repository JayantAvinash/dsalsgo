package com.prac.dsalgo.general;

public class StringZigZagReading {

	public String convert(String s, int numRows) {
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) {
			sb[i] = new StringBuilder();
		}
		char[] cArr = s.toCharArray();
		int len = cArr.length;
		int i = 0;
		while (i < len) {
			for (int j = 0; j < numRows && i < len; j++) {
				sb[j].append(cArr[i++]);
			}
			for (int j = numRows - 2; j >= 1 && i < len; j--) {
				sb[j].append(cArr[i++]);
			}
		}
		for (int j = 1; j < numRows; j++) {
			sb[0].append(sb[j]);
		}
		return sb[0].toString();
	}

	public static void main(String[] args) {
		StringZigZagReading s = new StringZigZagReading();
		System.out.println(s.convert("PAYPALISHIRING", 4));

	}

}
