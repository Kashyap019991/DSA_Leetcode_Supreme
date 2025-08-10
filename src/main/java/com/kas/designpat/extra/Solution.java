package com.kas.designpat.extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<int[]> currIsland = new ArrayList();
    List<List<int[]>> allIsland = new ArrayList();
    Boolean[][] seen; 
    int rows;
    int cols;
        public int numDistinctIslands(int[][] grid) {
        
        /*
            00  01   --> 00 01  row=0

            10  11       10  11

            0

            23 24    -->  00  01
            33 34         10  11  row=2

            mincol =3

        */
        this.rows = grid.length;
        this.cols= grid[0].length;
        this.seen = new Boolean[rows][cols];
        //for(int row=0;row<rows;row++)
            Arrays.stream(seen).forEach(a->Arrays.fill(a,false));
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                //iterate dfs
                dfs(grid,r,c);

                //make similar island
                int minCol = Integer.MAX_VALUE;
                for(int row=0;row<currIsland.size();row++){
                    minCol = Math.min(minCol,currIsland.get(row)[1]);
                }
/*
                for(int row=0;row<currIsland.size();row++){
                    int[] e = currIsland.get(row);
                    currIsland.remove(row);
                    e[0] -= e[0];
                    e[1] = e[1]- minCol;
                    currIsland.add(e);
                }
*/
                for(int[] cell:currIsland){
                    cell[0] -= r;
                    cell[1] -= minCol;
                }
                if(isCurrIslandUique(currIsland) && !currIsland.isEmpty()){
                    allIsland.add(currIsland);
                }
                //make it empty

                currIsland = new ArrayList();

            }

           
        }

       return allIsland.size();
    }

      public Boolean isCurrIslandUique(List<int[]> currIsland1){
            
    	  for(List<int[]> currIslandFromAll: allIsland){
                if(currIslandFromAll.size() != currIsland1.size())
                    continue;
                
                if(matchData(currIslandFromAll,currIsland1)){//matching then not add 
                    return false;
                }

            }
            return true;
        }

        public Boolean matchData(List<int[]> c1,List<int[]> c2){

            for(int r=0;r<c1.size();r++){
                //int[] a = c1.get(r);
                for(int c=0;c<c1.get(r).length;c++){
                    if(c1.get(r)[c] != c2.get(r)[c])
                        return false;
                }
            }
            return true;
        }
        public void dfs(int[][] grid ,int r, int c){
            if(grid[r][c] == 0 || seen[r][c] == true) return;
            seen[r][c] = true;
            currIsland.add(new int[]{r,c});
            if(r-1>=0) dfs(grid,r-1,c);
            if(c-1>=0) dfs(grid,r,c-1);
            if(r+1< rows) dfs(grid,r+1,c);
            if(c+1<cols) dfs(grid,r,c+1);
        }
        
        public static void main(String[] args) {
		int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		//	int[][] grid = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
			Solution s = new Solution();
			System.out.println(s.numDistinctIslands(grid));
		}
}