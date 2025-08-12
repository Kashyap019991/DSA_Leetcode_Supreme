package com.kas.practice_javadsa.aug_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//compile class ctrl+shift+f9
class LC_15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList();
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-3;i++){
 if (i == 0 || nums[i] != nums[i - 1]) {
            int left =i+1;
            int right = nums.length-1;

            while(left < right){
                
                if(nums[i] == -(nums[left]+nums[right])){
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);

                    triplets.add(triplet);

                    while (left < nums.length - 1 && nums[left] == nums[left + 1]) left++;
                    while (right > 0 && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                    //TODO: remove dplicate
                }
                else if(-nums[i] > nums[left]+nums[right]){
                    left++;
                }
                else
                    right--;
            }
        }
        }
        return triplets;
    }

    public static void main(String[] args) {
        int[] nums= {-1,0,1,2,-1,-4};
        LC_15_3Sum three_sum = new LC_15_3Sum();
        System.out.println(three_sum.threeSum(nums));
    }
}