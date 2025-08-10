package com.kas.dsasupreme.dp;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Node{
	int data;
	Node left;
	Node right;
	Node(int data, Node left, Node right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
}
public class Day140__7_HoffmanCoding_gfg {
	static void preOrder(Node root, String temp,ArrayList<String> ans){
		
		if(root.left == null && root.right == null) {
			ans.add(temp);
			return;
		}
		
		preOrder(root.left, temp+ "0", ans);
		preOrder(root.right, temp + "1", ans);
		
	}
	static ArrayList<String> hoffManCodeing(String s, int[] fre , int N)  {
		PriorityQueue<Node> pq =new PriorityQueue<>((a,b) -> {
			if(a.data != b.data)return a.data - b.data;
			return 1;//// to maintain the order in which they are given.
		});
		
		
		for(int i = 0;i<fre.length;i++){
			pq.add(new Node(fre[i],null,null));
		}
		
		// Tree ban gya
		while(pq.size() > 1){
			Node left = pq.poll();
			Node right = pq.poll();
			
			pq.add(new Node(left.data+right.data,left,right));
		}
		
		//traverse preOrder
		ArrayList<String> ans = new ArrayList<>();
		preOrder(pq.remove(),"", ans);
		return ans;
	}

	public static void main(String[] args) {
		//String S = "qwertyuiopasdfghjklzxcvbn";
		String S = "abcdef";
		int N = S.length();// no. of char in string
		//int[] f = new int[]{8,9,14,19,20,21,21,25,33,45,50,50,66,68,70,73,74,75,76,82,85,90,94,97,100}; //freq of each letter
		int[] f = new int[]{5, 9, 12, 13, 16, 45};
		System.out.println(hoffManCodeing(S,f,N));
	}
}
