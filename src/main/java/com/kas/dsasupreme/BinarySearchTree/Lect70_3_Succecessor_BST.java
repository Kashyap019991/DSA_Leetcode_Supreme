package com.kas.dsasupreme.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class Lect70_3_Succecessor_BST {
	static TreeNode res;
	static TreeNode succ;
	// findNode()
	static TreeNode inorderPrdecInBst(TreeNode root, int data) {

		if (root == null)
			return succ;
		// find node
		if (root.val == data) {
			if (root.right != null) {
				TreeNode temp = root.right;
				// min val in right sub tree
				while (temp != null) {
					succ = temp;
					temp = temp.left;
				}
				return succ;
			}
		} else if (root.val > data) {
			// left part
			succ =root;
			root = inorderPrdecInBst(root.left, data);
			//return root;
		} else {
			// right part
			root = inorderPrdecInBst(root.right, data);
			//return root;
		}
		return succ;

	}

	public static void main(String[] args) {
		int[] element = new int[] { 15, 10, 20, 8, 12, 16, 25 };
		TreeNode root = createBst(element);
		// here integer.max_val not work for last no. of int
		TreeNode res = inorderPrdecInBst(root, 25);
		System.out.println(succ.val);
		/*The successor of node 15 is 16
		The successor of node 10 is 12
		The successor of node 20 is 25
		The successor of node 8 is 10
		The successor of node 12 is 15
		The successor of node 16 is 20
		No Successor exists for node 25*/
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