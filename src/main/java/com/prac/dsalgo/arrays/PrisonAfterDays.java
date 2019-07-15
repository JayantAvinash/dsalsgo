package com.prac.dsalgo.arrays;

public class PrisonAfterDays {
	
	 public int[] prisonAfterNDays(int[] cells, int N) {
	        if(cells == null || cells.length < 3) {
	            return cells;
	        }
	        int l = cells.length;
	        for(int i = 0; i < N; i++) {
	            int []temp = new int[l];
	            temp[0] = cells[0];
	            temp[l - 1] = cells[l - 1];
	            for(int j = 1; j < l - 1; j++) {
	                
	                if(cells[j - 1] == cells[j+1]) {
	                    temp[j] = 1;
	                }
	                else {
	                    temp[j] = 0;
	                }
	            }
	            cells = temp;
	        }
	        return cells;
	    }

	public static void main(String[] args) {
		PrisonAfterDays p = new PrisonAfterDays();
		int []cells = {0,1,0,1,1,0,0,1};
		int []arr = p.prisonAfterNDays(cells, 7);
	}

}
