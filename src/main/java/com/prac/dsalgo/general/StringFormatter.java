package com.prac.dsalgo.general;


/*https://leetcode.com/problems/license-key-formatting/
*/public class StringFormatter {
	
	 public String licenseKeyFormatting(String S, int K) {
		 	if(S == null) {
		 		return null;
		 	}
	        char []sArr = S.toCharArray();
	        int count = 0;
	        for(int i = 0; i < sArr.length; i++) {
	            if(sArr[i] == '-') {
	                continue;
	            }
	            count++;
	        }
	        int r = count % K;
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < sArr.length; i++) {
	            if(sArr[i] == '-') {
	                continue;
	            }
	            if(r == 0) {
	                r = K;
	                if(i != 0) {
	                    sb.append('-');
	                }
	                
	            }
	            sb.append(sArr[i]);
	            r--;
	        }
	        return sb.toString();
	    }

	public static void main(String[] args) {
		StringFormatter s = new StringFormatter();
		System.out.println(s.licenseKeyFormatting("2-5g-3-J", 2));

	}

}
