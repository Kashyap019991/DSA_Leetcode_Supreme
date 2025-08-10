package com.kas.dsasupreme.extra_classes;

import java.util.HashMap;
import java.util.Map;

/***
 * 
 * @author Krishna Input: prices = [7,1,5,3,6,4] Output: 5
 * 
 *         Input: prices = [7,6,4,3,1] Output: 0
 */
public class BuySellStockopt {

	static int buySell(int[] a){
		
		int buyMin=Integer.MAX_VALUE,profit=0;
		for(int i=0;i<a.length;i++){
		
			if(a[i]<buyMin)buyMin=a[i];
			int curProfit =a[i]-buyMin;
			if(curProfit>profit)profit=curProfit;
			
		}
		return profit;
	}
	public static void main(String[] args) {
		int[] a =new int[]{7,6,4,3,1};
		int maxP = buySell(a);
		System.out.println(maxP);
	}
}
