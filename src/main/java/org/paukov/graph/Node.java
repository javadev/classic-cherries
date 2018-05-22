package org.paukov.graph;

/**
 * Created by dpaukov on 5/3/18.
 */
public class Node<T> {

  T label;

  boolean discovered;
  boolean processed;
  Node<T> parent;
  int entryTime;
  int exitTime;

  public Node(T label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return "Node(" + label + ')';
  }
}
