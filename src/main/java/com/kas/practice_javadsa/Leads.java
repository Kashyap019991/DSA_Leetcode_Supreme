package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Leads {
   
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer> storeSrc = new ArrayList<>();
        boolean[] visited =new boolean[n];
        for(int[] edge:edges){
            if(edge[0] == source)
            {
                visited[edge[0]] =true;
                storeSrc.add(edge[1]);
            }
            if(edge[0] == edge[1])
            	return false;
           
        }
        
        if(storeSrc.isEmpty()) return false;
        for(int src:storeSrc){
			/*
			 * if(src==destination) return false; else
			 */{
				 boolean[] v = new boolean[visited.length];
				 
				 for(int i=0;i<v.length;i++)
					 v[i] = visited[i];
                if(!bfs(src,destination,edges , v))
                    return false;
            }
        }
        return true;
    }
    
    boolean bfs(int src,int destination,int[][] edges,boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
            q.add(src);
           
            while(!q.isEmpty()){

                 src = q.poll();
                if(src == destination )
                    return true;
                for(int[] edge:edges){
                    if(visited[edge[0]] != true ){
                    	//if(edge[0] != s)
                        q.add(edge[1]);
                        visited[src] = true;
                    }
                }
            }
            return false;
            
            
    }
    
    public static void main(String[] args) {
		int[][] edges = {{0,1},{0,2},{1,3},{2,4},{3,5},{4,5},{2,6}};//{{0,1},{0,2},{0,3},{0,3},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}};//{{1,0}};//{{0,1},{1,1}};//{{0,1},{0,3},{1,2},{2,1}};//{{0,1},{0,2},{1,3},{2,3}};//
		int n=7,src=0,dest=5;
		Leads l = new Leads();
		System.out.println(l.leadsToDestination(n, edges, src, dest));
	}
}