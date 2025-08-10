package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

class Pairx {
	long first;
	long second;

	Pairx(long first, long second) {
		this.first = this.first;
		this.second = this.second;
	}
}

public class CountPath {

	public int countPaths(int n, int[][] roads) {
		long mod = (int) (1e9 + 7);
		ArrayList<ArrayList<Pairx>> adjList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList());
		}

		int rowCnt = roads.length;

		for (int i = 0; i < rowCnt; i++) {
			adjList.get(roads[i][0]).add(new Pairx(roads[i][1], roads[i][2]));
			adjList.get(roads[i][1]).add(new Pairx(roads[i][0], roads[i][2]));
			// adjList.get(roads.get(i).get(0)).add(new Pairx(roads.get(i).get(1),
			// roads.get(i).get(2)));
			// adjList.get(roads.get(i).get(1)).add(new Pairx(roads.get(i).get(0),
			// roads.get(i).get(2)));
		}

		PriorityQueue<Pairx> pq = new PriorityQueue<>((Pair1, Pair2) -> Long.compare(Pair1.first, Pair2.first));

		long[] dist = new long[n];
		long[] ways = new long[n];

		for (int i = 0; i < n; i++) {
			dist[i] = Long.MAX_VALUE;
			ways[i] = 0;
		}
		// starting mai
		dist[0] = 0;
		ways[0] = 1;
		pq.add(new Pairx(0, 0));

		while (!pq.isEmpty()) {

			Pairx fNd = pq.poll();
			long fDist = fNd.first;// node
			long fNode = fNd.second;// cost

			for (Pairx p1 : adjList.get((int) fNode)) {
				long distance = p1.first;
				long node = p1.second;

				if (fDist + node < dist[(int) distance]) {
					dist[(int) distance] = fDist + node;
					pq.add(new Pairx(fDist + node, distance));
					ways[(int) distance] = ways[(int) node];
				} else if (fDist + node == dist[(int) distance]) {
					ways[(int) distance] = (ways[(int) distance]) + ways[(int) node] % mod;
				}
			}

		}
		return (int) (ways[n - 1] % mod);
	}

	public static void main(String[] args) {
		/*
		 * Employee e1,e2,e3,e4; e1 = new Employee("a"); //e1.setName("a"); e2 = new
		 * Employee("b"); //e2.setName("a"); //e1=e2; //e3 = new Employee();
		 * //e3.setName("c"); //e4 = new Employee(); //e4.setName("a");
		 * System.out.println(e1.equals(e2)); //exception List<Employee> empList = new
		 * ArrayList(); empList.add(e1); empList.add(e2); //empList.add(e3);
		 * //empList.add(e4);
		 * 
		 * 
		 * List<String> list= new ArrayList<>(); list.add("a"); list.add("b");
		 * list.add("a"); list.add("a"); //list.add("a");
		 * 
		 * Map<String,Integer> countMap = new HashMap<String,Integer>();
		 * 
		 * for(String entity:list) { if(countMap.containsKey(entity)) { int cnt =
		 * countMap.get(entity)+1; countMap.put(entity, cnt);
		 * 
		 * } else { countMap.put(entity, 1); }
		 * 
		 * } for(Entry<String, Integer> e:countMap.entrySet()) { if(e.getValue()==3) {
		 * System.out.println("count:"+e.getKey()); } }
		 * 
		 * 
		 * //list.stream().count() //find out string 3 times //distinct value based on
		 * Name attribute List<String> distinctName =
		 * empList.stream().map(Employee::getName).distinct().collect(Collectors.toList(
		 * )); //List<String> distinctEmployee=
		 * empList.stream().distinct().collect(Collectors.toList());
		 * 
		 * //for(S) System.out.println(distinctName); //
		 * 
		 * int[][] roads =
		 * {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6
		 * ,2}}; int n=7; CountPath co = new CountPath();
		 * System.out.println(co.countPaths(n,roads));
		 * 
		 * //
		 */ 
		}

}

/*
 * class Employee { // @Data String Name;
 * 
 * public Employee(String name) { super(); Name = name; }
 * 
 * public String getName() { return Name; }
 * 
 * public void setName(String name) { Name = name; }
 * 
 * }
 */