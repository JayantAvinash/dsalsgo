package com.prac.dsalgo.dp;

import java.util.ArrayList;
import java.util.List;

public class MaxCherries {
	
	public int cherryPickup(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0][0] == -1 || grid[grid.length - 1][grid[0].length - 1] == -1) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        List<Coordinates> s = new ArrayList<>();
        Coordinates root = new Coordinates(0, 0);
        s.add(root);
        int val = getMaxCherries(grid, root, s);
        if(val == -1) {
            return 0;
        }
        for(Coordinates c : s) {
            grid[c.x][c.y] = 0;
        }
        return val + getMaxCherries(grid, new Coordinates(0, 0), s);
    }
    
    private int getMaxCherries(int [][]grid, Coordinates c, List<Coordinates> s) {
        if(c.x == grid.length - 1 && c.y == grid[0].length - 1) {
            s.add(c);
            return grid[c.x][c.y];
           
        }
        int right = -1;
        int bottom = -1;
        if(c.x < grid.length - 1 && grid[c.x + 1][c.y] != -1) {
            bottom = getMaxCherries(grid, new Coordinates(c.x + 1, c.y), s);
        }
        if(c.y < grid[0].length - 1 && grid[c.x][c.y + 1] != -1) {
            right = getMaxCherries(grid, new Coordinates(c.x, c.y + 1), s);
        }
        if(bottom == -1 && right == -1) {
            return -1;
        }
        if(right > bottom) {
        	s.add( new Coordinates(c.x, c.y + 1));
        	return grid[c.x][c.y] + right;
        }
        s.add( new Coordinates(c.x + 1, c.y));
        return grid[c.x][c.y] + bottom;
    }
    
    class Coordinates {
        int x;
        int y;
        Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxCherries m = new MaxCherries();
		int [][]arr = {{0, 1, -1},
				 {1, 0, -1},
				 {1, 1,  1}};
		System.out.println(m.cherryPickup(arr));
	}

}
