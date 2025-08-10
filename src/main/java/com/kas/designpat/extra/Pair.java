package com.kas.designpat.extra;

public class Pair<T1, T2> {
		int i1;
		int j;
		
		Pair(int i1,int j){this.i1 = i1; this.j = j;}
		
		int getKey() {
			return i1;
		}
		int getValue() {
			return j;
		}
}
