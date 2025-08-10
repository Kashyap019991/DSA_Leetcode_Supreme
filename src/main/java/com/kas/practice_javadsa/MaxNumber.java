package com.kas.practice_javadsa;

import java.util.Stack;

class MaxNumber {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {

		// LEFT boundary can start with max of 0 or k-num2.length
		// end or RIGHT boundary ends wid Min(k, num1.length)
		// If I take x from first array then remaining k-x from second array
		// boundary where we can traverse array element for subSeq is
		// start with 0 or k-num2.len
		// e.g. num1=5 and num2=3 and k = 5
		// LEFT boundary 5-3 = 2 RIGHT = 5
		int start = Math.max(0, k - nums2.length);
		int end = Math.min(k, nums1.length);
		int[] result = new int[k];
		int[] tmp = null;
//try all combination in boundary which can result in max  
		for (int i = start; i <= end; i++) {
			// find max subseqences
			int[] sub1 = getMaxSubsequence(nums1, i);
			int[] sub2 = getMaxSubsequence(nums2, k - i);
			// merge array
			tmp = merge(sub1, sub2);
			// store max in result
			if (isGreater(tmp, 0, result, 0)) {
				result = tmp;
			}

		}

		return result;

	}

	int[] merge(int[] num1, int[] num2) {
		int[] res = new int[num1.length + num2.length];
		int l1 = 0, l2 = 0, l3 = 0;
		while (l3 < res.length) {
			res[l3++] = isGreater(num1, l1, num2, l2) ? num1[l1++] : num2[l2++];
		}
		return res;
	}

	boolean isGreater(int[] num1, int l1, int[] num2, int l2) {
		while (l1 < num1.length && l2 < num2.length) {
			if (num1[l1] > num2[l2]) {
				return true;
			} else if (num2[l2] > num1[l1]) {
				return false;
			}
			l1++;
			l2++;
		}

		return l1 != num1.length;

	}

//decreasing Monostack here max odering we can do is numlen-i-1>=remain keeping rest untouched
	public int[] getMaxSubsequence(int[] num, int maxSubArrCnt) {
		Stack<Integer> stack = new Stack<Integer>();
		int remain = maxSubArrCnt;
		for (int i = 0; i < num.length; i++) {
			while (!stack.isEmpty() && stack.peek() < num[i] && num.length - 1 - i >= remain) {
				stack.pop();
				remain++;
			}
			if (remain > 0) {
				stack.push(num[i]);
				remain--;
			}

		}

		int[] maxSubArr = new int[maxSubArrCnt];
		int len = maxSubArr.length - 1;
		while (!stack.isEmpty()) {
			maxSubArr[len--] = stack.pop();
		}

		return maxSubArr;

	}
	
	public static void main(String[] args) {
		int[] nums1 = {3,4,6,5}; int[] nums2 = {9,1,2,5,8,3}; int k = 5;
		
		MaxNumber sl = new MaxNumber();
		System.out.println(sl.maxNumber(nums1, nums2, k));
	}

}