package com.kas.dsasupreme._9_Stack;

import java.util.ArrayList;
import java.util.List;

class Pair{
	int a;//curr
	int b;//min
	Pair(){}
	Pair(int a,int b){
		this.a = a;
		this.b = b;
	}
}
class _Class3_1_MinStackLC_155 {
	List<Pair> list;
	public _Class3_1_MinStackLC_155() {
		list = new ArrayList<>();
	}

	public void push(int val) {
		if(list.isEmpty()){
			Pair p = new Pair(val,val);
			list.add(p);
		}
		else{
			Pair p  = new Pair();
			p.a = val;
			p.b = Math.min(list.get(list.size()-1).b, val);
			list.add(p);
		}
	}

	public void pop() {
		list.remove(list.size()-1);
	}

	public int top() {
		return list.get(list.size()-1).a;
	}

	public int getMin() {
		return list.get(list.size()-1).b;
	}

	public static void main(String[] args) {
		_Class3_1_MinStackLC_155 minStack = new _Class3_1_MinStackLC_155();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin()); // return -3
		minStack.pop();
		System.out.println(minStack.top()); // return 0
		System.out.println(minStack.getMin());// return -2
	}
}