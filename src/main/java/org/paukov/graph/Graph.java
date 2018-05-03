package org.paukov.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dpaukov on 5/3/18.
 */
public class Graph<T> {

    final List<Node<T>> nodes;
    final List<Integer>[] edges;
    final boolean directed;
    int time = 0;

    @SafeVarargs
    public Graph(boolean directed, Node<T> ... nodes) {
        this.directed = directed;
        this.nodes = new ArrayList<>();
        Collections.addAll(this.nodes, nodes);
        this.edges = new List[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            this.edges[i] = new ArrayList<>();
        }
    }

    public Graph(boolean directed, List<Node<T>> nodes) {
        this.directed = directed;
        this.nodes = nodes;
        this.edges = new List[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            this.edges[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to) {
        assert from < nodes.size();
        assert to < nodes.size();
        if (directed){
            this.edges[from].add(to);
        } else {
            this.edges[from].add(to);
            this.edges[to].add(from);
        }
    }
}
