package com.prac.dsalgo.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RatInAMaze {
	
	public void getPathUsingStack(int [][]maze, Coordinates source, Coordinates destination) {
		if(maze[source.x][source.y] != 1) {
			System.out.println("Source wrong");
			return;
		}
		Stack<Coordinates> path = new Stack<>();
		path.add(source);
		Set<Coordinates> visited = new HashSet<>();
		visited.add(source);
		while(!path.isEmpty()) {
			Coordinates temp = path.peek();
			Coordinates right = new Coordinates(temp.x + 1, temp.y);
			right.parent = temp;
			boolean blocked = true;
			if(isPossible(maze, right, visited)) {
				blocked = false;
				visited.add(right);
				path.push(right);
				if(right.equals(destination)) {
					System.out.println("Found");
					break;
				}
			}
			Coordinates left = new Coordinates(temp.x - 1, temp.y);
			left.parent = temp;
			if(isPossible(maze, left, visited)) {
				blocked = false;
				visited.add(left);
				path.push(left);
				if(left.equals(destination)) {
					System.out.println("Found");
					break;
				}
			}
			Coordinates up = new Coordinates(temp.x, temp.y - 1);
			up.parent = temp;
			if(isPossible(maze, up, visited)) {
				blocked = false;
				visited.add(up);
				path.push(up);
				if(up.equals(destination)) {
					System.out.println("Found");
					break;
				}
			}
			Coordinates down = new Coordinates(temp.x, temp.y + 1);
			down.parent = temp;
			if(isPossible(maze, down, visited)) {
				blocked = false;
				visited.add(down);
				path.push(down);
				if(down.equals(destination)) {
					System.out.println("Found");
					break;
				}
			}
			if(blocked) {
				path.pop();
			}
		}
		if(path.isEmpty()) {
			System.out.println("No path exist");
		} else {
			while(!path.isEmpty()) {
				Coordinates current = path.pop();
				System.out.println("(" + current.x + "," + current.y + ")");
				Coordinates parent = current.parent;
				if(parent != null) {
					while(!path.isEmpty() && !path.peek().equals(parent)) {
						path.pop();
					}
				}
			}
		}
	}
	
	public void getPath(int [][]maze, Coordinates source, Coordinates destination) {
		int []xMoves = {1, 0, 0, -1};
		int []yMoves = {0, 1, -1, 0};
		if(maze[source.x][source.y] != 1) {
			System.out.println("Source wrong");
			return;
		}
		List<Coordinates> path = new LinkedList<>();
		path.add(source);
		Set<Coordinates> visited = new HashSet<>();
		visited.add(source);
		boolean isPath = findPath(maze, source, destination, xMoves, yMoves, path, visited);
		if(isPath) {
			for(Coordinates current : path) {
				System.out.println("(" + current.x + "," + current.y + ")");
			}
			return;
		}
		System.out.println("No path exist");
	}
	

	private boolean findPath(int[][] maze, Coordinates source, Coordinates destination, int[] xMoves, int[] yMoves, List<Coordinates> path, Set<Coordinates> visited) {
		if(source.x == destination.x && source.y == destination.y) {
			return true;
		}
		for(int i = 0; i < 4; i++) {
			Coordinates nextSource = new Coordinates(source.x + xMoves[i], source.y + yMoves[i]);
			if(isPossible(maze, nextSource, visited)) {
				path.add(nextSource);
				visited.add(nextSource);
				boolean isPath = findPath(maze, nextSource, destination, xMoves, yMoves, path, visited);
				if(isPath) {
					return true;
				} else {
					path.remove(path.size() - 1);
				}
			}
					
		}
		return false;
	}


	private boolean isPossible(int[][] maze, Coordinates nextSource, Set<Coordinates> visited) {
		return (nextSource.x >= 0 && nextSource.x < maze.length && nextSource.y >= 0 && nextSource.y < maze[0].length && maze[nextSource.x][nextSource.y] == 1 && !visited.contains(nextSource));
	}


	public static void main(String[] args) {
		RatInAMaze riam = new RatInAMaze();
		int maze[][] = {{ 1, 0, 1, 1, 0 },  
                { 1, 1, 1, 0, 1 },  
                { 0, 1, 0, 1, 1 },  
                { 1, 1, 1, 1, 1 } };
		Coordinates source = riam.new Coordinates(0, 0);
		riam.getPathUsingStack(maze, source, riam.new Coordinates(2, 3));

	}
	
	public class Coordinates {
		int x;
		int y;
		Coordinates parent;
		
		Coordinates(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Coordinates other = (Coordinates) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		private RatInAMaze getOuterType() {
			return RatInAMaze.this;
		}
		
		
		
		
	}

}
