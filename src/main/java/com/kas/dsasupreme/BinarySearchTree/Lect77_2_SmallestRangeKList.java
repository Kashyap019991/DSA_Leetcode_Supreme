package com.kas.dsasupreme.BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.kas.Tree.TreeDay1;
import com.kas.Tree.TreeNode;

/*class Node {
	int data;
	int row;
	int col;

	Node(int data, int row, int col) {
		this.data = data;
		this.row = row;
		this.col = col;
	}
}
*/
public class Lect77_2_SmallestRangeKList {

	static int[] smallestRange(List<List<Integer>> nums) {
		// 1st elem min and 2nd elem max , which covers all element
		int[] ans = new int[2];
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.data - o2.data;
			}
		});
		
		int i=0;
		int maxi =Integer.MIN_VALUE;
		int mini = Integer.MAX_VALUE;
		for(List l:nums){
			if(maxi < (int)l.get(0)){
				maxi = (int)l.get(0);
			}
			if(mini > (int)l.get(0)){
				mini = (int)l.get(0);
			}
			pq.add(new Node((int)l.get(0), i,0));
			i++;
		}
		int start = mini, end = maxi;
		{/**
		
		*nums.add(Arrays.asList(1,10,11));
		nums.add(Arrays.asList(2, 3,20));
		nums.add(Arrays.asList(5,6,12));
		*/
		
			
			
			while(!pq.isEmpty())
			{
				Node topNode = pq.poll();
				
				mini = topNode.data;
				
				if(maxi - mini < end -start)
				{
					start = mini;
					end = maxi;
				}
				
				if(topNode.col  +1< nums.get(topNode.row).size()){
				int next = nums.get(topNode.row).get(topNode.col +1);
					maxi = Math.max(maxi,next);
					pq.add(new Node(next
						,topNode.row,topNode.col+1));
				
				}
				else
					break;
				
			}
		
		}
		
		
		ans[0] = start;
		ans[1] = end;
		
		
		return ans;
	}

	public static void main(String[] args) {

		/**
		 * nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
		 * ans = [20,24]
		 */

		/**
		 * 
		 * [-5,-4,-3,-2,-1],[1,2,3,4,5]]
		 * 
		 * 
		 * [-1,1]
		 */
		
		List nums = new ArrayList<ArrayList<Integer>>();
		// List<List<Integer>> lists = new ArrayList<>();
		nums.add(Arrays.asList(1,10,11));
		nums.add(Arrays.asList(2, 3,20));
		nums.add(Arrays.asList(5,6,12));

		System.out.println(Arrays.toString(smallestRange(nums)));
	}

}