package com.kas.dsasupreme.BinarySearch;
class SearchInRotatedSortedArr {

    static int findPivotElement(int[] arr){
        int s =0;
        int e = arr.length -1;
        int mid = s+(e-s)/2;

        while(s <e){
            if(mid+1 <= arr.length-1 && arr[mid] > arr[mid+1])//mid - pivot hai
                return mid;
            if(mid+1 <= arr.length-1  && arr[mid-1] > arr[mid]) // mid-1 - pivot hai
                return mid-1;
            if(arr[s] > arr[mid])//left side move kro
                e = mid-1;
            else //arr[s]  < arr[mid] //right side move kro
                s = mid+1;

            mid = s+(e-s)/2;

        }
        return s;
    }
    static int binarySearch(int[] nums,int target,int s, int e){
        int mid = s +(e-s) /2;
        while(s <=e)
        {
            if(target == nums[mid])
                return mid;
            else if(target < nums[mid])//left side
                e =mid-1;
            else //target > nums[mid] //right side
                s = mid+1;

            mid = s + (e-s) /2;
        }
        return -1;
    }
    static int search(int[] nums, int target) {
        //find pivot element
        int pivotIndex = findPivotElement(nums);
        System.out.println(pivotIndex);
        if(target >= nums[0] && target <= nums[pivotIndex]) //leftside of sorted array
        {
            System.out.println("left side");
            int ans = binarySearch(nums,target,0,pivotIndex);
            return ans;
        }
        if(target <= nums[nums.length -1] && pivotIndex+1 <= nums.length-1 && target >= nums[pivotIndex+1]) //right side of sorted array
        {
            System.out.println("right side");
            int ans = binarySearch(nums,target,pivotIndex+1,nums.length-1);
            return ans;
        }
        return -1;
    }
    public static void main(String[] args) {
		int[] nums ={4,5,6,7,0,1,2};
		int target = 0;
		System.out.println("target index: "+search(nums,target));
		
	}
}