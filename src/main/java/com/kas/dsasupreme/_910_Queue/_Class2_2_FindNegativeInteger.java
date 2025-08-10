package com.kas.dsasupreme._910_Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.com/problems/sliding-window-maximum/description/
class _Class2_2_FindNegativeInteger {

	public static int[] findNegativeInteger(int[] nums, int k) {
		int n = nums.length;
		int[] ans = new int[n - k + 1];
		Queue<Integer> q = new LinkedList<>();

		// step 1. Handle first window
		int index = 0;
		for (int i = 0; i < k; i++) {
			if (nums[i] < 0)
				q.add(i); // index ko Q mai store kr lia
		}

		// start window from k ... remaining element ko process kro
		for (int i = k; i < n; i++) {
			// answer dedo purani window ka
			if (q.isEmpty()) {
				ans[index] = 0;
				index++;
			} else {
				ans[index] = nums[q.peek()];
				index++;
			}

			// out of window element ko remove kr do
			while (!q.isEmpty() && i - q.peek() >= k) {
				q.poll();
			}

			// check curr elem for insert into ans
			// jab <0 ho tab push kar do
			if (nums[i] < 0) {
				q.add(i);
			}
		}
		//last window ka ans add kr do
		if(q.isEmpty()){
			ans[index] = 0;
		    index++;
		}
		else
		{
			ans[index] = nums[q.peek()];
		    index++;
		}
		return ans;

	}

	public static void main(String[] args) {
		int[] nums = { 12, -1, -7, 18, -15, 30, 16, 28 };
		int k = 3;
		if(-1 < -3)
			System.out.println("-1 less");
		else
			System.out.println("-1 not");
		System.out.println(Arrays.toString(findNegativeInteger(nums, k)));
	}
}