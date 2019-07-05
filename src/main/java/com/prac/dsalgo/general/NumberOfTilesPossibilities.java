package com.prac.dsalgo.general;

// https://leetcode.com/problems/letter-tile-possibilities/
public class NumberOfTilesPossibilities {
	
	 public int numTilePossibilities(String tiles) {
	        char []tilesArr = tiles.toCharArray();
	        int []count = new int[26];
	        for(char c : tilesArr) {
	            count[c - 'A']++;
	        }
	        return possibilities(count);
	    }
	    
	    private int possibilities(int []count) {
	        int num = 0;
	        for(int i = 0; i < count.length; i++) {
	            if(count[i] == 0) {
	                continue;
	            }
	            num++;
	            count[i]--;
	            num += possibilities(count);
	            count[i]++;
	        }
	        return num;
	    } 

	public static void main(String[] args) {
		NumberOfTilesPossibilities n = new NumberOfTilesPossibilities();
		System.out.println(n.numTilePossibilities("ABC"));
		System.out.println(n.numTilePossibilities("AAABBC"));
	}

}
