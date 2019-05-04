package com.prac.dsalgo.general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
	
	public int[][] getKClosestPointToOrigin(int [][]points, int k) {
		PriorityQueue<List<Integer>> pointsQueue = new PriorityQueue<>(points.length, new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> l1, List<Integer> l2) {
				return getDistanceFromOrigin(l1) - getDistanceFromOrigin(l2);
			}
			
		});
		
		for(int i = 0; i < points.length; i++) {
			pointsQueue.offer(Arrays.asList(points[i][0], points[i][1]));
		}
		
		int[][] closestPoints = new int[k][2];
		
		int i = 0;
		while(!pointsQueue.isEmpty() && i < k) {
			List<Integer> point = pointsQueue.poll();
			closestPoints[i][0] = point.get(0);
			closestPoints[i][1] = point.get(1);
			i++;
		}
		return closestPoints;
	}
	
	public int getDistanceFromOrigin(List<Integer> point) {
		return point.get(0)*point.get(0) + point.get(1)*point.get(1);
	}
	
	public static void main(String[] args) {
		KClosestPointsToOrigin kcpo = new KClosestPointsToOrigin();
		int[][] points = {{1,3},{-2,2}};
		int[][] closestPoints = kcpo.getKClosestPointToOrigin(points, 1);
		for(int i = 0; i < closestPoints.length; i++) {
			System.out.println(closestPoints[i][0] + "," + closestPoints[i][1]);
		}
	}
	
	
}
