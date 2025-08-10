package com.kas.practice_javadsa;

import java.util.Arrays;
import java.util.PriorityQueue;

class MinScore {
    public static int[][] minScore(int[][] grid) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[2]-b[2]);

        //get all the points from the grid in ascending order
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                pq.add(new int[]{i,j,grid[i][j]});
            }
        }
        //here, we store the maximum value we have seen till now for ith row and column
        int [] maxRow= new int[grid.length];
        int [] maxCol= new int[grid[0].length];

        //for each point we fetch in order, it is going to be greater than any previously seen point
        //so what we need to do is, find the max value in the current rowe and column till now and put next number as the next point, update max values
        //this way for each row and column, we greedily get numbers in ascendding order and make sure that the order is maintained, using extra space to store max row and col values, we ensure that no duplicates are there in current row and col
        while(!pq.isEmpty()){
            int [] point= pq.poll();
            int i= point[0], j=point[1];
            int maxR= maxRow[i];
            int maxC= maxCol[j];
            int newVal= Math.max(maxR,maxC)+1;
            grid[i][j] = newVal;
            maxRow[i]= newVal;
            maxCol[j]= newVal;
        }

        return grid;
    }
    
    public static void main(String[] args) {
    	
    	int[][] grid = {{2, 4, 5}, {7, 3, 9}};//{{3,1},{2,5}};
		System.out.println(Arrays.deepToString(minScore(grid)));
	}
} 