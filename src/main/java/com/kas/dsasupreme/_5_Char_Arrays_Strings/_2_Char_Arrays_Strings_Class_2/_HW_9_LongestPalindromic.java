package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;

import java.util.Arrays;

class _HW_9_LongestPalindromic {
    
      public static  void subsequence(int[] arr,int index,int[] op) {
    	  int n = arr.length;
    	  
    	  //base case
    	  if(index == n){
    		  System.out.println(Arrays.toString(op));
    		  return;
    	  }
    	 // for(int i=0;i<n;i++){
    		  //incl
    		  op[index]=arr[index];
    		  subsequence(arr, index+1,op );
    		  op[index]=0;
    		  subsequence(arr, index+1,op );
    	 // }
    	  
    }
       public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		int[] op = new int[arr.length];
		subsequence(arr,0,op);
	}
}