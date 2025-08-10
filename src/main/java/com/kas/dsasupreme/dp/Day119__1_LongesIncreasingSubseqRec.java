package com.kas.dsasupreme.dp;

import java.util.ArrayList;
import java.util.List;

public class Day119__1_LongesIncreasingSubseqRec {
	// pos //0, 1,2,3,4
	//static int[] ip = new int[] { 5,8,3,7,9,1}; //
	static int[] ip = new int[] { 10,9,2,5,3,7,101,18};
	
	static int n = ip.length;
	static List<Integer> op= new ArrayList<Integer>();
	static int countDearr(int curr, int prev) {
		// here if frog reaches to 4 then stop
		//if (prev == -1) return 1;
		if(curr >= n-1) return 0;
		
		int inc =0,exc=0;
		
		if(prev == -1 || ip[curr] > ip[prev])
		{op.add(ip[curr]);
		inc = 1 + countDearr(curr + 1, curr);
		}
		
		exc = 0 + countDearr(curr+1, prev);
		
		

		return Math.max(inc, exc);
	}

	public static void main(String[] args) {
		System.out.println(countDearr(0, -1));
		System.out.println(op);
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5