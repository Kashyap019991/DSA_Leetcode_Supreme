package com.kas.designpat.extra;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class LC_994_rottenoranges {
    public static int orangesRotting(int[][] grid) {
        Queue<Pair<Integer,Integer>> q = new LinkedList<Pair<Integer,Integer>>();
        
        //count rooten and fresh oranges
        int freshOra =0;
        for(int r= 0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c] ==1)
                {
                    freshOra++;
                }
                if(grid[r][c] ==2){
                    
                    q.offer(new Pair(r,c));
                }
            }
        }
        
        int timeElapsed = -1;
        q.offer(new Pair(-1,-1));
        
        while(!q.isEmpty()){
            Pair<Integer,Integer> pair = q.poll();
            int r = pair.getKey();
            int c = pair.getValue();
            
            if(r==-1) 
            {
            timeElapsed++;
            if(!q.isEmpty()) q.offer(new Pair(-1,-1));
            
            }
            //
            else{
            int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
            
            for(int d[]: dir){
                int newr = r + d[0];
                int newc = c + d[1];
                
                if(newr >=0 && newr < grid.length && newc >=0 && newc < grid[0].length){
                    if(grid[newr][newc] ==1)
                    {
                        grid[newr][newc] =2;//make  it rotten
                        q.offer(new Pair(newr,newc)); 
                        freshOra--;
                    }
                }
                
            }
            }
        }
        if(freshOra ==0) return timeElapsed; else return -1;
    }
    public static void main(String[] args) {
    	int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
    	System.out.println(orangesRotting(grid));
	}
}