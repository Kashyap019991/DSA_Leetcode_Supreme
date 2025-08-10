package com.kas.dsasupreme._910_Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.com/problems/sliding-window-maximum/description/
//approach:https://leetcode.com/problems/sliding-window-maximum/solutions/458121/java-all-solutions-b-f-pq-deque-dp-with-explanation-and-complexity-analysis/
class _Class2_2_SlidingWindowMaximum_LC239 {

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] ans = new int[n - k + 1];
		int ri =0;
		Deque<Integer> dq = new ArrayDeque<Integer>();

		for (int i = 0; i < n; i++) {

			// remove oob element from dequeue
			if (!dq.isEmpty() && dq.peek() == i - k) {
				dq.poll();
			}
			//inside dq we are storing in decreasing order
			//remove smaller numbers than current one in k size window
			while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i] ){
				dq.pollLast();
			}
			
			//insert curent element in dq
			dq.offer(i);
			
			//1st window
			if(i>=k-1){
				ans[ri++] = nums[dq.peek()];
			}
			
			
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
	}
}