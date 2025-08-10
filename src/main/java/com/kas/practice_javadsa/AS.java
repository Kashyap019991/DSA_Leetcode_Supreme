package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AS {
    class Node{
        HashMap<Character,Node> children = new HashMap<>();
        Map<String,Integer> wordNode = new HashMap();//word,count
    }

	/*
	 * public AutocompleteSystem(String[] sentences, int[] times) {
	 * 
	 * insertWordToTrie(sentences,times); }
	 */
    Node root = new Node();
	
	 
    
    void insertWordToTrie(String[] sentences,int[] times){
        int count =0;
        for(String word:sentences){
            Node node = root;
            int time = times[count++];
            for(Character ch:word.toCharArray()){
                if(node.children.containsKey(ch)){
                    //already available then get it
                    node = node.children.get(ch);
                    
                    node.wordNode.put(word,node.wordNode.getOrDefault(word,0)+time);
                }
                else{
                    Node newNode = new Node();
                    node.children.put(ch,newNode);
                    node.wordNode.put(word,time);
                    node =newNode;
                }
            }
            node.wordNode.put(word, time);
        }
        
    }
    StringBuilder sb = new StringBuilder();
    public List<String> input(char c) {
        //String s="";
        
       // int input =1;
        if(c != '#'){
            
            sb.append(c);
            Map<String,Integer> matchedWord = matchWordInTrie(sb.toString());
            List<String> autoSuggestion = new ArrayList();
            
            
            //matchedWord.entrySet.stream().sorted(Map.entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x ->{});
            List<Map.Entry<String, Integer>> list = new ArrayList<>(matchedWord.entrySet());  
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {  
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
					if (o1.getValue() == o2.getValue())
						return o1.getKey().compareTo(o2.getKey());

					return o2.getValue().compareTo(o1.getValue());
				}  
            });  
			/*
			 * Map<String,Integer> topThree = list.entrySet().stream()
			 * .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) .limit(3)
			 * .collect(Collectors.toMap( Map.Entry::getKey, Map.Entry::getValue, (e1, e2)
			 * -> e1, LinkedHashMap::new));
			 */
            int counter=0;
            for(Map.Entry<String,Integer> ent:list){
                    if(counter==3)
                    	break;
                    
                    autoSuggestion.add(ent.getKey());
                    counter++;
                    }
                    
                   
                
             counter=0;
            
            return  autoSuggestion;
        }
           
        if(c == '#'){
            //Map<String,Integer> matchedWord = matchWordInTrie(sb.toString());
            
            /*
            Map<String,Integer> matchedWord = matchWordInTrie(sb.toString());
            List<String> autoSuggestion = new ArrayList();
            int counter=0;
           // matchedWord.entrySet.stream().sorted(Map.entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x ->{});
            
           // List<Map.Entry<String, Integer>> list = new ArrayList<>(matchedWord.entrySet());  
            List<Map.Entry<String, Integer>> list = new ArrayList<>(matchedWord.entrySet());  
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {  
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
					if (o1.getValue() == o2.getValue())
						return o1.getKey().compareTo(o2.getKey());

					return o2.getValue().compareTo(o1.getValue());
				}  
            });  
			/*
			 * Map<String,Integer> topThree = list.entrySet().stream()
			 * .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) .limit(3)
			 * .collect(Collectors.toMap( Map.Entry::getKey, Map.Entry::getValue, (e1, e2)
			 * -> e1, LinkedHashMap::new));
			 */
           // int counter=0;
            /*
            for(Map.Entry<String,Integer> ent:list){
                    if(counter==3)
                    	break;
                    
                    autoSuggestion.add(ent.getKey());
                    counter++;
                    }
                    
                   
                
             counter=0;
             */
             insertWordToTrie(new String[]{sb.toString()},new int[]{1});
            sb = new StringBuilder();
            return  new ArrayList<String>();
        }
        return  new ArrayList();
    }
    
    Map<String,Integer> matchWordInTrie(String s){
        Node node = root;
        
        for(Character ch:s.toCharArray()){
            
            if(node.children.containsKey(ch)){
                node = node.children.get(ch);
            }
            else{
                return new HashMap();
            }
        
            
        }
        return node.wordNode;
        
    }public static void main(String[] args) {
    	//["AutocompleteSystem","input","input","input","input"]
		//	[[["i love you","island","iroman","i love leetcode"],[5,3,2,2]],["i"],[" "],["a"],["#"]]
	String[] sentences = {"abc","abbc","a"};//{"i love you","island","iroman","i love leetcode"};
	int[] times = {3,3,3};//{5,3,2,2};
	AS as = new AS();
	
	//as.addToTrie(sentence, 0);
	as.insertWordToTrie(sentences,times);
	/*
	 * as.input('i').stream().forEach(a -> System.out.println(a));
	 * System.out.println("==============1=================="); as.input('
	 * ').stream().forEach(a -> System.out.println(a));
	 * System.out.println("============2====================");
	 * as.input('a').stream().forEach(a -> System.out.println(a));
	 * System.out.println("=============3===================");
	 * as.input('#').stream().forEach(a -> System.out.println(a));
	 * System.out.println("==============4==================");
	 * as.input('i').stream().forEach(a -> System.out.println(a));
	 * System.out.println("===============5================="); as.input('
	 * ').stream().forEach(a -> System.out.println(a));
	 * System.out.println("================6================");
	 * as.input('a').stream().forEach(a -> System.out.println(a));
	 * System.out.println("=================7===============");
	 * as.input('#').stream().forEach(a -> System.out.println(a));
	 * System.out.println("===============8=================");
	 * as.input('i').stream().forEach(a -> System.out.println(a));
	 * System.out.println("==============9=================="); as.input('
	 * ').stream().forEach(a -> System.out.println(a));
	 * System.out.println("=============10===================");
	 * as.input('a').stream().forEach(a -> System.out.println(a));
	 * System.out.println("=============11===================");
	 * as.input('#').stream().forEach(a -> System.out.println(a));
	 * System.out.println("===============12=================");
	 */
	
	as.input('b').stream().forEach(a -> System.out.println(a));
	System.out.println("==============1==================");
	as.input('c').stream().forEach(a -> System.out.println(a));
	System.out.println("============2====================");
	//as.input('a').stream().forEach(a -> System.out.println(a));
	//System.out.println("=============3===================");
	as.input('#').stream().forEach(a -> System.out.println(a));
	System.out.println("==============4==================");
	as.input('b').stream().forEach(a -> System.out.println(a));
	System.out.println("===============5=================");
	as.input('c').stream().forEach(a -> System.out.println(a));
	System.out.println("================6================");
	//as.input('a').stream().forEach(a -> System.out.println(a));
	//System.out.println("=================7===============");
	as.input('#').stream().forEach(a -> System.out.println(a));
	System.out.println("===============8=================");
	as.input('a').stream().forEach(a -> System.out.println(a));
	System.out.println("==============9==================");
	as.input('b').stream().forEach(a -> System.out.println(a));
	System.out.println("=============10===================");
	as.input('c').stream().forEach(a -> System.out.println(a));
	System.out.println("=============11===================");
	as.input('#').stream().forEach(a -> System.out.println(a));
	System.out.println("===============12=================");
	as.input('a').stream().forEach(a -> System.out.println(a));
	System.out.println("==============13==================");
	as.input('b').stream().forEach(a -> System.out.println(a));
	System.out.println("=============14===================");
	as.input('c').stream().forEach(a -> System.out.println(a));
	System.out.println("=============15===================");
	as.input('#').stream().forEach(a -> System.out.println(a));
	System.out.println("===============16=================");
}
}
/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
