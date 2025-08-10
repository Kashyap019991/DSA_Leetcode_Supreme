//https://www.codingninjas.com/codestudio/problem-details/cut-into-segments_1214651
//https://www.geeksforgeeks.org/maximize-the-number-of-segments-of-length-p-q-and-r/
package com.kas.dsasupreme._6_Recursion;

import java.util.Arrays;

class _2_RecursionL4_CutIntoSegments {
    public static int cutIntoSegments(int n,int x,int y,int z){
       
    	//base case
    	if(n == 0)
    		return 0;
    	int a = Integer.MIN_VALUE;
    	if(n-x >= 0){
    		a = cutIntoSegments(n-x, x, y, z)+1;
    	}
    	int b = Integer.MIN_VALUE;
    	if(n-y >= 0){
    		b = cutIntoSegments(n-y, x, y, z)+1;
    	}
    	int c = Integer.MIN_VALUE;
    	if(n-x >= 0){
    		c = cutIntoSegments(n-z, x, y, z)+1;
    	}
    	int ans = Math.max(Math.max(a, b),c) ;
    	return ans;
    }
    
    public static void main(String[] args) {
    	
    	int n = 11;
    	int x =2, y=3,z=5;
    	int ans = cutIntoSegments(n,x,y,z);
    	if(ans < 0)
		 	ans =  0;
		 //else ans;
		System.out.println(ans);
	}
}