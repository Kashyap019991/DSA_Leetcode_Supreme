package com.kas.practice_javadsa;

import java.util.Arrays;
import java.util.*;
class SlideWindow {
	 LinkedList<Integer> slideWindow;

	    public SlideWindow() {
	        this.slideWindow = new LinkedList<Integer>();
	    }

	    public int ping(int t) {
	        // step 1). append the current call
	        this.slideWindow.addLast(t);

	        // step 2). invalidate the outdated pings
	        while (this.slideWindow.getFirst() < t - 3000)
	            this.slideWindow.removeFirst();

	        return this.slideWindow.size();
	    }
	    
	    
	    public static void main(String[] args) {
			//["RecentCounter","ping","ping","ping","ping"]
	    	//[[],[1],[100],[3001],[3002]]
	    	
	    	SlideWindow sl = new SlideWindow();
	    	sl.ping(1);
	    	sl.ping(100);
	    	sl.ping(3001);
	    	sl.ping(3002);
		}
}