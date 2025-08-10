package com.kas.dsasupreme.dp;

import java.util.ArrayList;
import java.util.Arrays;

//Count Min no of op to convert string a to b
public class Day140__2_ShopinCandystore {
	static ArrayList<Integer> minMaxAmnt(int[] candies, int k, int n) {
		ArrayList<Integer> res = new ArrayList<>();
		Arrays.sort(candies);
		int buy = 0;
		int free = n-1;
		int minCost =0;
		
		while(buy <= free){
			minCost += candies[buy];
			buy++; 
			free = free - k;
		}
		res.add(minCost);
		
		buy = n-1;
		free = 0;
		int maxCost = 0;
		
		while(buy >= free){
			maxCost = maxCost + candies[buy];
			buy--;
			free = free + k;
		}
		res.add(maxCost);
		
		return res;
	}

	public static void main(String[] args) {
		int N = 4; // no. of candies
		int K = 2; // free candis on each buy
		int[] candies = new int[]{3,2,1,4};
		System.out.println(minMaxAmnt(candies, K, N));
	}
}
