package com.kas.practice_javadsa;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Map<Integer ,Node> cache;
    int cap ;
    Node head = new Node(0,0);;
    Node tail = new Node(0,0);
    public LRUCache(int capacity) {
        cache = new HashMap<Integer,Node>();
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
       // head = new Node(0,0);
       // tail = new Node(0,0);
    }
    
    public int get(int key) {
        //if already available then remove and insert again to maintain LRU
        if(cache.get(key) != null){
            Node node = cache.get(key);
            
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key,value);
        //cache.put(key,node);
        //TODO:
        if(cache.size() == cap){
            //remove from tail and insert at head
            remove(tail.prev);
            
            
        }
       if(cache.get(key) != null){
            //if not then insert in head and increase cap size by one
            
            
            remove(cache.get(key));
            
            
        }
        insert(node);
    }
    void insert(Node node){
        //1    ->   2   ->   3
        //       0<-      <-
        
        cache.put(node.key,node);
        node.next = head.next;
        head.next.prev = node; 
        
        node.prev = head;
        head.next = node;
        
    }
    
    void remove(Node node){
        //0 -> 1 -> 2 -> 0
        //  <-   <-   <-
        cache.remove(node.key);
        node.prev.next = node.next;
        
        node.next.prev = node.prev;
        
        
        
    }
}

class Node{
    int val;
    int key;
    Node prev;
    Node next;
    
    Node(int val,int key){
        this.val = val;
       this.key = key;
    }
}





/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */