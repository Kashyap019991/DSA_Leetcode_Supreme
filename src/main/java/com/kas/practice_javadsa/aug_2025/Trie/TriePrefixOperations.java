package com.kas.practice_javadsa.aug_2025.Trie;

import java.util.HashMap;

public class TriePrefixOperations {
    TrieNodeStruct root = new TrieNodeStruct();
    void insertWordtoTrie(String word){
        TrieNodeStruct temp =root;
        int n = word.length();
        for(int i=0;i<n;i++){
            Character ch = word.charAt(i);
            if(temp.trieNode.get(ch) == null){
                temp.trieNode.put(ch, new TrieNodeStruct());
            }

                temp=temp.trieNode.get(ch);

            if(i==n-1){
                //mark as terminal
                temp.isTerminal=true;
            }
        }

    }

    Boolean searchWordToTrie(String word){
        TrieNodeStruct temp = root;
        for(Character ch: word.toCharArray()){
            if(temp.trieNode.get(ch) == null){
                return false;
            }
            temp = temp.trieNode.get(ch);
        }

        if(temp.isTerminal==true)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        TriePrefixOperations trieOp = new TriePrefixOperations();
        String word = "abc";
        trieOp.insertWordtoTrie(word);
        System.out.println("insert done");
        word = "acc";
        trieOp.insertWordtoTrie(word);
        System.out.println("insert done");
        word = "accd";
        trieOp.insertWordtoTrie(word);
        System.out.println("insert done");

        System.out.println(trieOp.searchWordToTrie("abc"));
        System.out.println(trieOp.searchWordToTrie("acc"));
        System.out.println(trieOp.searchWordToTrie("acd"));
        System.out.println(trieOp.searchWordToTrie("accd"));

    }
}
class TrieNodeStruct{
    HashMap<Character, TrieNodeStruct> trieNode=new HashMap<Character,TrieNodeStruct>();
    Boolean isTerminal=false;


}