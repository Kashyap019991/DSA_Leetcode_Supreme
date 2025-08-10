package com.kas.dsasupreme.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class Lect69_3_Delete_BST {

	static TreeNode deleteInBstItr(TreeNode root, int data) {
		if (root == null)
			return root;

		// find node with data to be deleted
		if (root.val == data) {

			// node has 0 child
			if (root.left == null && root.right == null) {
				// delete root node ret null
				return root = null;
			}

			// node has 1 child
			// only left child
			if (root.left != null && root.right == null) {
				TreeNode temp = root;
				// delete root and assign root.left to root
				return root = temp.left;
			}
			// only right
			if (root.left == null && root.right != null) {
				TreeNode temp = root;
				// delete root node and replace right node at root
				return root = temp.right;
			}

			// node has 2 child
			if (root.left != null && root.right != null) {
				// find min from right subtree
				TreeNode temp = root.right;
				while (temp.left != null) {
					temp = temp.left;
				}
				// assign min val to root
				root.val = temp.val;
				// delete min val from right subtree
				root.right = deleteInBstItr(root.right, temp.val);
				return root;
			}

		} else if (root.val > data) {
			// left part mai node hogi
			root.left = deleteInBstItr(root.left, data);
			return root;
		} else {
			// right part mai hogi
			root.right = deleteInBstItr(root.right, data);
			return root;
		}
		return root;

	}

	public static void main(String[] args) {
		int[] element = new int[] { 5, 3, 6, 2, 4, 7 };
		TreeNode root = createBst(element);
		TreeNode root1 = deleteInBstItr(root, 3);

		levelOrderTra(root);

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