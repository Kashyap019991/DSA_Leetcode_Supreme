package com.kas.practice_javadsa;
class MaxScore {
    public int maxScore(int[] cardPoints, int k) {
        int n =cardPoints.length;
        int maxScore=0;
        int[] front = new int[k+1];
        int[] rear = new int[k+1];

        for(int i=0;i<k;i++){
            front[i+1] = front[i] + cardPoints[i];
            rear[i+1] = rear[i] + cardPoints[n-i-1]; 
        }

        for(int i=0;i<=k;i++){
            maxScore = Math.max(maxScore, front[i] + rear[k-i]);
        }
        return maxScore;
    }
    
    public static void main(String[] args) {
		MaxScore sl = new MaxScore();
		int[] cardPoints = {9,7,7,9,7,7,9}; int k = 7;
		System.out.println(sl.maxScore(cardPoints, k));
	}
}