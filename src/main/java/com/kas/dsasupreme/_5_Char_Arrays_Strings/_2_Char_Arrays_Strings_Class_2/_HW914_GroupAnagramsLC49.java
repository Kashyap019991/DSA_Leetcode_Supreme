package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;

//https://leetcode.com/problems/group-anagrams/
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;

//trs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
public class _HW914_GroupAnagramsLC49 {
	public static List<List<String>> groupAnagrams(String[] strs) {
		// List<List<String>> ans = new ArrayList<List<String>>();
		// // create hash[<char,int>, List<String>]
		// // i.e for eat : <e-1,a-1,t-1 -> eat,tea,ate>
		// HashMap<Integer, List<String>> hm = new HashMap<Integer,
		// List<String>>();
		//
		// for (int i = 0; i < strs.length; i++) {
		// String curr = strs[i];
		// // create array as key
		// Integer[] key = new Integer[256];
		// Arrays.fill(key, 0);
		// for (int j = 0; j < curr.length(); j++) {
		// key[curr.charAt(j)] = key[curr.charAt(j)] + 1;
		// }
		// Integer keyHash = Arrays.hashCode(key);
		// // insert key and value in hm
		// if(hm.containsKey(keyHash))
		// hm.get(keyHash).add(curr);
		// else
		// hm.put(keyHash, new ArrayList<String>(Arrays.asList(curr)));
		// }
		//
		// //iterrate over map and add value of each entry in ans
		// for(Entry entry:hm.entrySet()){
		// ans.add((List<String>) entry.getValue());
		// }
		// return ans;
		//
		// }
		List<List<String>> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>(); // value is the position of
														// result
		for (String s : strs) {
			int k = getKey(s);
			int resultIndex = map.getOrDefault(k, -1);
			List<String> list = null;
			if (resultIndex == -1) {
				list = new ArrayList<>();
				result.add(list);
				map.put(k, result.size() - 1);
			} else {
				list = result.get(resultIndex);
			}
			list.add(s);
		}
		return result;
	}

	public static int getKey(String s) {
		// # convert count to char again
		int[] map = new int[26];
		for (char c : s.toCharArray()) {
			map[c - 'a']++;
		}
		return Arrays.hashCode(map);
	}

	public static void main(String args[]) throws Exception {
		String[] inp = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(inp));
	}
}