package com.kas.practice_javadsa;
class findMedianSorted {
	
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        //both are sorted

	        //f pointer to first array
	        //s pointrt to second array

	        //iterate until any of aarray reach deadlin.
	        int k=0,n11=nums1.length,n22=nums2.length;
	        int[] ans = new int[n11+n22];
	        //for(int n1=0,n2=0;n1<nums1.length || n2<nums2.length;n1++,n2++)
	        int n1 = 0,n2=0;
	        while(n1 < nums1.length && n2 <nums2.length)
	        {
	            if(nums1[n1]>nums2[n2]){
	                
	                ans[k++] = nums2[n2];
	                n2++;

	            }
	            else if(nums1[n1]<=nums2[n2]){
	                ans[k++] = nums1[n1];
	                n1++;
	            }
	        }
	        while(n1<nums1.length)
	        {
	        	ans[k++] = nums1[n1++];
	        }
	        while(n2<nums2.length)
	        {
	        	ans[k++] = nums2[n2++];
	        }
	        double fans =0;
	        if(k %2==0){
	            fans = (ans[k/2] + ans[(k/2)-1])/2.0;
	        } 
	        if(k%2 != 0)  fans = ans[k/2];
			/* if(k-1 % 2 !=0) fans = (double)ans[(k-1)/2]; */

	        return fans;
	    }
	public static void main(String[] args) {
    	int[] nums1 = {0,0}, nums2 = {0,0};
    	findMedianSorted s = new findMedianSorted();
    	System.out.println(s.findMedianSortedArrays(nums1, nums2));
	}
}