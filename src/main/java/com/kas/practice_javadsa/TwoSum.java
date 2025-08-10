package com.kas.practice_javadsa;

import java.util.HashMap;
import java.util.Map;

class TwoSum {

    Map<Integer,Integer> hashMap = new HashMap();//num, count 1,2,3,4,7 
    public TwoSum() {
        
    }
    
    public void add(int number) {
        hashMap.put(number,hashMap.getOrDefault(number,0)+1);
    }
    
    public boolean find(int value) {
        for(int num:hashMap.keySet()){
            //hashSet.remove(num);
            if(hashMap.containsKey(value-num) )
            {   
                //hashSet.add(num);
                if(value-num == num){
                    if(hashMap.get(num) >=2)
                        return true;
                    else 
                        return false;
                }
                return true;
            }
            
        }
        return false;
    }
    
    public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		twoSum.add(0);
		twoSum.add(0);
		System.out.println(twoSum.find(0));
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */