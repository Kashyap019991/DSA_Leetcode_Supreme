package com.kas.practice_javadsa;

import java.util.LinkedList;

class MyHashSet {
    LinkedList<Integer>[] Buckets;
    public MyHashSet() {
         this.Buckets = new LinkedList[769];
         for(int ind=0;ind<769;ind++){
            Buckets[ind] = new LinkedList<Integer>();
         }
    }
    
    public void add(int key) {
        int index  = key%769;
        if(Buckets[index].indexOf(key) ==-1)
        {
            Buckets[index].addFirst(key);
        }
    }
    
    public void remove(int key) {
        int index = key%769;
        if(Buckets[index].indexOf(key) != -1)
            Buckets[index].remove(Buckets[index].indexOf(key));
    }
    
    public boolean contains(int key) {
        int index = key % 769;
        return Buckets[index].indexOf(key) != -1;
    }
    
    public static void main(String[] args) {
		MyHashSet mh = new MyHashSet();
		mh.add(9);
		mh.remove(19);
		mh.add(14);
		mh.remove(19);
		mh.remove(9);
		mh.add(0);
		mh.add(3);
		mh.add(4);
		mh.add(0);
		mh.remove(0);
		
		//["MyHashSet","add","remove","add","remove","remove","add","add","add","add","remove"]
		//		[[],[9],[19],[14],[19],[9],[0],[3],[4],[0],[9]]
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */