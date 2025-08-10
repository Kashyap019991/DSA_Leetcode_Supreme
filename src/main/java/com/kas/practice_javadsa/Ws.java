package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TrieNode{
    HashMap<Character,TrieNode> child = new HashMap<>();
    TrieNode(){}
    String word = null;
}
class Ws {
	  List<String> ans = new ArrayList<>();
	    char[][] board;
	    int rows;
	    int cols;
	    public List<String> findWords(char[][] board, String[] words) {
	        TrieNode root = new TrieNode();
	         rows = board.length;
	         cols = board[0].length;
	         for(String word:words){
	 	            TrieNode t = root;
	 	            for(Character c:word.toCharArray()){
	 	                if(t.child.get(c) != null){
	 	                    //get and assign it to t
	 	                    t = t.child.get(c);
	 	                    
	 	                }
	 	                else{
	 	                    //put new node with char ch in t
	 	                	TrieNode newt = new TrieNode();
	 	                    t.child.put(c,newt);
	 	                    t = newt;
	 	                }
	 	            }
	 	            t.word =word;
	 	            
	 	        }
	         this.board = board;
	         for(int i=0;i<rows;i++){
	             for(int j=0;j<cols;j++){
	                 if(root.child.get(board[i][j]) != null)
	                     backtrack(i,j,root);
	             }
	         }
	         return ans;
	     }
	     
	     void backtrack(int i,int j,TrieNode parent){
	         Character currLtr = board[i][j];
	         TrieNode currNode = parent.child.get(currLtr);
	         if(currNode.word != null){
	             //add word to ans list
	             ans.add(currNode.word);
	             currNode.word = null;
	         }
	         
	         board[i][j] = '#';//mark as visited so that when backtrack same letter not match to currstr 
	         int[] dirx = {-1,0,1,0};
	         int[] diry = {0,1,0,-1};
	         
	         for(int dir=0;dir<4;dir++){
	             int newx = dirx[dir] + i;
	             int newy = diry[dir] +j;
	             if(newx<0 || newy<0 ||
	           newx>= rows || newy >=cols){
	             continue;
	         }
	             //TrieNode newCurrNode = currNode.child.get(board[i][j]);
	             if(currNode.child.get(board[newx][newy]) !=null)
	             {
	                 backtrack(newx,newy,currNode.child.get(board[newx][newy]));
	             }
	         }
	         board[i][j] = currLtr;
	         
	     }
    public static void main(String[] args) {
    	char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
    	String[] words = {"oath","eat"};
    	Ws w = new Ws();
    	System.out.println(w.findWords(board,words));
    	
	}
}