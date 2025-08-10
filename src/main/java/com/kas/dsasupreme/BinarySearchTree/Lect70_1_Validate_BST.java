package com.kas.dsasupreme.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class Lect70_1_Validate_BST {

	static Boolean validateInBst(TreeNode root, double min, double max) {
		if (root == null)
			return true;

		if (root.val > min && root.val < max) {

			Boolean left = validateInBst(root.left, min, root.val);
			Boolean right = validateInBst(root.right, root.val, max);
			return left && right;

		} else
			return false;

	}

	public static void main(String[] args) {
		int[] element = new int[] { 2,1,3 };
		TreeNode root = createBst(element);
		//here integer.max_val not work for last no. of int
		Boolean ans = validateInBst(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
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