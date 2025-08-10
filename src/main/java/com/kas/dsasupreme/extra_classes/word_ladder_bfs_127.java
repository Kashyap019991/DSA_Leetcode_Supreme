package com.kas.dsasupreme.extra_classes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class word_ladder_bfs_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord)){
            return 0;
        }

        Queue<String> wQueue= new LinkedList();
        wQueue.add(beginWord);
        int distance=1;

        while(!wQueue.isEmpty()){
            int size = wQueue.size();

            //process each word in curr level
            for(int i=0;i<size;i++){
                String currWord = wQueue.poll();

                if(currWord.equals(endWord))
                    return distance;
                
                //try changing each character in curr word
                for(int j=0;j<currWord.length();j++){
                    char[] temp= currWord.toCharArray();
                    
                    for(char c='a';c<='z';c++){
                        temp[j] = c;
                        String newWord = new String(temp);

                        //if New word in word set, add it to queue
                        if(wordSet.contains(newWord)){
                            wQueue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
          //increment dist after curr level
          distance++;  
        }
        return 0;//if no seq leads to endWord
    }
}