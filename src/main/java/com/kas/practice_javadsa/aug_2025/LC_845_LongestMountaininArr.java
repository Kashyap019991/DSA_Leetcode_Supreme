package com.kas.practice_javadsa.aug_2025;

class LC_845_LongestMountaininArr {
    public int longestMountain(int[] arr) {
        int longestPeak=0;
        //find peak and got down both side and count
        for(int i=1;i<= arr.length-2;i++){

            //find peak
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                    //go to left side down and count element

                    int j=i, count=1;
                    while(j>=1 && arr[j] > arr[j-1]){
                        j--;
                        count++;
                    }
                    j=i;
                    //got to right side down
                    while(j <= arr.length-2 && arr[j] >arr[j+1]){
                        j++;
                        count++;
                    }
                    longestPeak = Math.max(longestPeak,count);

            }
           
        }
         return longestPeak;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,7,3,2,5};
        System.out.println(new LC_845_LongestMountaininArr().longestMountain(arr) );
    }
}