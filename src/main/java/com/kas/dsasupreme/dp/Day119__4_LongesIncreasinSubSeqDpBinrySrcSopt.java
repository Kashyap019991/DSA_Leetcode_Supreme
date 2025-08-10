package com.kas.dsasupreme.dp;

import java.util.ArrayList;

public class Day119__4_LongesIncreasinSubSeqDpBinrySrcSopt {
	// pos //0, 1,2,3,4
	//static int[] ip = new int[] { 1, 7, 9, 1 }; //
	static int[] ip = new int[] { 10,9,2,5,3,7,101,18};
	static int n = ip.length;
	static int[][] dp = new int[n + 1][n + 1];

	static int countDearr() {

		// int[] ans = new int[n];
		// ans[0] = ip[0];
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(ip[0]);
		for (int i = 1; i < n; i++) {
			if (ip[i] > ans.get(ans.size() - 1)) {
				ans.add(ip[i]);
			} else {
				//find just bda elem from ans
				int index = lowerBound(ans, ip[i]);
				ans.set(index, ip[i]);
			
			}
		}
		System.out.println(ans);
		return ans.size();
	}
	//finding the index of greatest smaller element 
    static public int lowerBound(ArrayList<Integer> list, int search){
        int start = 0;
        int end = list.size()-1;
        while(start<end){
            int mid = start + (end)/2;//3/2 =1
            if(list.get(mid) < search){
                start = mid+1;
            } else{
                end = mid;
            }
        }
        return start;
    }

	public static void main(String[] args) {
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++)
				dp[i][j] = 0;
		}

		System.out.println(countDearr());
		 
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5