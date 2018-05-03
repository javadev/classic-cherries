package org.paukov.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by dpaukov on 4/7/18.
 */
public class GraphExTest {
    @Test
    public void bfs() throws Exception {
        GraphEx graph = new GraphEx(6);
        graph.addBiDirectedEdge(0, 1);
        graph.addBiDirectedEdge(0, 4);
        graph.addBiDirectedEdge(0, 5);
        graph.addBiDirectedEdge(1, 2);
        graph.addBiDirectedEdge(1, 4);
        graph.addBiDirectedEdge(2, 3);
        graph.addBiDirectedEdge(3, 4);
        List<Integer> bsfTraversalNodes = graph.bfs(0);
        assertThat(bsfTraversalNodes).containsExactly(0, 1, 4, 5, 2, 3);

    }

    @Test
    public void dfs() throws Exception {
        GraphEx graph = new GraphEx(6);
        graph.addBiDirectedEdge(0, 1);
        graph.addBiDirectedEdge(0, 4);
        graph.addBiDirectedEdge(0, 5);
        graph.addBiDirectedEdge(1, 2);
        graph.addBiDirectedEdge(1, 4);
        graph.addBiDirectedEdge(2, 3);
        graph.addBiDirectedEdge(3, 4);
        List<Integer> dsfTraversalNodes = graph.dfs(0);
        assertThat(dsfTraversalNodes).containsExactly(0, 1, 2, 3, 4, 5);
    }

    @Test
    public void connectedComponents() throws Exception {
        GraphEx graph = new GraphEx(9);
        graph.addBiDirectedEdge(0, 1);
        graph.addBiDirectedEdge(0, 4);
        graph.addBiDirectedEdge(0, 5);
        graph.addBiDirectedEdge(1, 2);
        graph.addBiDirectedEdge(1, 4);
        graph.addBiDirectedEdge(2, 3);
        graph.addBiDirectedEdge(3, 4);
        graph.addBiDirectedEdge(6, 7);
        List<List<Integer>> connectedComponents = graph.connectedComponents();
        assertThat(connectedComponents).containsExactly(
                Arrays.asList(0, 1, 4, 5, 2, 3),
                Arrays.asList(6, 7),
                Arrays.asList(8));
    }

    @Test
    public void findPath() throws Exception {
        GraphEx graph = new GraphEx(9);
        graph.addBiDirectedEdge(0, 1);
        graph.addBiDirectedEdge(0, 4);
        graph.addBiDirectedEdge(0, 5);
        graph.addBiDirectedEdge(1, 2);
        graph.addBiDirectedEdge(1, 4);
        graph.addBiDirectedEdge(2, 3);
        graph.addBiDirectedEdge(3, 4);
        graph.addBiDirectedEdge(6, 7);

        assertThat(graph.findPath(0, 3)).containsExactly(0, 4, 3);
        assertThat(graph.findPath(3, 0)).containsExactly(3, 4, 0);
        assertThat(graph.findPath(7, 6)).containsExactly(7, 6);
        assertThat(graph.findPath(6, 7)).containsExactly(6, 7);
    }

    @Test
    public void findPath_noPath() throws Exception {
        GraphEx graph = new GraphEx(9);
        graph.addBiDirectedEdge(0, 1);
        graph.addBiDirectedEdge(0, 4);
        graph.addBiDirectedEdge(0, 5);
        graph.addBiDirectedEdge(1, 2);
        graph.addBiDirectedEdge(1, 4);
        graph.addBiDirectedEdge(2, 3);
        graph.addBiDirectedEdge(3, 4);
        graph.addBiDirectedEdge(6, 7);

        assertThat(graph.findPath(2, 7)).isEmpty();
        assertThat(graph.findPath(7, 2)).isEmpty();
    }

    @Test
    public void classifyEdges_tree() throws Exception {
        GraphEx graph = new GraphEx(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        List<GraphEx.Edge> edges = graph.classifyEdges();

        assertThat(edges).containsExactly(
                GraphEx.Edge.of(0, 1, GraphEx.EdgeClass.TREE),
                GraphEx.Edge.of(1, 3, GraphEx.EdgeClass.TREE),
                GraphEx.Edge.of(1, 4, GraphEx.EdgeClass.TREE),
                GraphEx.Edge.of(0, 2, GraphEx.EdgeClass.TREE)
        );
        assertThat(graph.findCycles()).isEmpty();
    }

    @Test
    public void classifyEdges_forward() throws Exception {
        GraphEx graph = new GraphEx(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(0, 4);

        List<GraphEx.Edge> edges = graph.classifyEdges();

        assertThat(edges).containsExactly(
                GraphEx.Edge.of(0, 1, GraphEx.EdgeClass.TREE),
                GraphEx.Edge.of(1, 3, GraphEx.EdgeClass.TREE),
                GraphEx.Edge.of(1, 4, GraphEx.EdgeClass.TREE),
                GraphEx.Edge.of(0, 2, GraphEx.EdgeClass.TREE),
                GraphEx.Edge.of(0, 4, GraphEx.EdgeClass.FORWARD)
        );
        // TODO: fix finding cycles for directed graphs
        // assertThat(graph.findCycles()).isEmpty();
    }

    @Test
    public void classifyEdges_back() throws Exception {
        GraphEx graph = new GraphEx(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(4, 0);

        List<GraphEx.Edge> edges = graph.classifyEdges();

        assertThat(edges).containsExactly(
                GraphEx.Edge.of(0, 1, GraphEx.EdgeClass.TREE),
                GraphEx.Edge.of(1, 3, GraphEx.EdgeClass.TREE),
                GraphEx.Edge.of(1, 4, GraphEx.EdgeClass.TREE),
                GraphEx.Edge.of(4, 0, GraphEx.EdgeClass.BACK),
                GraphEx.Edge.of(0, 2, GraphEx.EdgeClass.TREE)
        );
        assertThat(graph.findCycles()).containsExactly(Arrays.asList(0, 1, 4));
    }

    @Test
    public void classifyEdges_cross() throws Exception {
        GraphEx graph = new GraphEx(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);

        List<GraphEx.Edge> edges = graph.classifyEdges();

        assertThat(edges).containsExactly(
                GraphEx.Edge.of(0, 1, GraphEx.EdgeClass.TREE),
                GraphEx.Edge.of(1, 3, GraphEx.EdgeClass.TREE),
                GraphEx.Edge.of(1, 4, GraphEx.EdgeClass.TREE),
                GraphEx.Edge.of(0, 2, GraphEx.EdgeClass.TREE),
                GraphEx.Edge.of(2, 1, GraphEx.EdgeClass.CROSS)
        );
        // TODO: fix finding cycles for directed graphs
        // assertThat(graph.findCycles()).isEmpty();
    }

    @Test
    public void topologicalSort() throws Exception {
        GraphEx graph = new GraphEx(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        //graph.addEdge(3, 1);
        graph.addEdge(4, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 2);
        graph.addEdge(3, 5);
        graph.addEdge(2, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        assertThat(graph.topologicalSort()).containsExactly(0, 1, 4, 3, 2, 5, 6);
    }

    @Test(expected = RuntimeException.class)
    public void topologicalSort_with_cycle() throws Exception {
        GraphEx graph = new GraphEx(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(3, 1);
        graph.addEdge(4, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 2);
        graph.addEdge(3, 5);
        graph.addEdge(2, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        graph.topologicalSort();
    }
}