package com.kas.practice_javadsa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet<String>(Arrays.asList(deadends));
        

        if(deadendsSet.contains("0000"))
            return -1;
        if(target.equals("0000"))
            return 0;//already we are at target

        Queue<String> pendingVisit = new LinkedList<>();
        //deadendsSet.add("0000");
        pendingVisit.add("0000");
        int steps = 0;
        while(!pendingVisit.isEmpty()){
            
            ++steps;

            for(int sz=pendingVisit.size();sz>0;--sz){
                StringBuilder currPath = new StringBuilder(pendingVisit.poll());
            //visit all 4 digits of StringBuilder
                for(int i=0;i<4;i++){ 

                    final char currChar = currPath.charAt(i);
                    //increase by 1
                    //currPath.setCharAt(i, (currChar == '9') ?'0': (char)currChar +1);
                    currPath.setCharAt(i, currPath.charAt(i) == '9' ? '0' : (char) (currPath.charAt(i)+1));
                    if(currPath.toString().equals(target)){
                        return steps;
                    }

                    if(!deadendsSet.contains(currPath.toString())){
                        deadendsSet.add(String.valueOf(currPath));
                        pendingVisit.add(String.valueOf(currPath));
                        
                    }
                    
                    //make same as is currPath
                    currPath.setCharAt(i, currChar);

                    //decrease by 1
                    currPath.setCharAt(i, currPath.charAt(i) == '0'? '9': (char)(currPath.charAt(i)-1));

                    if(currPath.toString().equals(target)){
                        return steps;
                    }

                    if(!deadendsSet.contains(currPath.toString())){
                        //deadendsSet.add(currPath);
                        pendingVisit.add(String.valueOf(currPath));
                        deadendsSet.add(String.valueOf(currPath));
                    }
                    
                    //make same as is currPath
                    currPath.setCharAt(i, currChar);
                    
                }
            }
            
        }

        return  -1;
    }
    
    public static void main(String[] args) {
    	String[] deadends = {"0201","0101","0102","1212","2002"};String target = "0202";
    	OpenLock sl3= new OpenLock();
    	Set<String> ss = new HashSet<String>();
    	StringBuilder currPath = new StringBuilder("0000");
    	ss.add(currPath.toString());
    	//System.out.println(ss.contains(0000));
    	System.out.println(sl3.openLock(deadends, target));
	}
}