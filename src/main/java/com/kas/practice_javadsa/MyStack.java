package com.kas.practice_javadsa;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> mainQueue;
    Queue<Integer> tempQueue;
    int topElem;
    public MyStack() {
        mainQueue = new LinkedList<Integer>();
        tempQueue = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        mainQueue.add(x);
        //topElem = x;
    }
    
    public int pop() {
        while(mainQueue.size() >1){
            int elem = mainQueue.remove();
            tempQueue.add(elem);
        }

        int removedElem = mainQueue.remove();
        Queue<Integer> temp = mainQueue;
        mainQueue = tempQueue;
        tempQueue = temp;
        
        return removedElem;
    }
    
    public int top() {
        while(mainQueue.size() >1){
            int elem = mainQueue.remove();
            tempQueue.add(elem);
        }

        int topElem = mainQueue.peek();
        Queue<Integer> temp = mainQueue;
        mainQueue = tempQueue;
        tempQueue = temp;

        return topElem;
    }
    
    public boolean empty() {
        return mainQueue.isEmpty();
    }
    
    public static void main(String[] args) {
		//["MyStack","push","push","push","top","pop","top","pop","top","empty","pop","empty"]
    	//[],[1],[2],[3],[],[],[],[],[],[],[],[]
    	
    	MyStack myS = new MyStack();
    	myS.push(1);
    	myS.push(2);
    	myS.push(3);
    	myS.top();
    	myS.pop();
    	myS.top();
    	myS.empty();
    	myS.pop();
    	myS.empty();
	}
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */