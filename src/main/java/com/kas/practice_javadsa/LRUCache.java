package com.kas.practice_javadsa;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Map<Integer , Noode> cache;
    int cap ;
    Noode head = new Noode(0,0);;
    Noode tail = new Noode(0,0);
    public LRUCache(int capacity) {
        cache = new HashMap<Integer, Noode>();
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
       // head = new Node(0,0);
       // tail = new Node(0,0);
    }
    
    public int get(int key) {
        //if already available then remove and insert again to maintain LRU
        if(cache.get(key) != null){
            Noode noode = cache.get(key);
            
            remove(noode);
            insert(noode);
            return noode.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Noode noode = new Noode(key,value);
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
        insert(noode);
    }
    void insert(Noode noode){
        //1    ->   2   ->   3
        //       0<-      <-
        
        cache.put(noode.key, noode);
        noode.next = head.next;
        head.next.prev = noode;
        
        noode.prev = head;
        head.next = noode;
        
    }
    
    void remove(Noode noode){
        //0 -> 1 -> 2 -> 0
        //  <-   <-   <-
        cache.remove(noode.key);
        noode.prev.next = noode.next;
        
        noode.next.prev = noode.prev;
        
        
        
    }
}

class Noode {
    int val;
    int key;
    Noode prev;
    Noode next;
    
    Noode(int val, int key){
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