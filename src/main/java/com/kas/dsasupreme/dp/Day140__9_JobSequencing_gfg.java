package com.kas.dsasupreme.dp;

import java.util.Arrays;
import java.util.Comparator;

public class Day140__9_JobSequencing_gfg {
	static int[] JobScheduling(Job arr[], int n) {
		int[] ans = new int[2];
		
		//Sort Jobs in desc of profit
		Arrays.sort(arr, new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return ((Integer)o2.profit).compareTo(o1.profit);
			}
		});
		
		int maxiDeadline = Integer.MIN_VALUE;
		for(int i = 0; i<n;i++){
			maxiDeadline = Math.max(maxiDeadline, arr[i].deadline);
		}
		
		//schedule array with size maxi deadline inti woth -1
		int[] schedule = new int[maxiDeadline+1];
		Arrays.fill(schedule, -1);
		
		int count =0, maxProfit = 0;
		for(int i = 0; i<n; i++){
			int currId = arr[i].id;
			int currDeadLine = arr[i].deadline;
			int currProfit = arr[i].profit;
			
			for(int k = currDeadLine;k>0;k--){
				if(schedule[k] == -1) //then we can complete curr job
				{ 
					maxProfit = maxProfit + currProfit;
					schedule[k] = currDeadLine;
					count++;
					break;
				}
			}
			ans[0] = count;
			ans[1] = maxProfit;
		}
		
		return ans;
	}

	public static void main(String[] args) {

		int N = 4;
		//Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
		int[] id = new int[] { 1,2,3,4 };
		int[] deadline = new int[] { 4,1,1,1 };
		int[] profit = new int[] { 20,10,40,30 };
		Job[] arr = new Job[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new Job(id[i], deadline[i],profit[i]);
		}
		System.out.println(Arrays.toString(JobScheduling(arr, N)));
	}
}

class Job {
	int id, profit, deadline;

	Job(int x, int y, int z) {
		this.id = x;
		this.deadline = y;
		this.profit = z;
	}
}
