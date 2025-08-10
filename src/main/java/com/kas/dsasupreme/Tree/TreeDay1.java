package com.kas.dsasupreme.Tree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class TreeDay1 {
	
	// 1. b uilde tree
	static TreeNode buildTree(TreeNode root){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data:");
		int data =sc.nextInt();
		root = new TreeNode(data);
		if(data==-1)return null;
		//1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
		System.out.println("Enter left of data: "+data);
		root.left = buildTree(root.left);
		System.out.println("Enter right of data: "+data);
		root.right = buildTree(root.right);
		
		return root;
	}
	//2. level order traversal
	public static void levelOrderTra(TreeNode root){
		//1 3 7
		TreeNode temp = null;
		Queue<TreeNode> q =new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			temp=q.peek();
			q.poll();
			System.out.print(" "+temp.val);
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
	}
	//3. pre order
	static void preOrder(TreeNode root){
		if(root == null)return;
		System.out.print(" "+root.val);
		preOrder(root.left);
		preOrder(root.right);
	}
	//4. in order
	static void inOrder(TreeNode root){
		if(root == null)return;
		inOrder(root.left);
		System.out.print(" " + root.val);
		inOrder(root.right);
	}
	//5. post order
	static void postOrder(TreeNode root){
		if(root == null)return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(" "+root.val);
	}
	//6. count leaf node
	static int count =0;
	static void countLeafNode(TreeNode root){
		if(root == null) return ;
		
		countLeafNode(root.left);
		if(root.left == null && root.right ==null) count++;
		countLeafNode(root.right);
		
	}
	
	public static void main(String[] args) {
		TreeNode t1,t2,t3,t4,t5,t6,t7,t8,t9;
		t4 = new TreeNode(4);
		t7 = new TreeNode(7);
		t3 = new TreeNode(3);
		t6 = new TreeNode(6,t7,null);
		t5 = new TreeNode(5,t6,null);
		t2 = new TreeNode(2,t3,t4);
		t1 = new TreeNode(1,t2,t5);
		//int maxheight = height(t1); 
		//System.out.println(maxheight);
		////1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
		TreeNode root = null,root1 =null;
		root = buildTree(root);
		System.out.println("level order traversal:  ");
		levelOrderTra(root);
		System.out.println("\nPreorder traversal: ");
		preOrder(root);
		System.out.println("\nInorder traversal: ");
		inOrder(root);
		System.out.println("\nPostorder traversal: ");
		postOrder(root);
		countLeafNode(root);
		System.out.println("Count :"+count);
		}
}