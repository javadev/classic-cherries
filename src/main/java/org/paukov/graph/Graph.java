package org.paukov.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;

/**
 * Created by dpaukov on 4/7/18.
 */
public class Graph {
    final int size;
    final List<Integer>[] edges;
    int time = 0;

    public Graph(int size) {
        this.size = size;
        this.edges = new List[size];
        for (int i = 0; i < size; i++) {
            this.edges[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to) {
        assert from < this.size;
        assert to < this.size;
        this.edges[from].add(to);
    }

    public void addBiDirectedEdge(int from, int to) {
        assert from < this.size;
        assert to < this.size;
        this.edges[from].add(to);
        this.edges[to].add(from);
    }

    public void addEdges(int[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            int from = edges[i];
            int to = edges[i + 1];
            assert from < this.size;
            assert to < this.size;
            this.edges[from].add(to);
        }
    }

    static class NodeInfo {
        boolean discovered;
        boolean processed;
        int parent;
        int entryTime;
        int exitTime;

        static NodeInfo[] build(int size) {
            NodeInfo[] array = new NodeInfo[size];
            for (int i = 0; i < size; i++) {
                array[i] = new NodeInfo();
            }
            return array;
        }
    }

    public List<Integer> bfs(int root) {
        List<Integer> list = new ArrayList<>();
        bfs(root,
                NodeInfo.build(size),
                (v) -> {
                    System.out.println("Process vertex: " + v);
                    list.add(v);
                },
                (i, j) -> System.out.println("Process edge: " + i + "," + j),
                (v) -> {});
        return list;
    }

    public void bfs(int root, NodeInfo[] info, IntConsumer processNodeBefore, BiConsumer<Integer, Integer> processEdge, IntConsumer processNodeAfter) {
        assert root < this.size;

        info[root].discovered = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            info[node].processed = true;
            processNodeBefore.accept(node);
            for (Integer child : edges[node]) {
                if (!info[child].processed) {
                    processEdge.accept(node, child);
                }
                if (!info[child].discovered) {
                    queue.add(child);
                    info[child].discovered = true;
                    info[child].parent = node;
                }
            }
            processNodeAfter.accept(node);

        }
    }

    public List<Integer> dfs(int root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,
                NodeInfo.build(size),
                (v) -> {
                    System.out.println("Process vertex: " + v);
                    list.add(v);
                },
                (i, j) -> System.out.println("Process edge: " + i + "," + j),
                (v) -> {});
        return list;
    }


    public void dfs(int node, NodeInfo[] info, IntConsumer processNodeBefore, BiConsumer<Integer, Integer> processEdge, IntConsumer processNodeAfter) {
        assert node < this.size;

        info[node].discovered = true;
        time = time + 1;
        info[node].entryTime = time;

        processNodeBefore.accept(node);

        for (Integer child : edges[node]) {
            if (!info[child].discovered) {
                info[child].parent = node;
                processEdge.accept(node, child);
                dfs(child, info, processNodeBefore, processEdge, processNodeAfter);
            } else if (!info[child].processed) {
                processEdge.accept(node, child);
            }
        }
        processNodeAfter.accept(node);
        time = time + 1;
        info[node].exitTime = time;
        info[node].processed = true;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addBiDirectedEdge(0, 1);
        graph.addBiDirectedEdge(0, 4);
        graph.addBiDirectedEdge(0, 5);
        graph.addBiDirectedEdge(1, 2);
        graph.addBiDirectedEdge(1, 4);
        graph.addBiDirectedEdge(2, 3);
        graph.addBiDirectedEdge(3, 4);
        System.out.println("BFS:" + graph.bfs(0));
        System.out.println("DFS:" + graph.dfs(0));
    }
}
