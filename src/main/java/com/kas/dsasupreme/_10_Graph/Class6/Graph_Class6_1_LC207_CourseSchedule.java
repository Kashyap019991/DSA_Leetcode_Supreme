package com.kas.dsasupreme._10_Graph.Class6;

import java.util.*;

class Graph_Class6_1_LC207_CourseSchedule {


    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites.length == 0)
            return true;
        Boolean ans = false;
        //prepare indegree list for each node
        Map<Integer, List<Integer>> indegreeMap = new HashMap<>();
//[1,0][2,0]
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0]; //1
            int v = prerequisites[i][1]; //0
            ///to find indegree of each node each v , u -> v
            //now for 1-> 0 ,2->0, indegree of 0 ->1,2
            if (indegreeMap.get(v) == null) {
                indegreeMap.put(v, new ArrayList<>(Arrays.asList(new Integer[]{u})));
            } else {
                indegreeMap.get(v).add(u);
            }
        }

        //calculate indegree of v i.e. for 0 --> 2 as (0 ->1,2)
        Map<Integer, Integer> indegreeCount = new HashMap<>();
        //Initialize all node count with 0
        for (Map.Entry<Integer, List<Integer>> e : indegreeMap.entrySet()) {
            List<Integer> nbrs = e.getValue();
            if (nbrs != null) {
                for (int nbr = 0; nbr < nbrs.size(); nbr++) {
                    if (indegreeCount.containsKey(nbrs.get(nbr)))
                        indegreeCount.put(nbrs.get(nbr), indegreeCount.get(nbrs.get(nbr)) + 1);
                    else
                        indegreeCount.put(nbrs.get(nbr), 1);
                }


            }
        }


        //put all nodes in QUeue which has indegree =0, means least dependent
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegreeCount.get(i) == null)
                q.add(i);
            else if (indegreeCount.get(i) == 0) {
                q.add(i);
            }

        }
        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int fnode = q.poll();
            topo.add(fnode);
            if (indegreeMap.get(fnode) != null) {
                for (int nbr : indegreeMap.get(fnode)) {
                    int count = indegreeCount.get(nbr) - 1;
                    indegreeCount.put(nbr, count);
                    if (count == 0) {
                        q.add(nbr);
                    }
                }
            }
        }


        if (topo.size() == numCourses) {
            return true;
        } else
            return false;
    }


    public static void main(String[] args) {
       /* int numCourses = 2;
        int[][] prerequisites = {{1, 0},{2,1},{2,0}}*/
        ;
       /* int numCourses = 1;
        int[][] prerequisites = {};*/
       /* int numCourses = 2;
        int[][] prerequisites = {{0,1}};*/
        int numCourses = 20;
        int[][] prerequisites = {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
        //To take course 1 you should have finished course 0.  1 -> 0
        Graph_Class6_1_LC207_CourseSchedule gcnop = new Graph_Class6_1_LC207_CourseSchedule();
        Boolean ans = gcnop.canFinish(numCourses, prerequisites);
        System.out.println(ans);
    }
}