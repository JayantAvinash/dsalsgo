package com.prac.dsalgo.general;

/*https://leetcode.com/problems/longest-absolute-file-path/
*/public class FolderLongestFilePath {
	
	 public int lengthLongestPath(String input) {
	        String []folderArr = input.split("\n");
	        int maxLen = 0;
	        int []pathLength = new int[folderArr.length + 1];
	        for(String name : folderArr) {
	            int startIndex = name.lastIndexOf("\t") + 1;
	            pathLength[startIndex + 1] = pathLength[startIndex] + name.length() - startIndex + 1;
	            int currLen = pathLength[startIndex + 1];
	            if(name.contains(".")) {
	                maxLen = Math.max(maxLen, currLen - 1);
	            }
	            
	        }
	        return maxLen;
	    }

	public static void main(String[] args) {
		FolderLongestFilePath f = new FolderLongestFilePath();
		System.out.println(f.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
	}

}
