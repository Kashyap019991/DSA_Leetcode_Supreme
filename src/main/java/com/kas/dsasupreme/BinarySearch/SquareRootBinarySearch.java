package com.kas.dsasupreme.BinarySearch;
class SquareRootBinarySearch {
    public int mySqrt(int target) {
        int s =1;
        int e = target;
        int mid = s + (e-s) /2;
        int ans =0;
        while(s <= e){
            if(mid == target/mid) //
                return mid;
            else if(target/mid > mid) //target >  mid *mid fasega bde no. mai
            { 
                //right side
                s = mid+1;
                ans = mid; 
                // store ans bcoz  mid =2 then 8>2*2 & 8 < 3*3
            }
            else // target < mid *mid //left side
            {
                e =mid-1;
            }
            mid = s + (e-s) /2;
        }
        return ans;
    }
}