package com.kas.dsasupreme.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;


class infoSum{
	int maxi;
	int mini;
	Boolean isbst;
	int sum;
	
	public infoSum(int maxi, int mini, Boolean isbst, int sum) {
		super();
		this.maxi = maxi;
		this.mini = mini;
		this.isbst = isbst;
		this.sum = sum;
	}
	
	
}
public class Lect73_2_maxSumBst {
	static int ans = 0; // use global var instead of static in leet code

	static infoSum largestBst(TreeNode root) {

		if(root == null){
			return new infoSum(Integer.MIN_VALUE, 
							Integer.MAX_VALUE,
							true, 0);
		}
		
		infoSum left = largestBst(root.left);
		infoSum right = largestBst(root.right);
		
		infoSum curr = new infoSum(0, 0, false, 0);
		curr.sum = left.sum + right.sum + root.val;
		curr.maxi = Math.max(root.val, right.maxi);
		curr.mini = Math.min(root.val, left.mini);
		
		if(left.isbst && right.isbst && (left.maxi < root.val) &&
										(root.val < right.mini)){
			curr.isbst = true;
		}
		else
		{
			curr.isbst = false;
		}
		
		//ans update
		if(curr.isbst){
			ans = Math.max(ans, curr.sum);
		}
		return curr;
	}

	public static void main(String[] args) {

		int[] element1 = new int[] { 5,2,1,-1,-1,3,-1,-1,4,-1,-1 };
		TreeNode root11 = createBinaryt(element1);

		largestBst(root11);

		System.out.println(ans);
	}

	static void levelOrderTra(TreeNode root) {
		// 1 3 7
		TreeNode temp = null;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			temp = q.peek();
			q.poll();
			System.out.print(" " + temp.val);
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
	}
static int i = 0;
static TreeNode insertInBint(TreeNode root, int[] element){
	// 5,2,1,-1,-1,3,-1,-1,4,-1,-1 	
		//Scanner sc = new Scanner(System.in);
		//System.out.println("Enter data:");

	if(i == element.length){
		return root;
	}
	int data =element[i];
	i++;
		
		root = new TreeNode(data);
		if(data==-1)return null;
		//1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
		System.out.println("Enter left of data: "+data);
		root.left = insertInBint(root.left,element);
		System.out.println("Enter right of data: "+data);
		root.right = insertInBint(root.right,element);
		
		return root;
	}

	// 1. builde tree
	static TreeNode createBinaryt(int[] element) {

		TreeNode root = null;

		//for (int i = 0; i < element.length; i++) {
			root = insertInBint(root,element);
		//}
		return root;

	}
}