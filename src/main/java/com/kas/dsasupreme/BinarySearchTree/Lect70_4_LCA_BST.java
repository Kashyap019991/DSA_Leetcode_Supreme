package com.kas.dsasupreme.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class Lect70_4_LCA_BST {
	static TreeNode res;
	static TreeNode succ;

	// findNode()
	static TreeNode lcaInBstRec(TreeNode root, int p, int q) {

		if (root == null)
			return root;

		if (root.val < p && root.val < q)// right part
		{
			return lcaInBstRec(root.right, p, q);
		} else if (root.val > p && root.val > q) // left part
		{
			return lcaInBstRec(root.left, p, q);
		}

		return root;

	}
	
	static TreeNode lcaInBstItr(TreeNode root, int p, int q) {

		if (root == null)
			return root;

		while(root != null){
		
		if (root.val < p && root.val < q)// right part
		{
			root =  root.right;
		} else if (root.val > p && root.val > q) // left part
		{
			 root = root.left;
		}
		else
		return root;
		}
		return root;
	}
	public static void main(String[] args) {
		int p = 2, q = 8;
		int[] element = new int[] { 6, 2, 8, 0, 4, 7, 9, 3, 5 };
		TreeNode root = createBst(element);
		// here integer.max_val not work for last no. of int
		TreeNode res = lcaInBstItr(root, p, q);
		System.out.println(res.val);

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