package com.kas.dsasupreme.BinarySearchTree;

import java.util.Collections;
import java.util.PriorityQueue;

import com.kas.Tree.TreeDay1;
import com.kas.Tree.TreeNode;

public class Lect77_3__MedianInStream {

	static double median = 0;
	
	
	static void callMedian(PriorityQueue<Integer> maxH,PriorityQueue<Integer> minH, int element){
	
		if(maxH.size() > minH.size()) //left n , right n-1
		{
			if(element > median)//right side ma add thvo joie
			{
				minH.add(element);//after add 1 in n-1 (right) == n ==left
				median = (maxH.peek() + minH.peek()) /2.0;
			}
			else //leftside ma
			{//n _ +1 left--> n-1 right --> 2 diff not acceptable
				//1st remove 1 elem from left and add to right 
				minH.add(maxH.poll());
				//now n-1 --> n , so, add 1 elem to left
				maxH.add(element);
				//now both side n --> n
				median = (maxH.peek() + minH.peek()) /2.0;
			}
			
		}
		else if(minH.size() > maxH.size())//left n-1 , right n
		{
			if(element > median) //right side add kro
			{
				maxH.add(minH.poll());
				//now n --> n-1 , so, add 1 elem to right
				minH.add(element);
				//now both side n --> n
				median = (maxH.peek() + minH.peek()) /2.0;
			}
			else //left side
			{
				maxH.add(element);
				median = (maxH.peek() + minH.peek()) /2.0;
			}
		}
		else //both equal left n --> n right
		{
			if(element > median) //right side add kro
			{
				minH.add(element); 
				//now  n --> n+1
				if(!minH.isEmpty())
				median = minH.peek();
			}
			else //left side
			{
				maxH.add(element);
				if(!maxH.isEmpty())
				median = maxH.peek();
			}
		}
	}
	public static void main(String[] args) {
		
		PriorityQueue<Integer> minH = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxH = new PriorityQueue<Integer>(Collections.reverseOrder());
		 int A[] = { -1,-2,-3,-4,-5 };
	        int N = A.length;
	         
	        // Function call
	        for(int i=0;i<N;i++){
	        	callMedian(maxH, minH, A[i]);
	        }
	        System.out.println("========================");
	        System.out.println(median);
	}

}