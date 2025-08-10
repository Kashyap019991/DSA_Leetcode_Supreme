package com.kas.dsasupreme._10_Graph.Class6;
//https://takeuforward.org/graph/word-ladder-i-g-29/
import java.util.*;


class Pair{
    String word;
    int steps;

    Pair(String word, int steps){
        this.word = word;
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return steps == pair.steps && Objects.equals(word, pair.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, steps);
    }
}

class Graph_Class6_3_LC127_WordLadder {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //Copy wordList to Set
        Set<String> st = new HashSet<>();
        for(String word:wordList){
            st.add(word);
        }

        //create pair od beginword with start step as 1 bcoz need to count no. of changes done
        // to reach endWord & insert in QUeue to perform bfs

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        st.remove(beginWord);
        //perform bfs
        while(!q.isEmpty()){
            Pair fnode = q.poll();
            String word = fnode.word;
            int steps= fnode.steps;

            if(word.equals(endWord))
                return steps;
            //iterate each letter of word from a to z and check if its available in set
            // if its in set then add to Q and remove form set so that we can't revisit

            for(int i = 0; i< word.length();i++){
                for(char ch ='a'; ch<='z';ch++){
                    char[] replacedWord = word.toCharArray();
                    replacedWord[i] = ch;
                    String replacedStr = new String(replacedWord);
                    if(st.contains(replacedStr)){
                        st.remove(replacedStr);
                        q.add(new Pair(replacedStr, steps +1));
                    }
                }
            }

        }

        //If there is no transformation seq available
        return 0;
    }


    public static void main(String[] args) {

        Graph_Class6_3_LC127_WordLadder gcnop = new Graph_Class6_3_LC127_WordLadder();
        /*String beginWord = "hit";
        String endWord = "cog";*/
        String beginWord = "ymain";
        String endWord = "oecij";
        List<String> wordList = Arrays.asList(new String[]
                {"ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain"});

        int noOfSteps = gcnop.ladderLength(beginWord, endWord, wordList);
        System.out.println((noOfSteps));
    }
}

/*
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 */