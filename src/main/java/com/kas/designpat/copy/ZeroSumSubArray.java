package com.kas.designpat.copy;

import java.util.Arrays;
import java.util.HashSet;

public class ZeroSumSubArray {/*
								 * // Utility function to insert <key, value>
								 * into the multimap private static<K, V> void
								 * insert(Map<K, List<V>> hashMap, K key, V
								 * value) { // if the key is seen for the first
								 * time, initialize the list
								 * hashMap.putIfAbsent(key, new ArrayList<>());
								 * hashMap.get(key).add(value); }
								 * 
								 * // Function to print all subarrays with a
								 * zero-sum in a given array public static void
								 * printAllSubarrays(int[] nums) { // create an
								 * empty multimap to store the ending index of
								 * all // subarrays having the same sum
								 * Map<Integer, List<Integer>> hashMap = new
								 * HashMap<>();
								 * 
								 * // insert (0, -1) pair into the map to handle
								 * the case when // subarray with zero-sum
								 * starts from index 0 insert(hashMap, 0, -1);
								 * 
								 * int sum = 0;
								 * 
								 * // traverse the given array for (int i = 0; i
								 * < nums.length; i++) { // sum of elements so
								 * far sum += nums[i];
								 * 
								 * // if the sum is seen before, there exists at
								 * least one // subarray with zero-sum if
								 * (hashMap.containsKey(sum)) { List<Integer>
								 * list = hashMap.get(sum);
								 * 
								 * // find all subarrays with the same sum for
								 * (Integer value: list) {
								 * System.out.println("Subarray [" + (value + 1)
								 * + "�" + i + "]"); } }
								 * 
								 * // insert (sum so far, current index) pair
								 * into the multimap insert(hashMap, sum, i); }
								 * }
								 */
	static int sol() {
		int[] A = { 1 };
		int[] B = { 1 };
		int n = A.length;
		int m = B.length;

		Arrays.sort(A);
		Arrays.sort(B);
		//int i = 0;
		
		 int i = 0;
         int j = 0;
         
       /*  while (i < A.length && j < B.length) {
             if (A[i] == B[j]) {
                 return A[i];
             } else if (A[i] < B[j]) {
                 i++;
             } else {
                 j++;
             }
         }*/
         
		/*for (int k = 0; k < n ;) {
			if (A[k] == B[i])
				return A[k];
			if (i < m  && B[i] < A[k])
				i += 1;
			else
				k += 1;
			
		}*/
       
         HashSet<Integer> mapA = new HashSet<Integer>();
         for(int v:A)
         mapA.add(v);
         
         int minimum = Integer.MAX_VALUE;
         for(int val : B) {
             if (mapA.contains(val) && val < minimum) {
                 minimum = val;
             }
         }
         
         if (minimum == Integer.MAX_VALUE) {
             minimum = -1;
         }
         
         return minimum;
     
	}


	public static void main(String[] args) {

		System.out.println(sol());
		// int[] nums = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };

		// printAllSubarrays(nums);
	}

}