package com.kas.practice_javadsa;
import java.util.*;

class CourseRead2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int[] pre : prerequisites) {
            adj.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }
        
        for (int key : adj.keySet()) {
            for (int node : adj.get(key)) {
                inDegree[node]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            if (adj.containsKey(node)) {
                for (int ngbr : adj.get(node)) {
                    inDegree[ngbr]--;
                    if (inDegree[ngbr] == 0) {
                        q.offer(ngbr);
                    }
                }
            }
        }
        
        Collections.reverse(ans);
        if (ans.size() == numCourses) {
            return ans.stream().mapToInt(i -> i).toArray();
        }
        return new int[0];
    }
    
    public static void main(String[] args) {
		
	
    
    CourseRead2 sl = new CourseRead2();
    int numCourses =2;
    int[][] prereq = {{1,0}};
    sl.findOrder(numCourses, prereq);

    }
    }