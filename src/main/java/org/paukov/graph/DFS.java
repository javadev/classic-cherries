package org.paukov.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dpaukov on 5/3/18.
 */
public class DFS<T> {

    final Graph<T> graph;
    final List<Node<T>> result;

    DFS(Graph<T> graph) {
        this.graph = graph;
        this.result = new ArrayList<>();
    }

    public static <T> List<Node<T>> dfsOf(Graph<T> graph, int root) {
        DFS<T> dfs = new DFS<>(graph);
        dfs.run(root);
        return dfs.result;
    }

    void run(int root) {
        assert root < graph.nodes.size();
        graph.nodes.get(root).discovered = true;
        processNodeBefore(root, graph.nodes.get(root));

        for (Integer child : graph.edges[root]) {
            if (!graph.nodes.get(child).discovered) {
                graph.nodes.get(child).discovered = true;
                graph.nodes.get(child).parent = graph.nodes.get(root);
                processEdge(root, child);
                run(child);
            } else {
                processEdge(root, child);
            }
        }

        processNodeAfter(root, graph.nodes.get(root));
        graph.nodes.get(root).processed = true;
    }


    void processNodeBefore(int index, Node<T> node) {
        System.out.println("DFS Process node: " + index);
        result.add(node);
    }

    void processEdge(int from, int to) {
        System.out.println("DFS Process edge from: " + from + " to: " + to);
    }

    void processNodeAfter(int index, Node<T> node) {
        // do nothing here.
    }
}
