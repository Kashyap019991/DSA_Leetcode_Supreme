package com.kas.practice_javadsa;
class medianOfTwoArr {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArr = new int[nums1.length + nums2.length];
        int i=0, j=0,k=0;
        int len =nums1.length + nums2.length;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]){
                mergedArr[k] = nums1[i];
                i++;k++;
            }
            else if(nums2[j] < nums1[i]){
                mergedArr[k] = nums2[j];
                j++;k++;
                
            }
            else{
                mergedArr[k++] = nums2[j];
                mergedArr[k++] = nums2[j];
                i++;j++;
            }
        }
        
        
        while(i<nums1.length){
            mergedArr[k]= nums1[i];
            k++;i++;
        }
        while(j<nums2.length){
            mergedArr[k] = nums2[j];
            k++;j++;
        }
       double median=0; 
     if(len %2!=0){
         median = mergedArr[len/2];
     }   
        else{
            median = (Double.valueOf(mergedArr[len/2])+Double.valueOf(mergedArr[(len/2)-1]))/Double.valueOf(2);
        }
        
        return median;
    }
    //1,1,1,1,1,1,1,1,1,1, 1,  3,4,4,4,4,4,4,4,4,4,4,4
    //1,2,3,4,5,6,7,8,9,10,11,   
    public static void main(String[] args) {
		int[] nums1 = {1,1,1,1,1,1,1,1,1,1,4,4};
		int[] nums2 = {1,3,4,4,4,4,4,4,4,4,4};
		medianOfTwoArr sl = new medianOfTwoArr();
		System.out.println(sl.findMedianSortedArrays(nums1,nums2));
	}
}