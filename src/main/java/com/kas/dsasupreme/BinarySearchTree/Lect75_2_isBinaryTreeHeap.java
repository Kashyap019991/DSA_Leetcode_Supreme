package com.kas.dsasupreme.BinarySearchTree;

import com.kas.Tree.TreeDay1;
import com.kas.Tree.TreeNode;




public class Lect75_2_isBinaryTreeHeap {
	
	static int ans = 0;
	static int countNode(TreeNode node){
		
		if(node == null) return 0;
		
		ans = 1 + countNode(node.left) + countNode(node.right);
		return ans;
	}
	static Boolean isCbt(TreeNode node , int  index, int cnt) {
		
		if(node == null) return true;
		
		if(index >= cnt)
			return false;
		else
		{
		Boolean left = isCbt(node.left, 2 * index +1, cnt);
		Boolean right = isCbt(node.right, 2 * index +2, cnt);
		return left && right;
		}
	}
	
	static Boolean isMaxOrder(TreeNode node){
		
		//leaf node
		if(node.left == null && node.right == null) return true;
		
		//only left
		if(node.right == null) 
			return node.val >node.left.val;
		
		//both chilld
		else
			return node.val > node.left.val && 
					node.val > node.right.val &&
					isMaxOrder(node.left) &&
					isMaxOrder(node.right);
		
	}
	static int[] element = new int[] { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1,-1 };
	static int i =0 ;
	public static void main(String[] args) {
		
		TreeNode root = null;
		root = buildTree(root);
		//TreeDay1.levelOrderTra(root);
		int cnt = countNode(root);
		if(isCbt(root , 0 , cnt) && isMaxOrder(root)){
			System.out.println(true);
		}
		else
			System.out.println(false);

	
	}

	
static TreeNode buildTree(TreeNode root){
		
		//Scanner sc = new Scanner(System.in);
		//System.out.println("Enter data:");
		//int data =sc.nextInt();
		int data = element[i];
		i++;
		root = new TreeNode(data);
		if(data==-1)return null;
		//1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
		//System.out.println("Enter left of data: "+data);
		root.left = buildTree(root.left);
		//System.out.println("Enter right of data: "+data);
		root.right = buildTree(root.right);
		
		return root;
	}
}