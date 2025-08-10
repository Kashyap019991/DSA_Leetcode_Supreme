//https://leetcode.com/problems/sort-an-array/description/

//array passby value not refe https://www.edureka.co/community/6475/is-java-pass-by-reference-or-pass-by-value?show=6481#a6481
//but changes value in same  object 
package com.kas.dsasupreme._7_DivideAndConquer;

import java.util.Arrays;

class _1_DncL1MergeSortLC912 {
	static void merge(int[] ip,int s,int mid,int e){ 
		//need to create 2 copied array for left and right part
		int len1 = mid-s+1; //1-0+1 = 2 len
		int len2 = e-mid; //3-1 = 2len so, total 4len divided in 2 and 2 both side
		
		int[] left = new int[len1];
		int[] right = new int[len2];
		
		//copy value in l and r array from main array
		int rindex =0;
		int lindex =0;
		for(int i = s;i<=e;i++){
			if(i <= mid)
				left[lindex++] = ip[i];
			else
			{
				right[rindex++] = ip[i];
			}
		}
		
		//sort array while merge both array in main array
		int li = 0;
		int ri = 0;
		int mainIndex = s;
		
		while(li < len1 && ri < len2)
		{
			if(left[li] < right[ri]){
				ip[mainIndex++] = left[li++];
			}
			else{
				ip[mainIndex++] = right[ri++];
			}
		}
		
		//put remaining element of both array in mainarray
		
			while(li<len1){
				ip[mainIndex++] = left[li++];
			}
			
			while(ri < len2){
				ip[mainIndex++] = right[ri++];
			}
	} 
    public static void mergeSort(int[] ip, int s, int e) {
       
    	//base case
    	if(s >= e)
    		return;
    	
    	int mid = s +(e-s)/2;
    	
    	//left array sort
    	mergeSort(ip,s,mid);
    	
    	//right array sort
    	mergeSort(ip, mid+1, e);
    	
    	//merge both array
    	merge(ip,s,mid,e);
    	
    		
    }
    public static boolean repeatedSubstringPattern(String str) {
    	int l = str.length();
    	for(int i=l/2;i>=1;i--) {
    		if(l%i==0) {
    			int m = l/i;
    			String subS = str.substring(0,i);
    			StringBuilder sb = new StringBuilder();
    			for(int j=0;j<m;j++) {
    				sb.append(subS);
    			}
    			if(sb.toString().equals(str)) return true;
    		}
    	}
    	return false;
    }
    public static void main(String[] args) {
		int[] ip = new int[]{5,3,2,1};
    	mergeSort(ip,0,ip.length-1);
		System.out.println(Arrays.toString(ip));
		String str = "abcabcabcabc";
		System.out.println(repeatedSubstringPattern(str));
	}
}