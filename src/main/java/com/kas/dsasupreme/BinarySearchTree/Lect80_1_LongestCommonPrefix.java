package com.kas.dsasupreme.BinarySearchTree;

import com.kas.Tree.TreeDay1;
import com.kas.Tree.TreeNode;

/*class TrieNode {

	char data;
	TrieNode[] children = new TrieNode[26];
	Boolean isTerminal;

	TrieNode(char ch) {
		data = ch;
		for (int i = 0; i < 26; i++) {
			children[i] = null;
		}
		isTerminal = false;
	}
}*/

public class Lect80_1_LongestCommonPrefix {

	static String longestCommonPrefix(String[] strs) {
		// 1st string all chars
		int i = -1;
		Boolean match = true;
		StringBuilder sb = new StringBuilder();
		for (char ch : strs[0].toCharArray()) {
			i++;
			// rest of all string 1ast chars
			for (int j = 1; j < strs.length; j++) {
				//1. check string length of remaining string
				// check matching character
				if (i >= strs[j].length() ||  ch != strs[j].charAt(i)) {
					match = false;
					break;
				}
				
			}
			if (match == false)
				break;
			else
				sb.append(ch);
		}
		return sb.toString();

	}
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{"coding","codingninja","code"}));
	}
}