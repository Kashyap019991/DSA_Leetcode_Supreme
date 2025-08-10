package com.kas.dsasupreme._6_Recursion;

public class _3_RecursionL4_MaxSumNonAdjNodeRec {

static int n =4;
static int[] ip = new int[]{9,9,8,2};

	public static int maxSumNonAdjNode(int i){
		//base case
		//if(i== 0) return ip[i];
		if(i<0) return 0;
		
		int incl = maxSumNonAdjNode(i-2) + ip[i];
		int excl = maxSumNonAdjNode(i-1) + 0;
		
		return Math.max(incl,excl);		
		
	}
/*public static int maxSumNonAdjNode(int i){
	//base case
	//if(i== 0) return ip[i];
	if(i>=n) return 0;
	
	int incl = maxSumNonAdjNode(i+2) + ip[i];
	int excl = maxSumNonAdjNode(i+1) + 0;
	
	return Math.max(incl,excl);		
	
}*/
	public static void main(String[] args) {
		
		System.out.println(maxSumNonAdjNode(n-1));
	}
}
//0 1 1 2 3 5 8
	 // 1 2 3 4 5