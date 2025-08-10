
package com.kas.dsasupreme._10_Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class Lect91_TopoLogicalSort_BfsKahnsDirectedAcyclicgraph {

	static Map<Integer,List<Integer>> adjList = new TreeMap<Integer,List<Integer>>();
	
	static void addEdgesDAG(int u, int v){
		
		//u -> v
		if(adjList.get(u) == null )
		{
			//create new List and add to map as val
			adjList.put(u, new ArrayList<Integer>(Arrays.asList(v)));
		}
		else
		{
			//insert element in already created List
			adjList.get(u).add(v);
		}
		
	}
	
	static List<Integer> topoSortBfsDAG(int nodes,int m){
		//find indegree of nodes
		
		ArrayList<Integer> inDegreeListOfNodes = new ArrayList<Integer>(Collections.nCopies(nodes, 0));
		for(int key:adjList.keySet()){
			List<Integer> al = adjList.get(key);
			for(int j:al){
				int k= inDegreeListOfNodes.get(j);
				inDegreeListOfNodes.set(j, k+1);
			}
		}
		//System.out.println(inDegreeListOfNodes);
		
		//0 in degree walo ko Queue mai insert kr do
		Queue<Integer> qBfsOp = new LinkedList<>();
		
		for(int i=0;i<inDegreeListOfNodes.size();i++){
			if(inDegreeListOfNodes.get(i) == 0)
				{
					qBfsOp.add(i);
				}
		}
		
		//perform Bfs Operation and every time make indegree -1 of neighbour
		//and insert in queue, while pop store in ans List
		List<Integer> ans = new ArrayList<Integer>();
		while(!qBfsOp.isEmpty()){
			int fnode = qBfsOp.poll();
			//store in ans
			ans.add(fnode);
			
			//make indegree -1 of all neighbour , and push in Queue if indegree is 0
			if(adjList.get(fnode) != null){
				for(int j:adjList.get(fnode)){
					int indeg  = inDegreeListOfNodes.get(j);
					inDegreeListOfNodes.set(j, indeg-1);
					if(inDegreeListOfNodes.get(j) == 0)
						qBfsOp.add(j);
				}
			}
		}
		return ans;
	}
	public static void main(String args[])
	{

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data no. nodes:");
		int n = sc.nextInt();
		System.out.println("Enter data no. edges:");
		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			// take input as edges i.e 2-> 3
			int u = sc.nextInt();
			int v = sc.nextInt();

			addEdgesDAG(u, v);
		}

		//pass indexing 0 based or 1 base
		System.out.println("ans:"+topoSortBfsDAG(n,m));
		
	}

/*
 6
 7
 1 2
 1 3
 2 4
 3 4
 4 5
 4 6
 5 6
 
 
 */
/*
 6
 6
 5 2
 5 0
 4 0
 4 1
 2 3
 3 1
 
 {2=[3], 3=[1], 4=[0, 1], 5=[0, 2]}
 5 4 2 3 1 0
 */
	
/*
 4
 4
 0 1
 0 3
 1 2
 3 2

 */
/*
 5
 5
 0 1
 0 2
 1 4
 2 4
 4 3
 */
}
