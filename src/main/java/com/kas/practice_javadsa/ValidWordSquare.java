package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.List;

class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        int numRow = words.size();
        //int numcol = words[0].length();
        List<StringBuilder> extractedCols = new ArrayList<StringBuilder>();
        
       // int i=0;
        for(String word:words){
            int i=0;
            for(char ch:word.toCharArray())
            {
                if(i>=extractedCols.size()){
                    extractedCols.add(i,new StringBuilder().append(ch));
                }
                else{
                    StringBuilder sb =extractedCols.get(i).append(ch);
                    extractedCols.set(i,sb);
                }
                i++;
            }
            i=0;
        }

        for(int i=0;i<numRow;i++){
            if(!words.get(i).equals(extractedCols.get(i).toString())){
                return false;
            }
        }
        return true;
            
    }
    public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("ball");
		words.add("area");
		words.add("read");
		words.add("lady");
		DecodeString sl = new DecodeString();
		sl.validWordSquare(words);
		//words = ["ball","area","read","lady"]
	}
}