package com.kas.dsasupreme.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class sortEnvelopes implements Comparator<int[]> {
    public int compare(int[] a, int[] b){
        if(a[0] == b[0]){
		//to ignore the duplicates, we are sorting such that, for same width-> element with 
		//largest height would be considered first, in this way all the other smaller heights would
		//be ignored
            return b[1] - a[1]; //higher first
        } else{
            return a[0] - b[0]; //lower first
        }
    }
}
public class Day119__5_RussianDollDpBinrySrcSopt {
	// pos //0, 1,2,3,4
	//static int[][] ip = new int[][] { {5,4},{6,4},{6,7},{2,3} }; //ans 3
	static int[][] ip = new int[][] { {1,1},{1,1},{1,1}}; //
	static int n = ip.length;
	static int[][] dp = new int[n + 1][n + 1];

	static int countDearr() {

		// int[] ans = new int[n];
		// ans[0] = ip[0];
		Arrays.sort(ip,new sortEnvelopes());
	
		
		int[] height = new int[ip.length];
		for(int i=0;i<ip.length;i++){
			height[i] = ip[i][1];
		}
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(height[0]);
		for (int i = 1; i < height.length; i++) {
			if (height[i] > ans.get(ans.size() - 1)) {
				ans.add(height[i]);
			} else {
				//find just bda elem from ans
				int index = lowerBound(ans, height[i]);
				ans.set(index, height[i]);
			
			}
		}
		return ans.size();
	}
	//finding the index of greatest smaller element 
    static public int lowerBound(ArrayList<Integer> list, int search){
        int start = 0;
        int end = list.size()-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(list.get(mid) < search){
                start = mid+1;
            } else{
                end = mid;
            }
        }
        return start;
    }

	public static void main(String[] args) {

		System.out.println(countDearr());
		// System.out.println(op);
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5