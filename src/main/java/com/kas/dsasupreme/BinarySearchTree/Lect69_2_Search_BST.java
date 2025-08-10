package com.kas.dsasupreme.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class Lect69_2_Search_BST {

	static TreeNode searchInBstRec(TreeNode node, int data) {
		if (node == null) {
			return null;
		}

		if (node.val == data) {
			return node;
		}

		if (node != null) {
			if (data < node.val)
				node = searchInBstRec(node.left, data);
		}
		if (node != null) {
			if (data > node.val)
				node = searchInBstRec(node.right, data);
			;
		}
		return node;

	}

	// iterative
	static TreeNode searchInBstItr(TreeNode node, int data) {

		while (node != null) {

			if (node.val == data) {
				return node;
			}

			if (node != null) 
			{
				if (data < node.val)
					node = node.left;
			}
			if (node != null) 
			{
				if (data > node.val)
					node = node.right;
			}

		}
		return null;
	}

	public static void main(String[] args) {
		int[] element = new int[] { 4, 2, 7, 1, 3 };
		TreeNode root = createBst(element);
		TreeNode root1 = searchInBstItr(root, 5);
		if (root1 != null)
			levelOrderTra(root1);
		else
			System.out.println();
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