package org.paukov.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dpaukov on 5/3/18.
 */
public class BFS<T> {

  final Graph<T> graph;
  final List<Node<T>> result;

  BFS(Graph<T> graph) {
    this.graph = graph;
    this.result = new ArrayList<>();
  }

  public static <T> List<Node<T>> bfsOf(Graph<T> graph, int root) {
    BFS<T> bfs = new BFS<>(graph);
    bfs.run(root);
    return bfs.result;
  }

  void run(int root) {
    assert root < graph.nodes.size();
    graph.nodes.get(root).discovered = true;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int node = queue.remove();
      graph.nodes.get(node).processed = true;
      processNodeBefore(node, graph.nodes.get(node));
      for (Integer child : graph.edges[node]) {
        processEdge(node, child);
        if (!graph.nodes.get(child).discovered) {
          queue.add(child);
          graph.nodes.get(child).discovered = true;
          graph.nodes.get(child).parent = graph.nodes.get(node);
        }
      }
      processNodeAfter(node, graph.nodes.get(node));
    }
  }


  void processNodeBefore(int index, Node<T> node) {
    System.out.println("BFS Process node: " + index);
    result.add(node);
  }

  void processEdge(int from, int to) {
    System.out.println("BFS Process edge from: " + from + " to: " + to);
  }

  void processNodeAfter(int index, Node<T> node) {
    // do nothing here.
  }
}
