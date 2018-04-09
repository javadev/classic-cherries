package org.paukov.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.BiConsumer;

/**
 * Created by dpaukov on 4/7/18.
 */
public class Graph {

    private static final int NO_PARENT = -1;

    final int size;
    final List<Integer>[] edges;
    int time = 0;

    static class NodeInfo {
        boolean discovered;
        boolean processed;
        int parent = NO_PARENT;
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

    static class Edge {
        int i;
        int j;

        Edge(int i, int j) {
            this.i = i;
            this.j = j;
        }

        static Edge of(int i, int j) {
            return new Edge(i, j);
        }
    }

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

    public List<Integer> bfs(int root) {
        List<Integer> list = new ArrayList<>();
        bfs(root,
                NodeInfo.build(size),
                (v, info) -> {
                    System.out.println("BFS Process vertex: " + v);
                    list.add(v);
                },
                (edge, info) -> System.out.println("BFS Process edge: " + edge.i + "," + edge.j),
                (v, info) -> {
                    // do nothing here
                });
        return list;
    }

    public void bfs(int root,
                    NodeInfo[] info,
                    BiConsumer<Integer, NodeInfo[]> processNodeBefore,
                    BiConsumer<Edge, NodeInfo[]> processEdge,
                    BiConsumer<Integer, NodeInfo[]> processNodeAfter) {
        assert root < this.size;
        info[root].discovered = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            info[node].processed = true;
            processNodeBefore.accept(node, info);
            for (Integer child : edges[node]) {
                if (!info[child].processed) {
                    processEdge.accept(Edge.of(node, child), info);
                }
                if (!info[child].discovered) {
                    queue.add(child);
                    info[child].discovered = true;
                    info[child].parent = node;
                }
            }
            processNodeAfter.accept(node, info);
        }
    }

    public List<Integer> dfs(int root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,
                NodeInfo.build(size),
                (v, info) -> {
                    System.out.println("DFS Process vertex: " + v);
                    list.add(v);
                },
                (edge, info) -> System.out.println("DFS Process edge: " + edge.i + "," + edge.j),
                (v, info) -> {
                    // do nothing here
                });
        return list;
    }


    public void dfs(int node,
                    NodeInfo[] info,
                    BiConsumer<Integer, NodeInfo[]> processNodeBefore,
                    BiConsumer<Edge, NodeInfo[]> processEdge,
                    BiConsumer<Integer, NodeInfo[]> processNodeAfter) {
        assert node < this.size;

        info[node].discovered = true;
        time = time + 1;
        info[node].entryTime = time;

        processNodeBefore.accept(node, info);

        for (Integer child : edges[node]) {
            if (!info[child].discovered) {
                info[child].parent = node;
                processEdge.accept(Edge.of(node, child), info);
                dfs(child, info, processNodeBefore, processEdge, processNodeAfter);
            } else if (!info[child].processed) {
                processEdge.accept(Edge.of(node, child), info);
            }
        }
        processNodeAfter.accept(node, info);
        time = time + 1;
        info[node].exitTime = time;
        info[node].processed = true;
    }

    public List<List<Integer>> connectedComponents() {
        NodeInfo[] nodeInfo = NodeInfo.build(this.size);
        List<List<Integer>> componentList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (!nodeInfo[i].discovered) {
                List<Integer> component = new ArrayList<>();
                bfs(i, nodeInfo, (v, info) -> {
                            component.add(v);
                        },
                        (edge, info) -> {
                            // do nothing here
                        },
                        (v, info) -> {
                            // do nothing here
                        });
                componentList.add(component);
            }
        }
        return componentList;
    }

    public List<Integer> findPath(int start, int end) {
        List<Integer> path = new ArrayList<>();
        NodeInfo[] nodeInfo = NodeInfo.build(this.size);
        bfs(start, nodeInfo,
                (v, info) -> {
                    // do nothing here
                },
                (edge, info) -> {
                    // do nothing here
                },
                (v, info) -> {
                    // do nothing here
                });
        findPathRecursively(start, end, nodeInfo, path);
        return path;
    }

    public List<List<Integer>> findCycles() {
        NodeInfo[] nodeInfo = NodeInfo.build(this.size);
        List<List<Integer>> cycles = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (!nodeInfo[i].discovered) {
                dfs(i, nodeInfo, (v, info) -> {
                            System.out.println("DFS Process vertex: " + v);
                        },
                        (edge, info) -> {
                            System.out.print("DFS Process edge: " + edge.i + "," + edge.j);
                            if (info[edge.j].parent != edge.i) {
                                // We found a cycle
                                System.out.printf(" - DFS Cycle from %d to %d", edge.j, edge.i);
                                List<Integer> cyclePath = new ArrayList<>();
                                findPathRecursively(edge.j, edge.i, nodeInfo, cyclePath);
                                cycles.add(cyclePath);
                            }
                            System.out.println();
                        },
                        (v, info) -> {
                            // do nothing here
                        });
            }
        }
        return cycles;
    }

    private void findPathRecursively(int start, int end, NodeInfo[] nodeInfo, List<Integer> path) {
        if (start == end || end == NO_PARENT) {
            path.add(start);
        } else {
            if (nodeInfo[end].discovered) {
                findPathRecursively(start, nodeInfo[end].parent, nodeInfo, path);
                path.add(end);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addBiDirectedEdge(0, 1);
        graph.addBiDirectedEdge(0, 4);
        graph.addBiDirectedEdge(0, 5);
        graph.addBiDirectedEdge(1, 2);
        graph.addBiDirectedEdge(1, 4);
        graph.addBiDirectedEdge(2, 3);
        graph.addBiDirectedEdge(3, 4);
        graph.addBiDirectedEdge(6, 7);
        System.out.println("BFS:" + graph.bfs(0));
        System.out.println("DFS:" + graph.dfs(0));
        System.out.println("ConnectedComponents:" + graph.connectedComponents());
        System.out.println("Path 0->3:" + graph.findPath(0, 3));
        System.out.println("Cycles:" + graph.findCycles());

        Graph graph2 = new Graph(9);
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 4);
        graph2.addEdge(0, 5);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 4);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 4);
        graph2.addEdge(6, 7);

        graph2.addEdge(3, 1);
        graph2.addEdge(4, 1);

        System.out.println("BFS:" + graph2.bfs(0));
        System.out.println("DFS:" + graph2.dfs(0));
        System.out.println("ConnectedComponents:" + graph2.connectedComponents());
        System.out.println("Path 0->3:" + graph2.findPath(0, 3));
        System.out.println("Cycles:" + graph2.findCycles());
    }
}
