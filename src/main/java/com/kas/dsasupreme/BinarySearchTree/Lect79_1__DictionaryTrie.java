package com.kas.dsasupreme.BinarySearchTree;

import com.kas.Tree.TreeDay1;
import com.kas.Tree.TreeNode;

class TrieNode {

	//char data;
	TrieNode[] children = new TrieNode[26];
	Boolean isTerminal;

	TrieNode(char ch) {
		//data = ch;
		for (int i = 0; i < 26; i++) {
			children[i] = null;
		}
		isTerminal = false;
	}
}

public class Lect79_1__DictionaryTrie {

	static TrieNode root = new TrieNode('/');
	
	static void insertWordInDict(String word) {
		TrieNode temp = root;
		for (char ch : word.toCharArray()) {
			// check ch present
			int indx = ch - 'a';
			if (temp.children[indx] == null) {
				// if not present char add to trie
				temp.children[indx] = new TrieNode(ch);

			}
			temp = temp.children[indx];
		}
		temp.isTerminal = true;
	}
	
	static Boolean searchWordFromDict(String word){
		TrieNode temp = root;
		for(char ch: word.toCharArray()){
			//check if present or not
			if(temp.children[ch - 'a'] == null)
				{
				return false;
				}
			temp= temp.children[ch - 'a'];
		}
		//check if last char is set as terminal 
		if(temp.isTerminal)
			return true;
		else 
			return false;
	}
	
	static Boolean startsWith(String word){
		TrieNode temp = root;
		for(char ch: word.toCharArray()){
			//check if present or not
			if(temp.children[ch - 'a'] == null)
				{
				return false;
				}
			temp= temp.children[ch - 'a'];
		}
		//no need to check terminal
			return true;
		
	}
	
	public static void main(String[] args) {
		String Contacts[] = new String[] { "coding", "codingninja", "code" };
		String WordSearching = "cod";
		//insert each contact in trie
		for(String s:Contacts)
			insertWordInDict(s);
		
		
		System.out.println("Word present:" + searchWordFromDict("coding"));
		System.out.println("Word present:" + startsWith("cod"));
	}
}

// https://www.techiedelight.com/implement-trie-data-structure-java/
/*
 * 
 * import java.util.ArrayList; import java.util.Collections; import
 * java.util.List;
 * 
 * // A class to store a Trie node class Trie { // Define the alphabet size (26
 * characters for `a � z`) private static final int CHAR_SIZE = 26;
 * 
 * private boolean isLeaf; private List<Trie> children = null;
 * 
 * // Constructor Trie() { isLeaf = false; children = new
 * ArrayList<>(Collections.nCopies(CHAR_SIZE, null)); }
 * 
 * // Iterative function to insert a string into a Trie public void
 * insert(String key) { System.out.println("Inserting \"" + key + "\"");
 * 
 * // start from the root node Trie curr = this;
 * 
 * // do for each character of the key for (char c: key.toCharArray()) { //
 * create a new Trie node if the path does not exist if (curr.children.get(c -
 * 'a') == null) { curr.children.set(c - 'a', new Trie()); }
 * 
 * // go to the next node curr = curr.children.get(c - 'a'); }
 * 
 * // mark the current node as a leaf curr.isLeaf = true; }
 * 
 * // Iterative function to search a key in a Trie. It returns true // if the
 * key is found in the Trie; otherwise, it returns false public boolean
 * search(String key) { System.out.print("Searching \"" + key + "\" : ");
 * 
 * Trie curr = this;
 * 
 * // do for each character of the key for (char c: key.toCharArray()) { // go
 * to the next node curr = curr.children.get(c - 'a');
 * 
 * // if the string is invalid (reached end of a path in the Trie) if (curr ==
 * null) { return false; } }
 * 
 * // return true if the current node is a leaf node and the // end of the
 * string is reached return curr.isLeaf; } }
 * 
 * class Main { public static void main (String[] args) { // construct a new
 * Trie node Trie head = new Trie();
 * 
 * head.insert("techie"); head.insert("techi"); head.insert("tech");
 * 
 * System.out.println(head.search("tech")); // true
 * System.out.println(head.search("techi")); // true
 * System.out.println(head.search("techie")); // true
 * System.out.println(head.search("techiedelight")); // false
 * 
 * head.insert("techiedelight");
 * 
 * System.out.println(head.search("tech")); // true
 * System.out.println(head.search("techi")); // true
 * System.out.println(head.search("techie")); // true
 * System.out.println(head.search("techiedelight")); // true } }
 */