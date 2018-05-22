package org.paukov.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.BiConsumer;

/**
 * Created by dpaukov on 4/7/18.
 */
public class GraphEx {

  private static final int NO_PARENT = -1;
  final int size;
  final List<Integer>[] edges;
  int time = 0;
  public GraphEx(int size) {
    this.size = size;
    this.edges = new List[size];
    for (int i = 0; i < size; i++) {
      this.edges[i] = new ArrayList<>();
    }
  }

  public static void main(String[] args) {
    GraphEx graph = new GraphEx(9);
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

    GraphEx graph2 = new GraphEx(9);
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
    System.out.println("Edge Classes:" + graph2.classifyEdges());
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
        // TODO: add support for undirected graphs
        // if (!info[child].processed) {
        processEdge.accept(Edge.of(node, child, EdgeClass.UNKNOWN), info);
        // }
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
        processEdge.accept(Edge.of(node, child, EdgeClass.UNKNOWN), info);
        dfs(child, info, processNodeBefore, processEdge, processNodeAfter);
        //TODO: Add support for undirected graphs.
      } else /*if (!info[child].processed)*/ {
        processEdge.accept(Edge.of(node, child, EdgeClass.UNKNOWN), info);
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

  public List<Edge> classifyEdges() {
    NodeInfo[] nodeInfo = NodeInfo.build(this.size);
    List<Edge> classifiedEdges = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      if (!nodeInfo[i].discovered) {
        dfs(i, nodeInfo, (v, info) -> {
              // do nothing
            },
            (edge, info) -> {
              System.out.println("DFS Edge Classification Process edge: " + edge.i + "," + edge.j);
              EdgeClass edgeClass = classifyEdge(edge.i, edge.j, info);
              edge.setEdgeClass(edgeClass);
              classifiedEdges.add(edge);
            },
            (v, info) -> {
              // do nothing here
            });
      }
    }
    return classifiedEdges;
  }

  private EdgeClass classifyEdge(int i, int j, NodeInfo[] nodeInfos) {
      if (nodeInfos[j].parent == i) {
          return EdgeClass.TREE;
      }
      if (nodeInfos[j].discovered && !nodeInfos[j].processed) {
          return EdgeClass.BACK;
      }
      if (nodeInfos[j].processed && nodeInfos[j].entryTime > nodeInfos[i].entryTime) {
          return EdgeClass.FORWARD;
      }
      if (nodeInfos[j].processed && nodeInfos[j].entryTime < nodeInfos[i].entryTime) {
          return EdgeClass.CROSS;
      }
    return EdgeClass.UNKNOWN;
  }

  public List<Integer> topologicalSort() {
    NodeInfo[] nodeInfo = NodeInfo.build(this.size);
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < size; i++) {
      if (!nodeInfo[i].discovered) {
        dfs(i, nodeInfo, (v, info) -> {
              // do nothing
            },
            (edge, info) -> {
              System.out.println("Topological Sorting edge: " + edge.i + "," + edge.j);
              EdgeClass edgeClass = classifyEdge(edge.i, edge.j, info);
              if (edgeClass == EdgeClass.BACK) {
                edge.setEdgeClass(edgeClass);
                throw new RuntimeException("Cycle found, not acyclic graph: " + edge);
              }
            },
            (v, info) -> {
              stack.push(v);
            });
      }
    }
    return new ArrayList<>(stack);
  }

  public enum EdgeClass {
    UNKNOWN, TREE, BACK, FORWARD, CROSS
  }

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

  static public class Edge {

    int i;
    int j;
    EdgeClass edgeClass;

    Edge(int i, int j, EdgeClass edgeClass) {
      this.i = i;
      this.j = j;
      this.edgeClass = edgeClass;
    }

    static Edge of(int i, int j, EdgeClass edgeClass) {
      return new Edge(i, j, edgeClass);
    }

    void setEdgeClass(EdgeClass edgeClass) {
      this.edgeClass = edgeClass;
    }

    @Override
    public String toString() {
      return "Edge(" + i + ", " + j + ", " + edgeClass + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

      Edge edge = (Edge) o;

        if (i != edge.i) {
            return false;
        }
        if (j != edge.j) {
            return false;
        }
      return edgeClass == edge.edgeClass;
    }

    @Override
    public int hashCode() {
      int result = i;
      result = 31 * result + j;
      result = 31 * result + edgeClass.hashCode();
      return result;
    }
  }
}
