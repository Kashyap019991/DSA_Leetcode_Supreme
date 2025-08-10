package com.kas.dsasupreme.dp;

public class Day140__3_CheckSurvive {

	//int S = 10; // no. of days to survive
	//int N = 16; // max food buy each day
	//int M = 2; // required food each day

	static int checkSurvive(int nDays, int mFBuy, int reqF1Day) {
		int ans = 0;
		
		int noSundays = nDays/7;
		int totalFood = nDays * reqF1Day;
		if(totalFood%mFBuy  == 0){
			ans = totalFood/mFBuy;
		}
		else 
			{ans =  (totalFood/mFBuy) +1; }
		int buyingdays =  nDays - noSundays;
		
		if(ans <= buyingdays)
			return ans;
		else 
			return -1;
		
	}

	public static void main(String[] args) {
		
		int S = 10; // no. of days to survive
		int N = 16; // max food buy each day
		int M = 2; // required food each day
		
		System.out.println(checkSurvive(S,N,M));
	}
}
