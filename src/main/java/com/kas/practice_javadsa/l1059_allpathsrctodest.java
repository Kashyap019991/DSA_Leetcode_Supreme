package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class l1059_allpathsrctodest {
	
	
	 public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {/*
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
	        if(storeSrc.isEmpty()) return false;//as no edge from srcto dest
	        for(int src:storeSrc){
	            //if(src==destination)
	                //return false;
	            boolean[] v = new boolean[visited.length];

	            for(int i=0;i<visited.length;i++)
	                v[i] = visited[i];
	            {
	                if(!bfs(src,destination,edges , v))
	                    return false;
	            }
	        }
	        */
	        List<Integer>[] adjList = new ArrayList[n];
	        boolean[] visited = new boolean[n];
	        int[] indeg = new int[n];//to detect cycle
	        for(int[] edge:edges){
	            if(adjList[edge[0]] == null)
	            {
	                adjList[edge[0]]= new ArrayList();
	                adjList[edge[0]].add(edge[1]);
	                indeg[edge[1]]++;
	            }
	            else{
	                adjList[edge[0]].add(edge[1]);
	                indeg[edge[1]]++;
	            }
	        }
	        
	        if(!bfs(source,destination,adjList,visited,indeg))
	            return false;
	        return true;
	    }
	    
	    boolean bfs(int src,int destination,List<Integer>[] adjList,boolean[] visited,int[] indeg){
	        Queue<Integer> q = new LinkedList<>();
	            q.add(src);
	            visited[src] = true;
	            while(!q.isEmpty()){
	                
	                 src = q.poll();
	                 visited[src] =false;
	                 
	                  if(src == destination && adjList[src] != null) //dest has cycle then ret false
		                    return false;

	                if(src == destination)//skip checking nbr as dest not having cycle
	                    continue;
	                
	                if(adjList[src] == null && src != destination) return false;//no path from src
	                for(int e:adjList[src]){
	                   // if(visited[e] != true)
	                    {
	                        //if(edge[0] == s)
	                        
	                        if(indeg[e] <0) return false;//cycle detected 
	                        if(visited[e]) continue;
	                        
	                        q.add(e);
	                        indeg[e]--;
	                        visited[e]=true;
	                    }
	                   
	                }
	            }
	            return true;
	            
	            
	    }
	    //[0,1],[0,2],[1,3],[2,4],[3,5],[4,5],[2,6] src 0 dest 5 , failed case

}
