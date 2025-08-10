package com.kas.dsasupreme.extra_classes;

/***
 * 
 * @author Krishna
 *Input: prices = [7,1,5,3,6,4]
Output: 5

Input: prices = [7,6,4,3,1]
Output: 0
 */
public class BuySellStock {

	static int buySellStockPrices(int[] prices){
		int res = 0,diff;
		
		for(int i=0;i<prices.length;i++){
			for(int j=i+1;j<prices.length;j++){
				diff = prices[j] - prices[i];
				if(diff>res){
					res = diff;
				}
			}
		}
		return res;	
	}
	
	public static void main(String[] args) {
		//int[] prices = new int[]{7,1,5,3,6,4};
		int[] prices = new int[]{7,6,4,3,1};
		int price = buySellStockPrices(prices);
		System.out.println(price);
	}
}
