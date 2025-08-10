package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.List;

class MyHashMap {
    //LinkedList<Integer>[] buckets;
    int maxLength=1000000;
   // int valueRange = 800;
    //List<key,value>[]
   List<List<Integer>>[] buckets = new ArrayList[maxLength];
    public MyHashMap() {

      /*
        buckets = new LinkedList[keyRange];
        for(int b=0;b<keyRange;b++){
            buckets[b] = new LinkedList<Integer>();
          
        }*/
    }
    
    public void put(int key, int value) {
        
        int index = key%maxLength;
        
        List<List<Integer>> indexedList = buckets[index];
        if(indexedList != null){
            for(int i=0;i<indexedList.size();i++){
                if(indexedList.get(i).get(0) == key)
                {
                    buckets[index].remove(i);

                }
            }
        }
        if(indexedList == null){
            buckets[index] = new ArrayList<>();
        }
        List<Integer> posIndexedList=  new ArrayList<>();
                posIndexedList.add(key);
                posIndexedList.add(value);
                buckets[index].add(posIndexedList);
/*
        for(int b=0;b<buckets.size();b++){
           // for(int bucket.get(0):)
           if(buckets.get(b).get(0) == key){
            buckets.remove(b);
           }
        }
        List<Integer> list = new ArrayList();
        list.add(key);
        list.add(value);
         buckets.add(list);
 */
 
 /*  
      int ind = key%keyRange+value%valueRange;
        
        //int valueInd = value% valueRange;
        
         if(buckets[ind].size() <= ind){//i=1, ind s=2
        
            for(int i=0;i<=ind;i++){
                buckets[ind].add(i,-1);
            }
            }
     
            buckets[ind].set(ind,value);
      */  
    
    }
    public int get(int key) {
        
        int index = key%maxLength;
        
        List<List<Integer>> indexedList = buckets[index];
        if(indexedList == null)
            return -1;
        for(int i=0;i<indexedList.size();i++){
            if(indexedList.get(i).get(0) == key)
            {
                return indexedList.get(i).get(1);
                
            }
        }

   /*     int ind = key%keyRange+value%valueRange;
        //int valueInd =value % valueRange;
        if(buckets[ind].size() >ind ){
            return buckets[ind].get(ind);
       }
       // return -1;*/
/*
       for(int b=0;b<buckets.size();b++){
           // for(int bucket.get(0):)
           if(buckets.get(b).get(0) == key){
               return buckets.get(b).get(1);
       }
  */
        
    
    return -1;
    }

    public void remove(int key) {
        
        int index = key%maxLength;
        
        List<List<Integer>> indexedList = buckets[index];
        if(indexedList ==null)
            return;
        for(int i=0;i<indexedList.size();i++){
            if(indexedList.get(i).get(0) == key)
            {
                 //indexedList.remove(i);
                 buckets[index].remove(i);
                
            }
        }
    /*    int ind = key%keyRange+vale%valueRange;
       if(buckets[ind].size() >ind )
            buckets[ind].set(ind,-1);
    }*/
        
    /*
    for(int b=0;b<buckets.size();b++){
           // for(int bucket.get(0):)
           if(buckets.get(b).get(0) == key){
        buckets.remove(b);
    }
    */
    
}

public static void main(String[] args) {
	//["MyHashMap","put","put","get","get","put","get","remove","get"]
	//[[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]]
	
	MyHashMap mhm = new MyHashMap();
	mhm.put(1,2);
	mhm.put(2, 2);
	System.out.println(mhm.get(1));
	System.out.println(mhm.get(3));
	mhm.put(2, 1);
	System.out.println(mhm.get(2));
	System.out.println(mhm.get(2));
	System.out.println(mhm.get(2));
	
}
    }


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */