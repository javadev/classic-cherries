package org.paukov.graph;

import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by dpaukov on 5/3/18.
 */
public class BFSTest {
    @Test
    public void bfsOf() throws Exception {
        Node<String> node0 = new Node<>("0");
        Node<String> node1 = new Node<>("1");
        Node<String> node2 = new Node<>("2");
        Node<String> node3 = new Node<>("3");
        Node<String> node4 = new Node<>("4");
        Node<String> node5 = new Node<>("5");

        Graph<String> graph = new Graph<>(false, node0, node1, node2, node3, node4, node5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        List<Node<String>> bsfTraversalNodes = BFS.bfsOf(graph, 0);
        assertThat(bsfTraversalNodes).containsExactly(node0, node1, node4, node5, node2, node3);
    }

}