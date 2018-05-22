package org.paukov.graph;

/**
 * Created by dpaukov on 5/3/18.
 */
public class Edge {

  Node from;
  Node to;
  EdgeClass edgeClass = EdgeClass.UNKNOWN;
  double weigth = 0.0;


  public Edge(Node from, Node to, EdgeClass edgeClass) {
    this.from = from;
    this.to = to;
    this.edgeClass = edgeClass;
  }

  public Edge(Node from, Node to, double weigth, EdgeClass edgeClass) {
    this.from = from;
    this.to = to;
    this.weigth = weigth;
    this.edgeClass = edgeClass;
  }

  static Edge of(Node from, Node to, EdgeClass edgeClass) {
    return new Edge(from, to, edgeClass);
  }

  void setEdgeClass(EdgeClass edgeClass) {
    this.edgeClass = edgeClass;
  }

  @Override
  public String toString() {
    return "Edge(" + from + ", " + to + ", " + edgeClass + ')';
  }
}
