package com.kas.practice_javadsa;

import java.util.HashMap;
import java.util.Map;

class Node{
    HashMap<Character, Node> children = new HashMap<>();
    Boolean isWord =false;
    Map<String,Integer> currVal = new HashMap<>();
}
class MapSum {
    Node root;
    public MapSum() {
        root = new Node();
        
    }
    
    public void insert(String key, int val) {
        Node Node =root;
        for(Character ch:key.toCharArray()){
            if(Node.children.containsKey(ch))
            {//already available then get it
                Node = Node.children.get(ch);
                Node.currVal.put(key,val);
            }else{
                //if not thn insert
                Node newNode = new Node();
                Node.children.put(ch, newNode);
                Node.currVal.put(key,val);
                Node = newNode;
            }
            
        }
        Node.isWord = true;
        Node.currVal.put(key,val);
    }
    
    public int sum(String prefix) {
       Node sumNode = root;
        int sum = 0;
        int counter =0;
        for(Character ch:prefix.toCharArray()){
            if(sumNode.children.containsKey(ch)){
                sumNode = sumNode.children.get(ch);
                counter++;
            }
            
        }
        
        if(counter == prefix.length()){//it reched to end of search word
            Map<String,Integer> vals = sumNode.currVal;
            
            
            for(String val:vals.keySet())
                sum += vals.get(val);
        }
        
        
        return sum;
    }
    
    public static void main(String[] args) {
		MapSum ms = new MapSum();
		ms.insert("apple", 3);
		System.out.println(ms.sum("apple"));
		ms.insert("app",2);
		System.out.println(ms.sum("ap"));
		ms.insert("apple", 2);
		System.out.println(ms.sum("ap"));
	}
}
