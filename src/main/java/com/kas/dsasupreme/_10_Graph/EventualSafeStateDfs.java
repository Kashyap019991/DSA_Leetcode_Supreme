package com.kas.dsasupreme._10_Graph;
import java.util.*;
enum State { kInit, kVisiting, kVisited }

class EventualSafeStateDfs {
  public List<Integer> eventualSafeNodes(int[][] graph) {
    List<Integer> ans = new ArrayList<>();
    State[] states = new State[graph.length];

    for (int i = 0; i < graph.length; ++i)
      if (!hasCycle(graph, i, states))
        ans.add(i);

    return ans;
  }

  private boolean hasCycle(int[][] graph, int u, State[] states) {
    if (states[u] == State.kVisiting)
      return true;
    if (states[u] == State.kVisited)
      return false;

    states[u] = State.kVisiting;
    for (final int v : graph[u])
      if (hasCycle(graph, v, states))
        return true;
    states[u] = State.kVisited;

    return false;
  }

  public static void main(String[] args) {
    int[][] graph = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
    EventualSafeStateDfs evn = new EventualSafeStateDfs();
    System.out.println(evn.eventualSafeNodes(graph));
  }
}