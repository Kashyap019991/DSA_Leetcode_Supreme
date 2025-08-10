package com.kas.dsasupreme._4_Searching_Sorting._3_SearchingandSortingClass_3;

import java.util.Arrays;

class HW6_MagneticForceBetweenTwoBalls_LC1552 {

	static boolean isPossiblePlaceBall(int[] position , int balls, int magForce){
        int placedBalls =1;
        int placedAt = 0;

        for(int i = 1; i< position.length; i++){
            if(position[i] - position[placedAt] >= magForce){
                placedAt = i; //place balls at pos i
                ++placedBalls;
            }
            if(placedBalls == balls)
                return true;
        }
        return false;
    }
    static int maxDistance(int[] position, int m) {
        Arrays.sort(position); //sort data to apply binary search
        int lenArr = position.length;
        int s =1;
        int e = position[lenArr-1] - position[0]/(m-1);
        int mid = s + (e-s) /2;
        int ans = 0;
        while(s <= e){

            if(isPossiblePlaceBall(position , m , mid)){

                ans = mid;
                s =mid+1; //maximize mid
            }
            else{
                e = mid-1;
            }
            mid = s +(e-s)/2;
        }
        return ans;
    }
	    public static void main(String[] args) {
			int ans = maxDistance(new int[]{1,2,3,4,7}, 3);
			System.out.println(ans);
		}
	
}