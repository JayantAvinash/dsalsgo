package com.prac.dsalgo.general;

public class TwoStringsGCD {

	public String gcdOfStrings(String str1, String str2) {
		if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) {
			return "";
		}
		int l1 = str1.length(), l2 = str2.length();
		int gcd = getGcd(l1, l2);
		if (!str1.substring(0, gcd).equals(str2.substring(0, gcd))) {
			return "";
		}
		boolean repititive = isRepititive(str1, gcd);
		if (!repititive) {
			return "";
		}
		repititive = isRepititive(str2, gcd);
		if (!repititive) {
			return "";
		}
		return str1.substring(0, gcd);
	}

	boolean isRepititive(String str, int l) {
		int i = 0;
		while (i < str.length() - l) {
			for (int j = 0; j < l; j++) {
				if (str.charAt(i + j) != str.charAt(i + l + j)) {
					return false;
				}
			}
			i += l;
		}
		return true;
	}

	public int getGcd(int l1, int l2) {
		while (l2 % l1 != 0) {
			int temp = l2;
			l2 = l1;
			l1 = temp % l1;
		}
		return l1;
	}

	public String gcdOfStringsV2(String str1, String str2) {
		return GCD(str1, str2);
	}

	public String GCD(String a, String b) {
		if (a.length() == 0)
			return b;
		if (b.length() == 0)
			return a;
		if (a.equals(b))
			return a;
		if (a.length() > b.length()) {
			for (int i = 0; i < b.length(); i++) {
				if (b.charAt(i) != a.charAt(i)) {
					return "";
				}
			}
			String temp = a.substring(b.length());
			return GCD(temp, b);
		} else if (b.length() > a.length())
			return GCD(b, a);
		else
			return "";
	}

	public static void main(String[] args) {
		TwoStringsGCD t = new TwoStringsGCD();
		System.out.println(t.gcdOfStrings("ABABAB", "ABAB"));

	}

}
