package com.kas.practice_javadsa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class LFUCache {
    HashMap<Integer,FreqTS> cache;
    TreeMap<FreqTS,Integer> countCache;
    int capacity;
    int timeStamp;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap();
		/*
		 * countCache = new TreeMap(new Comparator<FreqTS>(){ public int compare(FreqTS
		 * ft1,FreqTS ft2){ if(ft1.freq == ft2.freq) { return
		 * ft1.timeStamp-ft2.timeStamp; } return ft1.freq-ft2.freq; } });//least count
		 * key//count as key,value
		 */        timeStamp=0;
		 countCache = new TreeMap<FreqTS, Integer>(new Comparator<FreqTS>() {
		        public int compare(FreqTS t1, FreqTS t2) {
		            if (t1.freq == t2.freq) {
		                return t1.timeStamp - t2.timeStamp;
		            }
		            return t1.freq - t2.freq;
		        }
		    });
    }
    //1,1
    //1,1
    //cnt,List<Integer>
    public int get(int key) {
        if(cache.get(key) == null)
            return -1;// not present
        else{//present then increment used freq and return value
           
           FreqTS fts = cache.get(key);
           System.out.println(key +",,,"+fts.freq);
           //increment used freq and ts
            FreqTS newFts = new FreqTS(key,fts.value,fts.freq+1,timeStamp++);
            System.out.println(newFts.key +",,,"+newFts.freq);
            cache.put(key,newFts);
            countCache.size();
            countCache.remove(fts);
            countCache.put(newFts,key);
            return fts.value;
        }
    }
    
    public void put(int key, int value) {
        //if(cache.size() < capacity)
        //{
            //then put value in cache and count of that key as 1
            if(cache.get(key)==null){//key not available
            	if(cache.size() >= capacity) {
            		
            		Map.Entry<FreqTS,Integer> entry = countCache.pollFirstEntry();//if last the most freq used

                    cache.remove(entry.getValue());//remove from main cache 
                    //countCache.remove(entry.key);//remove from countcache
                    System.out.println(entry.getValue());
                    FreqTS newFts = new FreqTS(key,value,1,timeStamp++);
                    cache.put(key,newFts);
                    countCache.put(newFts,key);
            	}else {
		            FreqTS fts = new FreqTS(key,value,1,timeStamp++);
		            cache.put(key,fts);
		           
		            countCache.put(fts,key);//insert updated one
		            countCache.size();
            		}
            }
        //}
        else{//key already available
            //if already available then incremnt freq and timestamp and put in both cache
            //if(cache.get(key)!= null){
                FreqTS fts = cache.get(key);
                FreqTS newFts = new FreqTS(key,value,fts.freq+1,timeStamp++);

                cache.put(key,newFts);
                countCache.remove(fts);//remove old one
                countCache.put(newFts,key);

            }
            

            
        
    }
    
    public static void main(String[] args) {
        //	["LFUCache","put","put","get","put","get","get","put","get","get","get"]
        	//		[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
        					
        	LFUCache l = new LFUCache(2);
			/*
			 * l.put(1, 1); l.put(2, 2); l.get(1); l.put(3, 3);
			 */
        	
        	//[2],[2,1],[2,2],[2],[1,1],[4,1],[2]
        	l.put(2, 1);
        	l.put(2, 2);
        	l.get(2);
        	System.out.println("a");
    	}  
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 class FreqTS{
    int key;
    int value;
    int freq;
    int timeStamp;

    public FreqTS(int key,int value,int freq,int timeStamp){
        this.key = key;
        this.value = value;
        this.freq = freq;
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object obj) 
    { 
          
    // if both the object references are  
    // referring to the same object. 
    if(this == obj) 
            return true; 
          
        // it checks if the argument is of the  
        // type Geek by comparing the classes  
        // of the passed argument and this object. 
        // if(!(obj instanceof Geek)) return false; ---> avoid. 
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
          
        // type casting of the argument.  
        FreqTS geek = (FreqTS) obj; 
          
        // comparing the state of argument with  
        // the state of 'this' Object. 
        return (geek.key == (this.key)) ; 
    } 
      
    @Override
    public int hashCode() 
    { 
          
        // We are returning the Geek_id  
        // as a hashcode value. 
        // we can also return some  
        // other calculated value or may 
        // be memory address of the  
        // Object on which it is invoked.  
        // it depends on how you implement  
        // hashCode() method. 
        return this.key; 
    } 
    
}