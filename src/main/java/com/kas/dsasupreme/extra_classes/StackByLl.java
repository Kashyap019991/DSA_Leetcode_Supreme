package com.kas.dsasupreme.extra_classes;

class StackUsingLL {
	class Node {
		int data;
		Node link;
	}
Node top =null;
	public void push(int n) {
		Node temp = new Node();
		temp.data = n;
		//temp.link = null;
		//temp.link = top;
		//top = temp;
		/*if(top == null)
		{
			top = temp;
			return;
		}*/
		//top //20-null
		//temp//21-null
		//top//21-20
		temp.link = top;
		top = temp;
		
		
	}
	public void display(){
		//20-21-30
		//temp//20
		
		Node temp = new Node();
		temp = top;
		
		while(temp!=null)
		{	
		System.out.print(temp.data +"->");
		temp =temp.link;
		}
	}
	
	public void pop(){
		//30-21-20
		Node temp= null;
		
		
		temp=top.link;
		top.data = temp.data;
		top.link = temp.link;
	}
}

public class StackByLl {
	public static void main(String[] args) {
		StackUsingLL stc = new StackUsingLL();
		stc.push(20);
		stc.push(21);
		stc.push(30);
		stc.display();
		stc.pop();
		System.out.println();
		//stc.pop();
		//stc.peek();
		stc.display();
	}
}