package com.kas.dsasupreme.extra_classes;

class CourceSched2LC210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDeg = new int[numCourses];


        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;

        for(int i=0;i<m;i++){

            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree = new int[numCourses];

        for(int i=0;i< numCourses;i++){
            for(int itr:adj.get(i))
            {
                indegree[itr]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();

            int[] topo = new int[numCourses];
            int ind=0;

            for(int i=0;i<numCourses;i++){
                if(indegree[i] ==0)
                    q.add(i);
            }

    

            while(!q.isEmpty())
            {
                int node = q.poll();
                topo[ind++] = node;

                for(int itr:adj.get(node)){
                    indegree[itr]--;
                    if(indegree[itr]==0)
                        q.add(itr);
                }
            }
            if(numCourses == ind) return topo;
            int[] res={};
            return res;
    }
}