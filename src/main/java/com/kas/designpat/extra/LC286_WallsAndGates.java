package com.kas.designpat.extra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LC286_WallsAndGates {
    public static final int GATE =0;
    public static final int WALL=-1;
    public static final int EMPTY = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        int row = rooms.length;
        int cols = rooms[0].length;
        Queue<int[]> q = new LinkedList<int[]>();
        //find GATE
        for(int i=0;i<row;i++){
            for(int j=0;j<cols;j++){
                if(rooms[i][j] == GATE)
                    q.add(new int[]{i,j});
            }
        }
while(!q.isEmpty()){
        List<int[]> DIRECTIONS = Arrays.asList(new int[]{0,1},
        new int[]{0,-1},
        new int[]{1,0},
        new int[]{-1,0});
        int[] rc = q.poll();

    
        int r = rc[0];
        int c = rc[1];

        for(int[] dir:DIRECTIONS){
            int newr = r + dir[0];
            int newc = c  + dir[1];

            if(newr <0 || newc < 0 || newr >= row || newc >= cols || rooms[newr][newc] != EMPTY){
                continue;
            }
            rooms[newr][newc] = rooms[r][c] +1;
            q.add(new int[]{newr,newc});
        }

    }

    }
}