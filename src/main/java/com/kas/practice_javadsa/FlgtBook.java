package com.kas.practice_javadsa;

import java.util.Arrays;

public class FlgtBook {
	  public int[] corpFlightBookings(int[][] bookings, int n) {
	        int[] res = new int[n];
	        for (int[] b : bookings) {
	            res[b[0] - 1] += b[2];
	            if (b[1] < n) res[b[1]] -= b[2];
	        }
	        for (int i = 1; i < n; ++i)
	            res[i] += res[i - 1];
	        return res;
	    }
	  
	  public static void main(String[] args) {
		int[][] bookings= {{1,2,10},{2,3,20},{2,5,25}};
		FlgtBook sl = new FlgtBook();
		System.out.println(Arrays.toString(sl.corpFlightBookings(bookings, 5)));
	}
}
