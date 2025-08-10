package com.javapr;

import java.util.Stack;

class MyQueue {
	//class MyQueue {
	    Stack<Integer> inStack = new Stack<>();//1,2,3
	    Stack<Integer> outStack = new Stack<>();//3,2,1
	    int front;

	    public MyQueue() {
	        
	    }
	  

	    public void push(int x) {
	        
	       if (inStack.empty())
	        front = x;
	    while (!inStack.isEmpty())
	        outStack.push(inStack.pop());
	    outStack.push(x);
	    while (!outStack.isEmpty())
	        inStack.push(outStack.pop());
	    }
	    
	    public int pop() {
	        int popped = inStack.pop();
	    if (!inStack.empty())
	        front = inStack.peek();
	    return popped;
	    }
	    
	    public int peek() {
	        
	       return front;
	    }
	    void transferElem(){
	        while(!inStack.isEmpty()){
	            int poppedElement = inStack.pop();
	            outStack.push(poppedElement);
	        }
	    }
	    public boolean empty() {
	         return inStack.isEmpty();
	}
	}
	/**
	 * Your MyQueue object will be instantiated and called as such:
	 * MyQueue obj = new MyQueue();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.peek();
	 * boolean param_4 = obj.empty();
	 */
    
    //["MyQueue","push","push","push","push","pop","push","pop","pop","pop","pop"]
    //[],[1],[2],[3],[4],[],[5],[],[],[],[]
    public static void main(String[] args) {
		MyQueue mq = new MyQueue();
		mq.push(1);
		mq.push(2);
		mq.push(3);
		mq.push(4);
		
		mq.pop();
		mq.push(5);
		
		mq.pop();
		mq.pop();
		mq.pop();
		mq.pop();
	}
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */