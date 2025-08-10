package com.kas.dsasupreme.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Day140__8_FractionalKnapsac_gfg {
	static double fractionalKnapsack(int W, Item arr[], int n) {
		ArrayList<Object[]> ls = new ArrayList<>();
		// 1st long val --> val/wt & 2nd Item
		for (int i = 0; i < n; i++) {
			double valPerWt =(double) ((arr[i].getValue()*1.0)/(arr[i].getWeight()*1.0));
			ls.add(new Object[]{valPerWt, arr[i]});
		}
		
		Collections.sort(ls, new Comparator<Object[]>() {
			@Override
			public int compare(Object[] o1, Object[] o2) {
				return ((Double) o2[0]).compareTo((Double) o1[0]);
			}
		});
		double totalValue = 0;
		for(int i =0 ;i<n;i++){
			if((int) ((Item) ls.get(i)[1]).getWeight() < W){
				totalValue = totalValue + (int)((Item)ls.get(i)[1]).getValue();
				W = W - (int) ((Item) ls.get(i)[1]).getWeight();
			}
			else
			{
				totalValue = totalValue + (W * (double)ls.get(i)[0]);
				W = 0;
			}
		}
		return totalValue;
	}

	public static void main(String[] args) {

		int W = 50;
		int n = 3;// no. of char in string
		int[] values = new int[] { 60, 100, 120 };
		int[] weight = new int[] { 10, 20, 30 };
		Item[] arr = new Item[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Item(values[i], weight[i]);
		}
		System.out.println(fractionalKnapsack(W, arr, n));
	}
}

class Item {
	int value, weight;

	public int getValue() {
		return value;
	}

	public int getWeight() {
		return weight;
	}

	Item(int x, int y) {
		this.value = x;
		this.weight = y;
	}
	
}
