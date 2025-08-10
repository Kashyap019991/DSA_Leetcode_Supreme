
package com.kas.dsasupreme._10_Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Lect86_BfsGraph {
	// we are using set instead of list bcoz we need ordered neighbour
	static Map<Integer, Set<Integer>> adjList = new TreeMap<Integer, Set<Integer>>();

	static void addEdges(int u, int v, int directed) {

		if (adjList.get(u) == null) {
			adjList.put(u, new HashSet<>(Arrays.asList(v)));
		} else
			adjList.get(u).add(v);

		// undirected then add reverse
		if (directed == 0) {
			if (adjList.get(v) == null) {
				adjList.put(v, new HashSet<>(Arrays.asList(u)));
			} else
				adjList.get(v).add(u);
		}
	}
	static ArrayList<Integer> ans = new ArrayList<>();
	static void bfsTrav(int nVertices){
		Queue<Integer> q = new LinkedList<Integer>();
		Map<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
		
		for(int nodes=0;nodes<nVertices;nodes++){
			if(visited.get(nodes) ==null)
				q.add(nodes);
		
		while(!q.isEmpty()){
			int fnode = q.poll();
			//not added in map means not visited
			if(visited.get(fnode) == null){
				//add into visited
				visited.put(fnode, true);
				
				//add fnode to ans
				ans.add(fnode);
				
				//add neighbour into queue
				//below if to check if vertices has no neghbour
				if(adjList.get(fnode) != null){
					for(int nbr:adjList.get(fnode)){
						q.add(nbr);
					}
				}
			}
			
		}
		}
		
	}
	public static void main(String args[])

	{

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data no. nodes:");
		int n = sc.nextInt();
		System.out.println("Enter data no. edges:");
		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			//take input as edges i.e 2-> 3
			int u = sc.nextInt();
			int v = sc.nextInt();

			//0 means undirected , 1 means directed
			//prepare adjacecny list
			addEdges(u, v, 0);
		}
		
		/*for(int key:adjList.keySet()){
			
			System.out.println(key +" -> "+adjList.get(key));
		}*/
		
		//Bfs traversal
		//adjlist
		//int src = sc.nextInt();
		
		//n is no.of vertex
		bfsTrav(n);
		
		System.out.println("BFS Trav: "+ans);
	}

	/*5
	6
	0 1
	1 2
	2 3
	3 1
	3 4
	0 4
*/
	

	//{0=[4], 1=[2, 3], 2=[3], 3=[1, 4], 4=[0]}
	
	
	//ex -2 node 5 edge 4
	/*5
	4
	0 3
	3 1
	1 4
	1 2
	0
	o/p[0, 3, 1, 4, 2]
	*/
	//ex-2 node 4 edge 4
	/*
	4
	4
	0 1
	0 3
	1 2
	2 3
	0
	*/
	
	/*
	 7
	 6
     0 1
     0 2
     1 2
     1 3
     4 5
     4 6
     5 6
     0
	 */
	/*
	 2 
	 1
	 0 1
	 */
	/*
	 5
	 0
	 */
	/*
	 9 
		10
		0 8
		1 6
		1 7
		1 8
		5 8
		6 0
		7 3
		7 4
		8 7
		2 5
	 0 6 8 1 5 7 2 3 4 
	 */
	/*
	 5 
		8
		0 1
		0 4
		1 2
		2 0
		2 4
		3 0
		3 2
		4 3
		
		0 1 2 3 4 
	 */
}
