package com.kas.dsasupreme.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day114__4_MinCostForTkt1SoptQueue {

	static int[] days = new int[] { 2, 5 };
	static int[] cost = new int[] { 1, 4, 25 }; // ans =2

	/*
	 * static int[] days = new int[]{1,4,6,7,8,20}; static int[] cost = new
	 * int[]{2,7,15}; //ans=11
	 */

	/*
	 * static int[] days = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 };
	 * static int[] cost = new int[] { 2, 7, 15 }; // ans =17
	 */
	static int n = days.length;

	static int countDearr() {

		int ans = 0;
		Queue<List<Integer>> weekly = new LinkedList<>();
		Queue<List<Integer>> monthly = new LinkedList<>();

		for (int day : days) {

			// step 1 remove expired days
			while (!monthly.isEmpty() && monthly.peek().get(0) + 30 <= day)
				monthly.poll();

			while (!weekly.isEmpty() && weekly.peek().get(0) + 7 <= day)
				weekly.poll();

			// step 2 add cost for current days
			weekly.add(Arrays.asList(day, ans + cost[1]));
			monthly.add(Arrays.asList(day, ans + cost[2]));

			// step 3 ans update
			ans = Math.min(ans + cost[0], Math.min(weekly.peek().get(1), monthly.peek().get(1)));
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(countDearr());
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5