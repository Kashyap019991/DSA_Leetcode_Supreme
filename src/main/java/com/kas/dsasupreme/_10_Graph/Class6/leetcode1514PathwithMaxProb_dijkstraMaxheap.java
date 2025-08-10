package com.kas.dsasupreme._10_Graph.Class6;

import javafx.util.Pair;

import java.util.*;

class PairProb {
    int dst;
    double prob;

    PairProb(int d, double prob) {
        this.dst = d;
        this.prob = prob;
    }
}

//neetcode io https://www.youtube.com/watch?v=kPsDTGcrzGM
class leetcode1514PathwithMaxProb_dijkstraMaxheap {
    /*public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Pair<Integer, Double>>[] graph = new List[n]; // {a: [(b, prob_ab)]}
        // (prob to reach u, u)
        Queue<Pair<Double, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> Double.compare(b.getKey(), a.getKey()));
        maxHeap.offer(new Pair<>(1.0, start));
        boolean[] seen = new boolean[n];

        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; ++i) {
            final int u = edges[i][0];
            final int v = edges[i][1];
            final double prob = succProb[i];
            graph[u].add(new Pair<>(v, prob));
            graph[v].add(new Pair<>(u, prob));
        }

        while (!maxHeap.isEmpty()) {
            final double prob = maxHeap.peek().getKey();
            final int u = maxHeap.poll().getValue();
            if (u == end)
                return prob;
            if (seen[u])
                continue;
            seen[u] = true;
            for (Pair<Integer, Double> node : graph[u]) {
                final int nextNode = node.getKey();
                final double edgeProb = node.getValue();
                if (seen[nextNode])
                    continue;
                maxHeap.add(new Pair<>(prob * edgeProb, nextNode));
            }
        }

        return 0;
    }*/
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        //create adjlist src -> dst,prob & dst -> src, prob bcoz undirected graph
        Map<Integer, List<PairProb>> adjList = new HashMap<Integer, List<PairProb>>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new PairProb(edge[1], succProb[i]));
            //undirected graph so need to add dst to src also
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new PairProb(edge[0], succProb[i]));
        }

        //create MaxHeap priority qeueue
        PriorityQueue<PairProb> pq = new PriorityQueue<PairProb>((x, y) -> Double.compare(y.prob, x.prob));

        pq.add(new PairProb(start_node, 1.0));

        double[] prob = new double[n];
        Arrays.fill(prob, Integer.MIN_VALUE);

        while (!pq.isEmpty()) {
            PairProb fnode = pq.poll();
            int dst = fnode.dst;
            double currProb = fnode.prob;

            if (dst == end_node)
                return currProb;

            //iterate
            if (adjList.containsKey(dst)) {
                for (PairProb nbr : adjList.get(dst)) {

                    //calc prob with new path
                    double newProb = currProb * nbr.prob;
                    if (prob[nbr.dst] < newProb) {
                        //replace new prob in array
                        prob[nbr.dst] = newProb;
                        //push into pq
                        pq.add(new PairProb(nbr.dst, newProb));
                    }
                }
            }

        }


        return 0;
    }

    public static void main(String[] args) {
       /* int n =3;//no. of nodes
        int[][] edges = {{0,1},{0,2},{1,2}};
        double[] succProb = {0.5,0.2,0.5};
        int start = 0;
        int end =2;*/

        int n = 500;//no. of nodes
        int[][] edges = {{193, 229}, {133, 212}, {224, 465}};
        double[] succProb = {0.91, 0.78, 0.645};
        int start = 4;
        int end = 364;
        System.out.println(maxProbability(n, edges, succProb, start, end));
    }

}