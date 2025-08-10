package com.kas.designpat.extra;
import java.util.*;
public class anagramGroup {
 
    static class Pair1 {
        String x;
        int y;
        public Pair1(String x, int y)
        {
            this.x = x;
            this.y = y;
        }
       /* public int compareTo(Pair o)
        {
            return this.x.compareTo(o.x);
        }*/
    }
    static ArrayList<Pair1>
    createDuplicateArray(String[] wordArr, int size)
    {
        ArrayList<Pair1> dupArray = new ArrayList<Pair1>();
        for (int i = 0; i < size; i++) {
            Pair1 p = new Pair1(wordArr[i], i);
            dupArray.add(p);
           
            // pair.first contains the input words and
            // pair.second contains its index
        }
        return dupArray;
    }
    static void printAnagramsTogether(String[] wordArr,
                                      int size)
    {
 
        ArrayList<Pair1> dupArray = new ArrayList<Pair1>();
       
        ; // dupArray to store the word-index pair
        dupArray = createDuplicateArray(
            wordArr, size); // making copy of all the words
                            // and their respective index
 
        // Iterate through all words in dupArray and sort
        // characters in each word.
        for (int i = 0; i < size; ++i) {
            Pair1 e = dupArray.get(i);
            char[] arr = e.x.toCharArray();
            Arrays.sort(arr);
            String x = String.valueOf(arr);
            Pair1 p = new Pair1(x, e.y);
            dupArray.set(i, p);
        }
       
        // now sort the whole vector to get the identical
        // words together
        Collections.sort(dupArray, new Comparator<Pair1>() {
        	@Override
        	public int compare(Pair1 o1, Pair1 o2) {
        		// TODO Auto-generated method stub
        		return o1.x.compareTo(o2.x);
        	}
        });
      /*  dupArray.sort(new Comparator<Pair>() {
        	@Override
        	public int compare(Pair o1, Pair o2) {
        		// TODO Auto-generated method stub
        		return Integer.parseInt(o1.x -o2.x);
        	}
		});*/
       
        // now all the identical words are together but we
        // have lost the original form of string so through
        // index stored in the word-index pair fetch the
        // original word from main input
        for (int i = 0; i < size; ++i)
            System.out.print(wordArr[dupArray.get(i).y]
                             + " ");
    }
 
    public static void main(String[] args)
    {
        String[] wordArr
            = { "cat", "dog", "tac", "god", "act" };
        printAnagramsTogether(wordArr, wordArr.length);
    }
}