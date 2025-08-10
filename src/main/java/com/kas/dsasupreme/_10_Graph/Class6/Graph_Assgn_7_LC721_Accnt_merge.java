package com.kas.dsasupreme._10_Graph.Class6;

import java.util.*;

class Graph_Assgn_7_LC721_Accnt_merge {

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
	    //make map which contains email,index of belonging String list
		//for ex: 
		//0-> ["john", j1,j2,j3]  covert to j1 ->0,j2->0,j3->0
		//1-> ["john", j4] --> convert to j4 -> 1
		//2 -> ["raj", r1,r2] -->convert r1 ->2, r2 ->2
		//3-> ["john", j1,j5]  --> convert j1 ->3 here j1 already in map so call unionset func with 3 and 0  , for j5 also 
		//4 -> ["raj", r2,r3] --> convert r2 -> 4 (r2 have already an entry) call union set func 
		//5-> ["mary", m1] -->  convert m1 -> 5
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for(int i = 0; i< accounts.size(); i++){
			for(int j = 1; j< accounts.get(i).size();j++){
				String currMail = accounts.get(i).get(j);
				if(!hm.containsKey(currMail)){
					hm.put(currMail, i);
				}
				else{
					unionByRank(i, hm.get(currMail));
				}
			}
		}
		return null;
	}
    static List<Integer> rank = new ArrayList<Integer>();
	static List<Integer> parent = new ArrayList<Integer>();
	
	int findPar(int u){
		
		if(parent.get(u) == u){
			return u;//reached to ultimate parent
		}
		else
			{
			int uPar = findPar(parent.get(u));
			parent.add(u, uPar);
			return uPar;
			}
		
	}
	
    void unionByRank(int u , int v){
    	int uPar = findPar(u);
    	int vPar = findPar(v);
    	
    	if(uPar != vPar){
    		if(rank.get(uPar) <= rank.get(vPar))
    			{
    			parent.add(uPar,vPar);
    			}
    		else if(rank.get(uPar) > rank.get(vPar))
    			{
    			parent.add(vPar, uPar); //both will be at same level
    			}
    		else{
    			parent.add(vPar,uPar);
    			int ra = rank.get(uPar);
    			rank.add(uPar,++ra);

    		}
    		
    	}
    	
	}
    public static void main(String[] args) {
    	
    	
    	
    	//init ranks by 0
	List<List<String>> ls  = new ArrayList(){
		{       
		    	add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j2@com", "j3@com")));
		        add(new ArrayList<String>(Arrays.asList("John", "j4@com")));
		        add(new ArrayList<String>(Arrays.asList("Raj", "r1@com", "r2@com")));
		        add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j5@com")));
		        add(new ArrayList<String>(Arrays.asList("Raj", "r2@com", "r3@com")));
		        add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));
		}
	};
	
	for(int i=0;i<ls.size();i++){
		rank.add(i,0);
	}

 }
}