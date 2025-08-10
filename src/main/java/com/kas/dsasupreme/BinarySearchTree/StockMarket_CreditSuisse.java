
package com.kas.dsasupreme.BinarySearchTree;


import java.io.*;


public class StockMarket_CreditSuisse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
            	A[i_A] = Integer.parseInt(arr_A[i_A]);
            }
            int K = Integer.parseInt(br.readLine().trim());
 
            long out_ = solve(N, A, K);
            System.out.println(out_);
            
         }
 
         wr.close();
         br.close();
    }
 
    static final long INVALID = -10_000_000_000_010L;
    static int[] A;
    static int N, K;
    static long[][] memo = new long[10_010][110];
    static long pd(){
        for(int i = N-1; i >= 0; i--){
            for(int k = K-1; k >= 0; k--){
                final long cost = (k % 2 == 0) ? -A[i] : A[i];
                if(i == N-1){
                    if(k == K-1){
                        memo[i][k] = cost;                     
                    }
                    else {
                        memo[i][k] = INVALID;
                    }
                    continue;
                }
                
                if(k == K-1){
                    memo[i][k] = memo[i+1][k] + cost;
                    continue;
                }
                
                final long pd1 = memo[i+1][k];
                final long pd2 = memo[i+1][k+1];
                if(pd1 == INVALID && pd2 == INVALID){
                    memo[i][k] = INVALID;
                    continue;
                }
                if(pd1 == INVALID){
                    memo[i][k] = pd2 + cost;
                    continue;
                }
                if(pd2 == INVALID){
                    memo[i][k] = pd1 + cost;
                    continue;
                }
                memo[i][k] = Math.max(pd1,pd2) + cost;
            }
        }        
        return memo[0][0];
    }
 
    static long solve(int N, int[] A, int K){       
        StockMarket_CreditSuisse.N = N;
        StockMarket_CreditSuisse.A = A;
        StockMarket_CreditSuisse.K = K;
 
        return pd();
    }
}


