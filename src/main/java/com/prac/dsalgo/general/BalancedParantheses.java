package com.prac.dsalgo.general;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;



public class BalancedParantheses {
	 static String isBalanced(String s) {
	        if(s==null) {
	            return "NO";
	        }
	        Stack<Character> stack = new Stack<Character>();
	        for(char c : s.toCharArray()) {
	            if(c == '(' || c == '{' || c == '[') {
	                stack.push(c);
	            } else if(stack.isEmpty()) {
	                return "NO";
	            } else if(c == ')') {
	                if(stack.peek() == '(') {
	                    stack.pop();
	                } else {
	                    return "NO";
	                }
	            } else if(c == ']') {
	                if(stack.peek() == '[') {
	                    stack.pop();
	                } else {
	                    return "NO";
	                }
	            } else if(c == '}') {
	                if(stack.peek() == '{') {
	                    stack.pop();
	                } else {
	                    return "NO";
	                }
	            }
	        }
	        if(stack.isEmpty()) {
	            return "YES";
	        }
	        return "NO";
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int t = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int tItr = 0; tItr < t; tItr++) {
	            String s = scanner.nextLine();

	            String result = isBalanced(s);

	            bufferedWriter.write(result);
	            bufferedWriter.newLine();
	        }
	       /* 
	        Sample Input:
	        	3
	        	{[()]}
	        	{[(])}
	        	{{[[(())]]}}*/

	        bufferedWriter.close();

	        scanner.close();
	    }
}
