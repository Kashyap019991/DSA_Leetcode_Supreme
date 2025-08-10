package com.kas.dsasupreme.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

//gfg: https://practice.geeksforgeeks.org/problems/phone-directory4628/1
public class Lect81_PhoneDirectorySuggestions_Trie {

	static TrieNode contactTrie = new TrieNode('\0');

	static void insertIntoTrie(String s) {
		TrieNode temp = contactTrie;
		for (char c : s.toCharArray()) {
			int indx = c - 'a';
			if (temp.children[indx] == null) {
				temp.children[indx] = new TrieNode(c);
			}
			temp = temp.children[indx];
		}
		temp.isTerminal = true;
	}

	static List<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
	static ArrayList<String> ls = new ArrayList<>();
	static int i = 0;

	static void printSuggestion(StringBuilder prefix, TrieNode curr){
		
		if(curr.isTerminal){
			ls.add(prefix.toString());
		}
		
		for(char ch = 'a';ch<='z';ch++){
			
			TrieNode next = curr.children[ch - 'a'];
			
			if(next != null){
				prefix.append(ch);
				printSuggestion(prefix, next);
				prefix.deleteCharAt(prefix.length()-1);
			}
			
		}
	}

	static void getSuggestion(String Contacts[], String wordSearch){
		
		StringBuilder sb = new StringBuilder();
		TrieNode prev = contactTrie;
		for(char ch:wordSearch.toCharArray()){
		
			sb.append(ch);
			
			TrieNode curr = prev.children[ch-'a'];
			//no match in trie
			if(curr == null)
				break;
			
			
			printSuggestion(sb, curr);
			ans.add(new ArrayList<>(ls));
			ls.clear();
			prev = curr;
		}	
		
	}
		
	public static void main(String[] args) {
		String Contacts[] = new String[] {"geeikistest", "geeksforgeeks","geeksfortest"};
		String WordSearching = "geek";
		// insert each contact in trie
		for (String s : Contacts)
			insertIntoTrie(s);

		getSuggestion(Contacts, WordSearching);
		
		System.out.println(ans);
	}
}