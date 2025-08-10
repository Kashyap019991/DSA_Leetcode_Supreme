package com.kas.dsasupreme._4_Searching_Sorting._3_SearchingandSortingClass_3;

import java.util.Arrays;

class HW5_AggresiveCowBS {

	    static boolean isPossible(int[] stalls,int mid,int k,int n){
	        int pos = stalls[0];
	        int kCount = 1;
	        for(int i=1;i<n;i++){
	            
	            if(stalls[i] - pos >= mid){//incr kcount as its possible to aallocate
	                kCount++;
	                pos = stalls[i];
	                
	            }
	            if(kCount == k){
	                 return true;   
	                }
	            
	        }
	        
	        return false;
	    }
	    public static int solve(int n, int k, int[] stalls) {
	    	Arrays.sort(stalls);
	        int start = 0;
	        int end  = stalls[n-1] - stalls[0];
	        int mid;
	        int ans = 0;
	        while(start <= end){
	        	mid = start + (end - start)/2;
	            if(isPossible(stalls, mid, k ,n)){ //increase mid and store ans
	                ans = mid;
	                start = mid +1;
	            }
	            else{//decrease mid
	                end = mid-1;
	            }
	        }
	        return ans;
	    }
	    
	    public static void main(String[] args) {
			int ans = solve(5, 3
					,new int[]{1, 2, 4, 8, 9});
			System.out.println(ans);
		}
	
}