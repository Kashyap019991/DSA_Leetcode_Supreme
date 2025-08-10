package com.kas.dsasupreme._10_Graph.Class5;

import java.util.HashMap;

class Graph_Class5_1_LC547_NoOfProvince {
    public HashMap<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
    void dfs(int src, int[][] isConnected){
        visited.put(src,true);
        //here row=>src, col=> we will write loop

        int size = isConnected[src].length;

        for(int col=0;col<size;col++){
            if(src != col && isConnected[src][col] == 1 )
            {   //System.out.println(col);
            	if(visited.get(col) != true)
                dfs(col,isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count =0;// to count no. of provinces
        //to tracke node is visited or not
        
        int n  = isConnected.length;
        //make all node visted as false
        for(int i=0;i<=n;i++){
            visited.put(i,false);
        }
        //iterate over each node
        for(int i =1;i<=n;i++){
            if(visited.get(i-1) == false){
                dfs(i-1,isConnected);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
		int[][] isConnected = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
		Graph_Class5_1_LC547_NoOfProvince gcnop = new Graph_Class5_1_LC547_NoOfProvince();
		int noOfProvince = gcnop.findCircleNum(isConnected);
		System.out.println(noOfProvince);
	}
}