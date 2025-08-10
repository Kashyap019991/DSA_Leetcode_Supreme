package com.kas.dsasupreme.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class Lect70_3_Predecessor_BST {
	static TreeNode res;
	static TreeNode pred;
	// findNode()
	static TreeNode inorderPrdecInBst(TreeNode root, int data) {

		if (root == null)
			return pred;
		// find node
		if (root.val == data) {
			if (root.left != null) {
				TreeNode temp = root.left;
				// max val in left sub tree
				while (temp != null) {
					pred = temp;
					temp = temp.right;
				}
				return pred;
			}
		} else if (root.val > data) {
			// left part
			root = inorderPrdecInBst(root.left, data);
			//return root;
		} else {
			// right part
			pred =root;
			root = inorderPrdecInBst(root.right, data);
			//return root;
		}
		return pred;

	}

	public static void main(String[] args) {
		int[] element = new int[] { 15, 10, 20, 8, 12, 16, 25 };
		TreeNode root = createBst(element);
		// here integer.max_val not work for last no. of int
		TreeNode res = inorderPrdecInBst(root, 15);
		System.out.println(pred.val);

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