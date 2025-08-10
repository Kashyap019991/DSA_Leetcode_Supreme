package com.kas.dsasupreme._10_Graph.Class6;



import java.util.*;


class Tuple{
    int diffDist;
    int row;
    int col;


    Tuple(int d, int r, int c){
        this.diffDist = d;
        this.row = r;
        this.col    = c;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return diffDist == tuple.diffDist && row == tuple.row && col == tuple.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diffDist, row, col);
    }
}

class Graph_Class6_4_LC1631_PathWithMinEffort {


    public int minimumEffortPath(int[][] heights) {

        //BFS with priority queue bcoz we need min diff node to iterate
        //tuple{diff, row, col}
        //minheap min value be on to based of dist
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.diffDist - y.diffDist);

        //insert src with 0 dist
        pq.add(new Tuple(0, 0 ,0));

        int n = heights.length;//no. of row
        int m = heights[0].length;//no. of cold
        //create 2d matrix to store updated distance from parent
        int[][] dist = new int[n][m];
        //initialize with intMax
        for(int i =0 ;i<n;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        //iterate bfs
        while(!pq.isEmpty()){

            Tuple ftpl =  pq.poll();
            int diffDist = ftpl.diffDist;
            int row = ftpl.row;
            int col = ftpl.col;
            //if we reach destination with min effort bcoz popped elem from minheap
            if(row == n-1 && col == m-1) return diffDist;
            int[] dx= {0,1,0,-1};
            int[] dy = {1,0,-1,0};

            for(int i =0;i<dx.length;i++) {
                int newx = row + dx[i];
                int newy = col + dy[i];

                //check newx newy in matrix
                if (newx >= 0 && newy >= 0 && newx < n && newy < m) {
                    // Effort can be calculated as the max value of differences
                    // between the heights of the node and its adjacent nodes.
                    int newEffort =
                            Math.max(
                                    Math.abs(heights[newx][newy] - heights[row][col]), diffDist);

                    int diff = Math.abs(heights[newx][newy] - heights[row][col]);
                    //if diff is < older distdiff then update in dist matrix
                    if (dist[newx][newy] > newEffort) {
                        dist[newx][newy] = newEffort;
                        //push to pq
                        pq.add(new Tuple(newEffort, newx, newy));
                    }
                }
            }
        }

        //if dest unrechable
        return 0;
    }


    public static void main(String[] args) {

        Graph_Class6_4_LC1631_PathWithMinEffort gcnop = new Graph_Class6_4_LC1631_PathWithMinEffort();
       int[][] heights = {{1,2,3},{3,8,4},{5,3,5}};
        //int[][] heights = {{3}} ;
        //int[][] heights = {{1,10,6,7,9,10,4,9}};
        int minimumEffortPath = gcnop.minimumEffortPath(heights);
        System.out.println((minimumEffortPath));
    }
}

/*
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 */