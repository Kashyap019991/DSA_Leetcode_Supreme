package com.kas.dsasupreme.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
//1. create ino of both
//2.  merge both arr
//3. create tree from merge array

public class Lect72_1_BstFromPreOrder {
	static int i =0; // use global var instead of static in leet code
	static TreeNode bstFromPreorder(int[] preorder,double min, double max) {
	
		if(i == preorder.length) return null;
		if(preorder[i] < min || preorder[i] > max) return null;
		
		TreeNode root = new TreeNode(preorder[i++]);
	
		root.left = bstFromPreorder(preorder, min, root.val);
		root.right = bstFromPreorder(preorder, root.val, max);
		return root;
	}

	public static void main(String[] args) {
		
		int[] preorder = new int[] { 8,5,1,7,10,12};

		
		// here integer.max_val not work for last no. of int
		TreeNode res = bstFromPreorder(preorder,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
				
		levelOrderTra(res);

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

	static TreeNode insertInBst(TreeNode node, int data) {
		if (node == null) {
			node = new TreeNode(data, null, null);
			return node;
		}

		if (data < node.val) {
			node.left = insertInBst(node.left, data);
		}
		if (data > node.val) {
			node.right = insertInBst(node.right, data);
			;
		}
		return node;

	}

	// 1. builde tree
	static TreeNode createBst(int[] element) {

		TreeNode root = null;

		for (int i = 0; i < element.length; i++) {
			root = insertInBst(root, element[i]);
		}
		return root;

	}
}