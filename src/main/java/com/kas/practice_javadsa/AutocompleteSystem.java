package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class TrieNode {
    Map<Character, xormax> children;
    Map<String, Integer> sentences;
    public TrieNode() {
        children = new HashMap<>();
        sentences = new HashMap<>();
    }
}

class AutocompleteSystem {
    xormax root;
    xormax currNode;
    xormax dead;
    StringBuilder currSentence;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new xormax();
        for (int i = 0; i < sentences.length; i++) {
            addToTrie(sentences[i], times[i]);
        }
        
        currSentence = new StringBuilder();
        currNode = root;
        dead = new xormax();
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            addToTrie(currSentence.toString(), 1);
            currSentence.setLength(0);
            currNode = root;
            return new ArrayList<String>();
        }
        
        currSentence.append(c);
        if (!currNode.children.containsKey(c)) {
            currNode = dead;
            return new ArrayList<String>();
        }
        
        currNode = currNode.children.get(c);
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
            int hotA = currNode.sentences.get(a);
            int hotB = currNode.sentences.get(b);
            if (hotA == hotB) {
                return b.compareTo(a);
            }
            
            return hotA - hotB;
        });
        
        for (String sentence: currNode.sentences.keySet()) {
            heap.add(sentence);
            if (heap.size() > 3) {
                heap.remove();
            }
        }
        
        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) {
            ans.add(heap.remove());
        }
        
        Collections.reverse(ans);
        return ans;
    }
    
    private void addToTrie(String sentence, int count) {
        xormax node = root;
        for (char c: sentence.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new xormax());
            }
            
            node = node.children.get(c);
            node.sentences.put(sentence, node.sentences.getOrDefault(sentence, 0) + count);
        }
    }

    
    public static void main(String[] args) {
    	//["AutocompleteSystem","input","input","input","input"]
    		//	[[["i love you","island","iroman","i love leetcode"],[5,3,2,2]],["i"],[" "],["a"],["#"]]
		String[] sentences = {"i love you","island","iroman","i love leetcode"};
		int[] times = {5,3,2,2};
		AutocompleteSystem as = new AutocompleteSystem(sentences,times);
		
		//as.addToTrie(sentence, 0);
		//as.insertWordToTrie(sentences,times);
		as.input('i').stream().forEach(a -> System.out.println(a));
		System.out.println("==============1==================");
		as.input(' ').stream().forEach(a -> System.out.println(a));
		System.out.println("============2====================");
		as.input('a').stream().forEach(a -> System.out.println(a));
		System.out.println("=============3===================");
		as.input('#').stream().forEach(a -> System.out.println(a));
		System.out.println("==============4==================");
		as.input('i').stream().forEach(a -> System.out.println(a));
		System.out.println("===============5=================");
		as.input(' ').stream().forEach(a -> System.out.println(a));
		System.out.println("================6================");
		as.input('a').stream().forEach(a -> System.out.println(a));
		System.out.println("=================7===============");
		as.input('#').stream().forEach(a -> System.out.println(a));
		System.out.println("===============8=================");
		as.input('i').stream().forEach(a -> System.out.println(a));
		System.out.println("==============9==================");
		as.input(' ').stream().forEach(a -> System.out.println(a));
		System.out.println("=============10===================");
		as.input('a').stream().forEach(a -> System.out.println(a));
		System.out.println("=============11===================");
		as.input('#').stream().forEach(a -> System.out.println(a));
		System.out.println("===============12=================");
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */