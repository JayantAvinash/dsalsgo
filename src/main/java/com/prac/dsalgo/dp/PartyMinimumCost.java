package com.prac.dsalgo.dp;

import java.util.Arrays;

/*As it is Tushar’s Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune.
Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar’s friends are satisfied (reached their eating capacity).

NOTE:

Each dish is supposed to be eaten by only one person. Sharing is not allowed.
Each friend can take any dish unlimited number of times.
There always exists a dish with filling capacity 1 so that a solution always exists.
Input Format

Friends : List of integers denoting eating capacity of friends separated by space.
Capacity: List of integers denoting filling capacity of each type of dish.
Cost :    List of integers denoting cost of each type of dish.
Constraints:
1 <= Capacity of friend <= 1000
1 <= No. of friends <= 1000
1 <= No. of dishes <= 1000

Example:

Input:
 A : [ 2, 3, 1, 5, 4 ]
B : [ 3, 2, 4, 1 ]
C : [ 1, 2, 5, 10 ]

Output:
    20

Explanation: 
    First friend will take 1st and 2nd dish, second friend will take 2nd dish twice.  Thus, total cost = (5+3)+(3*2)= 14*/

public class PartyMinimumCost {
	
	public int getMinimumCost(int capacity, int []foodCapacity, int []foodCost) {
		int []minCost = new int[capacity + 1];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		minCost[0] = 0;
		for(int  i = 1; i <= capacity; i++) {
			for(int j = 0; j < foodCapacity.length; j++) {
				if(foodCapacity[j] <= i) {
					minCost[i] = Math.min(minCost[i], foodCost[j] + minCost[i - foodCapacity[j]]);
				}
			}
		}
		return minCost[capacity];
	}
	
	public static void main(String[] args) {
		PartyMinimumCost partyMinCost = new PartyMinimumCost();
		int[] friendsCapacity = {2, 3, 1, 5, 4};
		int[] foodCapacity = {3, 2, 4, 1};
		int []foodCost = {1, 2, 5, 10};
		int minCost = 0;
		for(int i = 0; i < friendsCapacity.length; i++) {
			minCost += partyMinCost.getMinimumCost(friendsCapacity[i], foodCapacity, foodCost);
		}
		System.out.println(minCost);
	}
	

}
