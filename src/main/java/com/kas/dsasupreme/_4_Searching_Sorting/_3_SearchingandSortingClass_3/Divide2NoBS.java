package com.kas.dsasupreme._4_Searching_Sorting._3_SearchingandSortingClass_3;
//29. Divide Two Integers https://leetcode.com/problems/divide-two-integers/description/
public class Divide2NoBS {

	static int divide2no(int divident, int divisor) {

		long s = 0;
		long e = Math.abs((long)divident);
		long mid = 0; // quotient
		long target = Math.abs((long)divident);
		int ans = 0;
		//(-2147483648, -2147483648)
		if(Math.abs((long)divident) == Math.abs((long)divisor)) return (divisor > 0 && divident > 0) || (divisor < 0 && divident < 0) ? 1 : -1;
		
		if(Math.abs((long)divident) < Math.abs((long)divisor)) return 0; //-1010369383   -2147483648
		// Handle overflow case
		if((divident == Integer.MIN_VALUE && divisor == -1) 
		           || (divident == Integer.MAX_VALUE && divisor == 1)){
		            return Integer.MAX_VALUE;
		        }
		if((divident == Integer.MIN_VALUE && divisor == 1) 
		          ){
		            return Integer.MIN_VALUE;
		        }
		//2147483647, -1
		if( (divident == Integer.MAX_VALUE && divisor == -1)) return (divisor > 0 && divident > 0) || (divisor < 0 && divident < 0) ? Integer.MAX_VALUE : -Integer.MAX_VALUE;

		while (s <= e) {
			System.out.println("s: " +s +" e: " +e +"mid:" +mid);
			mid = s + (e - s) / 2;

			//if(s == Integer.MIN_VALUE || e == Integer.MAX_VALUE) return (int)(mid);
			if (target == mid * Math.abs(divisor))
				return (divisor > 0 && divident > 0) || (divisor < 0 && divident < 0) ? (int)(mid) : -(int)(mid);
			else if (target < mid * Math.abs(divisor))// left
				e = mid - 1;
			else // target > mid * divisor // mid can be ans so store it & move
					// to right
			{
				s = mid + 1;
				ans = (int)mid;
			}

		}
		return ((divisor > 0 && divident > 0) || (divisor < 0 && divident < 0)) ?  ans: -ans;
	}

	public static void main(String[] args) {
		System.out.println(divide2no(2147483647, -1));
	}
}
