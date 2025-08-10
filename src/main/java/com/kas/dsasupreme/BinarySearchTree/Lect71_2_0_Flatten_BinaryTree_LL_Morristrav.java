package com.kas.dsasupreme.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class Lect71_2_0_Flatten_BinaryTree_LL_Morristrav {
	//Morris Trav -->Flatten a binary tree to ll
	static void flattenBinaryTree(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
        	//ls mai max wala logic 
            if (curr.left != null) {
                TreeNode predecessor = curr.left;
                while(predecessor.right != null) predecessor = predecessor.right;
                predecessor.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
        
    }

	public static void main(String[] args) {
	
		int[] element = new int[] { 1,2,5,3,4,6};
				
		TreeNode root = createBst(element);
		// moris traversal for flatten binary tree not for bst
		flattenBinaryTree(root);
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
