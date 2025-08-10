package com.kas.dsasupreme.dp;

public class Day128__1_GuessNoRec {
	static int solveRec(int start,int end){
        //no number pending
        if(start >= end) return 0;
        
        int ans = 99999999;
        for(int i=start;i<=end;i++){
            ans = Math.min(ans, i + Math.max(solveRec(start,i-1), solveRec(i+1,end)));
        }
        return ans;
    }

	
	public static void main(String[] args) {

		int n = 10;

		System.out.println(solveRec(1,n)); //ans =16
	}
}
