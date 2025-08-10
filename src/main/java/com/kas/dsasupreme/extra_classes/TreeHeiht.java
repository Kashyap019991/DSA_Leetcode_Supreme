package com.kas.dsasupreme.extra_classes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int val){
		this.val = val;
	}
	TreeNode(int val, TreeNode left, TreeNode right){
		this.val = val;
		this.right = right;
		this.left = left;
	}
}
public class TreeHeiht {
	static int height(TreeNode node){
		if(node == null) return 0;
		
		
		int lh = height(node.left);
		int rh = height(node.right);
		
		int h = 1+ max(lh,rh);
		return h;
	} 
	static int max(int lh,int lr){
		if(lh>lr)
		return lh;
		else
			return lr;
		
	}
	
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
	
	static void levelOrderTra(TreeNode root){
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
	
	static void preOrder(TreeNode root){
		if(root == null)return;
		System.out.print(" "+root.val);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	static void inOrder(TreeNode root){
		if(root == null)return;
		inOrder(root.left);
		System.out.print(" " + root.val);
		inOrder(root.right);
	}
	static void postOrder(TreeNode root){
		if(root == null)return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(" "+root.val);
	}
	static int count =0;
	static void countLeafNode(TreeNode root){
		if(root == null) return ;
		
		countLeafNode(root.left);
		if(root.left == null && root.right ==null) count++;
		countLeafNode(root.right);
		
	}
	
	static boolean isIdentical(TreeNode node1 , TreeNode node2){
		
		if(node1 == null && node2 == null){
			return true;
		}
		if(node1 == null && node2 != null){
			return false;
		}
		if(node1 != null && node2 == null){
			return false;
		}
		
		boolean left = isIdentical(node1.left,node2.left);
		boolean right = isIdentical(node1.right,node2.right);
		
		if(left && right && (node1.val == node2.val)){
			return true;
		}
		else return false;
		
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
		
		root1 = buildTree(root1);
		boolean val = isIdentical(root, root1);
		System.out.println(val);
	}
}