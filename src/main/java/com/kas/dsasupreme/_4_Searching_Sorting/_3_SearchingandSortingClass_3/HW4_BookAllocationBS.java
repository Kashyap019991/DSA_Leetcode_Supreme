package com.kas.dsasupreme._4_Searching_Sorting._3_SearchingandSortingClass_3;
class HW4_BookAllocationBS {
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
    static boolean isPossible(int[] arr, int n,int m,int mid) {
        
    	if(n < m) 
            return false;
    	int pgSum =0;
    	int countStudent =1;
    	for(int i =0 ; i<n;i++){
    		if(pgSum + arr[i] <= mid)//then its possible to add curr arr[i]
    		{
    			pgSum += arr[i];
    		}
    		else //pgSum > mid means allocate to new student
    		{
    			countStudent++; //incr studentcount
    			if(countStudent > m || arr[i] > mid)//agar student nhi bche to stop  || check kro currpg is < mid
    			{//1,2,3,4,5,6,7,8,9,10
    				return false;
    			}
    			pgSum = 0;
    			pgSum += arr[i]; //start page allocation from curr page count
    		}
    	}
    	
    	return true;
    }
    public static void main(String[] args) {
    	
        int m=5; // no of Students
        int[] bookPage = new int[]{1,2,3,4,5,6,7,8,9,10};
        		//{12,34,67,90}; //2
        int n =bookPage.length; // no. of Books
        int start =0 ;
        int end =0;
        //find end
        for(int i:bookPage)
        {
        	end += i;
        }
        int ans =0;
        int mid = 0;
        while(start <= end){
        	mid = start + (end - start)/2;
        	
        	if(isPossible(bookPage,n,m,mid)){
        		ans =mid;
        		end =mid-1; //bcoz we want minimum mid so, decrease mid
        	}
        	else
        			start = mid + 1;// page alloc not possible , so, increase mid
        }
        System.out.println(ans);
	}
}