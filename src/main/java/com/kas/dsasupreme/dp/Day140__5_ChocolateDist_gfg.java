package com.kas.dsasupreme.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day140__5_ChocolateDist_gfg {
/*
 * int N = 7; // chokolate packet array each show no. of chockolate in pkt 
		int M = 3;//no. of students
		int[] A = new int[]{7, 3, 2, 4, 9, 12, 56};
 * 
 */
	static int chokolateDist(int N, int M, ArrayList A) {
		int ans;
		Collections.sort(A);
		int i=0;
		int j = M-1;
		int mini = Integer.MAX_VALUE;
		while(j<A.size()){
			int diff = (Integer)A.get(j) - (Integer)A.get(i);
			mini = Math.min(mini, diff);
			i++;j++;
		}
		return mini;
	}

	public static void main(String[] args) {
		int N = 7; // chokolate packet array each show no. of chockolate in pkt 
		int M = 3;//no. of students
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(7, 3, 2, 4, 9, 12, 56));
	
		System.out.println(chokolateDist(N,M,A));
	}
}
