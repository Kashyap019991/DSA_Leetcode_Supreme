package com.kas.dsasupreme.extra_classes;

import java.util.*;

public class prdofarr {
	static int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		for(int i=0;i<nums.length;i++){
			int pr=1;
			for(int j=0;j<nums.length;j++){
				if(i==j)continue;
				pr= pr*nums[j];
			}
			res[i]=pr;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] a = new int[]{-1,1,0,-3,3};//{1,2,3,4};
		int[] rs =productExceptSelf(a);
		System.out.println(Arrays.toString(rs));
	}
	
}