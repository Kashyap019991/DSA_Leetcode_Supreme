package com.kas.dsasupreme._4_Searching_Sorting._3_SearchingandSortingClass_3;
class HW3_ExponentialBSLC704 {
    static int binarySearch(int[] nums, int s, int e, int target){
        int mid = s + (e-s)/2;
        while(s <= e){
            if(nums[mid] == target)
                return mid;
            else if(target < nums[mid])
                e = mid-1;
            else 
                s=mid+1;

            mid = s +(e-s)/2;
        }

        return -1;
    }
    public int search(int[] nums, int target) {
        //exponential search
        int i =1;
        int j=0;
        if(nums[0] == target) 
            return 0;
        while(i < nums.length && nums[i] <= target){
            j = i;
            i = i*2;
        }//got range i & j
        //apply b.s
        if(i >= nums.length) i = nums.length -1;
        int index = binarySearch(nums, j, i, target);
        return index;
    }
}