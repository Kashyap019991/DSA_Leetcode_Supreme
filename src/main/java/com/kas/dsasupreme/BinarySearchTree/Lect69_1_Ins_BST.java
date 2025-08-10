package com.kas.dsasupreme.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;



/*public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.right = right;
		this.left = left;
	}
}*/

public class Lect69_1_Ins_BST {

	static TreeNode insertInBst(TreeNode node,int data){
		if(node == null){
			node = new TreeNode(data, null, null);
			return node;
		}
		
		if(data  < node.val){
			node.left = insertInBst(node.left, data);
		}
		if(data > node.val){
			node.right = insertInBst(node.right, data);;
		}
		return node;
		
	}
	// 1. builde tree
	static TreeNode createBst(int[] element){
		
		TreeNode root = null;
		
		for(int i = 0; i<element.length; i++){
		root = insertInBst(root,element[i]);
		}
		return root;
		
	}
	public static void main(String[] args) {
		int[] element = new int[]{4,2,7,1,3};
		//TreeNode[] 
		/*for(int i =0; i<element.length;i++){
			
		}*/
		TreeNode root = createBst(element);
		//levelOrderTra(root);
		//LeetCode 701
		TreeNode root1 = insertInBst(root, 5);
		levelOrderTra(root1);
	}	
	static void levelOrderTra(TreeNode root){
		//1 3 7
		TreeNode temp = null;
		Queue<TreeNode> q =new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			temp=q.peek();
			q.poll();
			System.out.print(" "+temp.val);
			if(temp.left != null)
			q.add(temp.left);
			if(temp.right != null)
			q.add(temp.right);
		}
	}
}