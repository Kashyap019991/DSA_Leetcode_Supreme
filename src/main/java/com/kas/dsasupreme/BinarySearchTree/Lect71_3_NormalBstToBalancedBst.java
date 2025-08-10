package com.kas.dsasupreme.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//1. inorder nikal lo
//2. inorder mai se bst bna lo

public class Lect71_3_NormalBstToBalancedBst {
	
	
	static void inorderBst(TreeNode root,List<Integer> ls) {
		if(root == null) return;
		
		
		inorderBst(root.left, ls);
		ls.add(root.val);
		inorderBst(root.right, ls);
	}
	
	static TreeNode createBalancedBstFromInOrd(TreeNode root, List<Integer>ls,int s,int e){
		
		if(s > e) return null;
		
		int mid = (s+e) /2;
		
		TreeNode res = new TreeNode(ls.get(mid));
		res.left = createBalancedBstFromInOrd(root,ls, s, mid-1);
		res.right = createBalancedBstFromInOrd(root, ls, mid+1, e);
		
		return res;
	}
	public static void main(String[] args) {
		int k = -4;
		int[] element = new int[] {2,1,3};
				
		TreeNode root = createBst(element);
		// here integer.max_val not work for last no. of int
		List<Integer> ls = new ArrayList<>();
		inorderBst(root,ls);
		TreeNode res = createBalancedBstFromInOrd(root, ls,0,ls.size()-1);
		
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