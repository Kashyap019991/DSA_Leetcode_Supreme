package com.kas.practice_javadsa;
class WaterMaxArea {
    public int maxArea(int[] height) {
       int left =0, right=height.length-1;
        int maxHeight = 0;
       while(left < right){

        maxHeight = Math.max(maxHeight,(right- left)* Math.min(height[left] , height[right]) );

        if(height[left] < height[right])
            left++;
        else
            right--;
        }
        

       return maxHeight;
    }
    
    public static void main(String[] args) {
	
    	
    	int[] ht = {1,8,6,2,5,4,8,3,7}; 
    	WaterMaxArea sl = new WaterMaxArea();
    	System.out.println(sl.maxArea(ht));
	}
}