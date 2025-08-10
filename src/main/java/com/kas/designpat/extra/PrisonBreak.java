package com.kas.designpat.extra;
public class PrisonBreak {
	//Write your code here
	
	/*long breakPrison(int n, int m,List<Integer> H,List<Integer> V,int x,int y)
	{
    vector<bool> xs(n + 1), ys(m + 1);
	for (int h : H) xs[h] = true;
	for (int v : V) ys[v] = true;
	int xm = 0, ym = 0;
	for (int i = 1, j = 0; i <= n; i++) {
		if (not xs[i]) j = 0;
		else xm = max(xm, ++j);
	}
	for (int i = 1, j = 0; i <= m; i++) {
		if (not ys[i]) j = 0;
		else ym = max(ym, ++j);
	}
	return (long int)(xm + 1) * (ym + 1);
	
}*/
  public static void main(String[] args) {
    int[] arr = {7,1,6,0};
    int n = arr.length, k = 7;

    System.out.println("Length of the longest subarray with sum K is " + 
    longestSubArrWithSumK_Optimal(arr, n, k));
  }

  public static int longestSubArrWithSumK_Optimal(int[] arr, int n, int k) {
    int start = 0, end = -1, sum = 0, maxLength = 0;
    while (start < n) {
      while ((end + 1 < n) && (sum + arr[end + 1] <= k))
        sum += arr[++end];

      if (sum == k)
        maxLength = Math.max(maxLength, (end - start + 1));

      sum -= arr[start];
      start++;
    }
    return maxLength;
  }

}