package com.kas.dsasupreme.extra_classes;

class ClimbingStairsdp {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
		
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++){
        	dp[i] =-1;
        }
        for(int i=0;i<=n;i++){
        	System.out.println(dp[i]);
        }
        
        int ans =  Math.min(solve2(cost,n-1,dp),solve2(cost,n-2,dp));
        return ans;
    }
    
    private static int solve2(int[] cost, int n, int[] dp) {
		// TODO Auto-generated method stub
    	if(n == 0) return cost[0];
    	if(n==1) return cost[1];
    	
    	if(dp[n] != -1) return dp[n];
    	
    	dp[n] = cost[n] +Math.min(solve2(cost,n-1,dp),solve2(cost,n-1,dp));
		return dp[n];
	}

	public static void main(String[] args) {
    	int[] cost = {10,15,20};
    	int rs = minCostClimbingStairs(cost);
    	System.out.println("min cost"+rs);
	}
}