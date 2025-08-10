package com.kas.practice_javadsa;
class wg {
    public static final int GATE =0;
    public static final int WALL=-1;
    public static final int EMPTY = Integer.MAX_VALUE;
    int n;
    int m;
    public void wallsAndGates(int[][] rooms) {
         n=rooms.length;
         m = rooms[0].length;
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(rooms[r][c] == GATE){
                	
                    dfs(r,c,rooms);
                }
            }
        }

    }
    public void dfs(int r,int c,int[][] rooms){
       int dir_hor[] = {0,1,-1,0};
       int dir_ver[] = {1,0,0,-1};

       for(int dir=0;dir<4;dir++) {
    	   
    	   int newr = r + dir_hor[dir];
    	   int newc = c + dir_ver[dir];
    	   
    	   if(newr >=0 && newc >=0 && newr < n && newc <m && rooms[newr][newc] > rooms[r][c]+1) {
    		   rooms[newr][newc] = rooms[r][c] +1;
    		   dfs(newr,newc,rooms);
    	   }
       }
    	
    }
    public static void main(String[] args) {
		int[][] rooms = {{2147483647,-1,0,2147483647},
						{2147483647,2147483647,2147483647,-1},
						{2147483647,-1,2147483647,-1},
						{0,-1,2147483647,2147483647}};
		wg s = new wg();
		s.wallsAndGates(rooms);
		for(int i=0;i<s.n;i++) {
			for(int j=0;j<s.m;j++) {
				System.out.print(rooms[i][j] + " ");
			}
			System.out.println();
		}
	}
}