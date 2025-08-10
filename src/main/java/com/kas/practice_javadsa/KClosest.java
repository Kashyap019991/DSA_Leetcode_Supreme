package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]//sort by distance
        );
        int ind=0;
        for(int[] point:points){
            int euclid = point[0]*point[0] + point[1]*point[1];

            minHeap.add(new int[]{euclid ,ind});
            ind++;
        }
        List<int[]> listOfKClosest = new ArrayList();
        while(k>0){
            int[] indArr = minHeap.poll();
            //if(indArr != null)
            int row = indArr[1];
            listOfKClosest.add(new int[] {points[row][0], points[row][1]});
            k--;
        }
        int[][] kClosePoints = new int[k+1][2];
        int i=0;
        for(int[] kClosestPoint:listOfKClosest){
            kClosePoints[i][0] = kClosestPoint[0];
            kClosePoints[i][1] = kClosestPoint[1];
            i++;
        }

        return kClosePoints;
    }
    
    public static void main(String[] args) {
		
    	int[][] arr = {{1,3},{-2,2}};
    	int k=1;
    	DecodeString sl1 = new DecodeString();
    	System.out.println(Arrays.deepToString(sl1.kClosest(arr,k)));
	}
}