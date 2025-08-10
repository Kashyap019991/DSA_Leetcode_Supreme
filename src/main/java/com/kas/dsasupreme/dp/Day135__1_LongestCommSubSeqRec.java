package com.kas.dsasupreme.dp;

public class Day135__1_LongestCommSubSeqRec {
	 static int solveRec(String text1, String text2,int i, int j){
	     //base case
		 if(text1.length() == i) return 0;
		 if(text2.length() == j) return 0;
		 
		 int ans =0;
		 if(text1.charAt(i) == text2.charAt(j))
			 ans = 1 + solveRec(text1,text2,i+1,j+1);
		 else
			 ans = 0 + Math.max(solveRec(text1,text2,i+1,j), solveRec(text1,text2,i,j+1));
		 
	        return ans;
	    }
	public static void main(String[] args) {
		//multiple time b->s allowed
		//String text1 = "abc", text2 = "abc"; //ans =3
		String text1 = "abc", text2 = "def"; //ans =0
		System.out.println(solveRec(text1, text2,0,0));
	}
}
