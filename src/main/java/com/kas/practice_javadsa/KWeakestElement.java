package com.kas.practice_javadsa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

class KWeakestElement {
    public int[] kWeakestRows(int[][] mat, int k) {
/*        Map<Integer,Integer> rowNumVsCount = new TreeMap<>(new Comparator<Map.Entry<Integer, Integer>> () {

            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                if(e1.getValue() == e2.getValue())
                return e1.getKey().compareTo(e2.getKey());

                return e1.getValue() - e2.getValue();
            }
        });//rowNum -> freq of 1
  */     
    	//Map<Integer,Integer> rowNumVsCount = new TreeMap<>();
    	//int[] here a->rowNum , b->count of 1
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) ->
        {	if(a[1] == b[1]) return a[0] - b[0];
        	return a[1]-b[1];
        }	
);
// rowNumVsCount.get(a) - rowNumVsCount.get(b)); // min count 
        int[] kWeakestElement = new int[k];
        int i=0;
        for(int[] row:mat){
            
            int count =0;
            for(int a:row){
                
                if(a==1)
                    count++;
            }
            //rowNumVsCount.put(i,count);
            minHeap.add(new int[] {i,count});
            count =0;
            
            i++;
        }
        
        for(int w=0;w<k;w++){
            if(minHeap.size() >0)
                kWeakestElement[w] = minHeap.poll()[0];
        }
        return kWeakestElement; 
    }
    
    public static void main(String[] args) {
		int[][] mat= {
				 {1,1,0,0,0},
				 {1,1,1,1,0},
				 {1,0,0,0,0},
				 {1,1,0,0,0},
				 {1,1,1,1,1}};
		
		int k=3;
		KWeakestElement sl = new KWeakestElement();
		System.out.println(Arrays.toString(sl.kWeakestRows(mat,k)));
	}
    
}