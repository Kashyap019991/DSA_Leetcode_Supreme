package com.kas.practice_javadsa;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class OpenLock1{
  public int openLock(String[] deadends, String target) {
    Set<String> seen = new HashSet<>(Arrays.asList(deadends));
    if (seen.contains("0000"))
      return -1;
    if (target.equals("0000"))
      return 0;

    int ans = 0;
    Queue<String> q = new ArrayDeque<>(Arrays.asList("0000"));

    while (!q.isEmpty()) {
      ++ans;
      for (int sz = q.size(); sz > 0; --sz) {
        StringBuilder sb = new StringBuilder(q.poll());
        for (int i = 0; i < 4; ++i) {
          final char cache = sb.charAt(i);
          // Increase the i-th digit by 1.
          sb.setCharAt(i, sb.charAt(i) == '9' ? '0' : (char) (sb.charAt(i) + 1));
          String word = sb.toString();
          if (word.equals(target))
            return ans;
          if (!seen.contains(word)) {
            q.offer(word);
            seen.add(word);
          }
          sb.setCharAt(i, cache);
          // Decrease the i-th digit by 1.
          sb.setCharAt(i, sb.charAt(i) == '0' ? '9' : (char) (sb.charAt(i) - 1));
          word = sb.toString();
          if (word.equals(target))
            return ans;
          if (!seen.contains(word)) {
            q.offer(word);
            seen.add(word);
          }
          sb.setCharAt(i, cache);
        }
      }
    }

    return -1;
  }
  
  public static void main(String[] args) {
  	String[] deadends = {"0201","0101","0102","1212","2002"};String target = "0202";
  	DecodeString sl3= new DecodeString();
  	System.out.println(sl3.openLock(deadends, target));
	}
}