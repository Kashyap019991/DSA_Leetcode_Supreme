package com.kas.dsasupreme.dp;

public class Day121__1_Pizza3nSliceRec {
	// pos //0, 1,2,3,4
//	static int[] slices = new int[] {1,2,3,4,5,6}; // ans =10
	static int[] slices = new int[] {8,9,8,6,1,1}; //ans=16
	
	static int k = slices.length;
	static int countDearr(int startInd,int endingInd , int n) {
	
		if(n == 0 || startInd > endingInd){
			return 0;
		}
		
		int inc = slices[startInd] + countDearr(startInd +2, endingInd, n-1);
		int exc = 0 + countDearr(startInd +1, endingInd, n);
		
		return Math.max(inc, exc);
	}

	public static void main(String[] args) {
		//include 1st so skip last
		int first = countDearr(0, k-2, k/3);
		
		//including last slice so skip 0th
		int last = countDearr(1, k-1, k/3);
		System.out.println(Math.max(first, last));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5