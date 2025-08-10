package com.kas.dsasupreme.BinarySearch;
class FindFirstAndLastOccurSortedArr {
    static int firstOcc(int[] nums, int target){
        int s = 0;
        int e = nums.length -1;
        int mid = s + (e-s) /2;
        int ans = -1;
        while(s <= e){
            if(nums[mid] == target){
                ans = mid;
                e =mid-1;//left move kro first occurance ke liye
            }
            else if(target < nums[mid])
                e = mid-1;//left side
            else //target > nums[mid]  //right side
                s = mid+1;
            
            mid =s+(e-s) /2;

        }
        return ans;
    }
        static int lastOcc(int[] nums, int target){
        int s = 0;
        int e = nums.length -1;
        int mid = s + (e-s) /2;
        int ans = -1;
        while(s <= e){
            if(nums[mid] == target){
                ans = mid;
                s =mid+1;//left move kro first occurance ke liye
            }
            else if(target < nums[mid])
                e = mid-1;//left side
            else //target > nums[mid]  //right side
                s = mid+1;
            
            mid =s+(e-s) /2;

        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int firstOccur = firstOcc(nums,target);
        int lastOccur = lastOcc(nums,target);
        return new int[]{firstOccur,lastOccur};
    }
      public int[] searchRange12(int[] nums, int target) {
        int[] out=new int[2];
        int j=0;

        for(int i=0;i<nums.length;i++)
            if(nums[i]==target){
                 if(j==0)
                    out[0]=out[1]=i;
                else
                    out[1]=Math.max(out[1], i);
                j++;
            }
               
                   
        return j<1? new int[]{-1,-1}:out;

    }
  
}