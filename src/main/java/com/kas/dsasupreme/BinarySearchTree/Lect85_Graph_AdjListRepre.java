
package com.kas.dsasupreme.BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Lect85_Graph_AdjListRepre {
	static Map<Integer, List<Integer>> adjList = new TreeMap<Integer, List<Integer>>();

	static void addEdges(int u, int v, int directed) {

		if (adjList.get(u) == null) {
			adjList.put(u, new ArrayList<>(Arrays.asList(v)));
		} else
			adjList.get(u).add(v);

		// undirected then add reverse
		if (directed == 0) {
			if (adjList.get(v) == null) {
				adjList.put(v, new ArrayList<>(Arrays.asList(u)));
			} else
				adjList.get(v).add(u);
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
			addEdges(u, v, 0);
		}
		
		for(int key:adjList.keySet()){
			
			System.out.println(key +" -> "+adjList.get(key));
		}
	}

	/*5
	6
	0 1
	1 2
	2 3
	3 1
	3 4
	0 4*/
	//{0=[4], 1=[2, 3], 2=[3], 3=[1, 4], 4=[0]}
}
