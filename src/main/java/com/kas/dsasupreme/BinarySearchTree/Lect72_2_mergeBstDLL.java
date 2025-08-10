package com.kas.dsasupreme.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//1. range base checking for each node while inserting
//2. 

public class Lect72_2_mergeBstDLL {
	static int i = 0; // use global var instead of static in leet code

	static TreeNode bstFromPreorder(int[] preorder, double min, double max) {

		if (i == preorder.length)
			return null;
		if (preorder[i] < min || preorder[i] > max)
			return null;

		TreeNode root = new TreeNode(preorder[i++]);

		root.left = bstFromPreorder(preorder, min, root.val);
		root.right = bstFromPreorder(preorder, root.val, max);
		return root;
	}

	static void inOrder(TreeNode root, List<Integer> inO1) {
		if (root == null)
			return;

		inOrder(root.left, inO1);
		inO1.add(root.val);
		inOrder(root.right, inO1);
	}

	static void mergeTwoSortedList(List<Integer> inO1, List<Integer> inO2, List<Integer> mergedList) {
		int i = 0, j = 0;

		while (i < inO1.size() && j < inO2.size()) {
			if (inO1.get(i) < inO2.get(j)) {
				mergedList.add(inO1.get(i));
				i++;
			} else {
				mergedList.add(inO2.get(j));
				j++;
			}
		}
		while (i < inO1.size()) {
			mergedList.add(inO1.get(i));
			i++;
		}
		while (j < inO2.size()) {
			mergedList.add(inO2.get(j));
			j++;
		}
	}
	
	static TreeNode createBstInOrd(List<Integer> mergedList , int s, int e){
		if(s > e) return null;
		int mid = (s+e)/2;
		
		TreeNode root = new TreeNode(mergedList.get(mid));
		root.left = createBstInOrd(mergedList, s, mid-1);
		root.right = createBstInOrd(mergedList, mid+1, e);
		
		return root;
		
	}

	public static void main(String[] args) {

		int[] element1 = new int[] { 3, 1, 5 };
		int[] element2 = new int[] { 4, 2, 6 };

		TreeNode root1 = createBst(element1);
		TreeNode root2 = createBst(element2);

		// s-1 create inorder of bith tree
		List<Integer> inO1 = new ArrayList<>();
		List<Integer> inO2 = new ArrayList<>();
		inOrder(root1, inO1);
		inOrder(root2, inO2);

		// merge 2 sorted list
		List<Integer> mergedList = new ArrayList<>();
		mergeTwoSortedList(inO1, inO2, mergedList);

		// create BST from merged sorted List
		TreeNode res = createBstInOrd(mergedList, 0 , mergedList.size() -1);

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