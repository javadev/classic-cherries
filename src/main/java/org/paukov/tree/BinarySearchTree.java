package org.paukov.tree;

/**
 * Created by dpaukov
 */
public class BinarySearchTree {

    Node root = null;

    class Node {
        Integer key;
        Integer value;

        Node left;
        Node right;
        Node parent;

        public Node(Integer key, Integer value, Node left, Node right, Node parent) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

    }


    Node add(Integer key, Integer value, Node current, Node parent) {
        Node node;
        if (current == null){
            node = new Node(key, value, null, null, parent);
        } else {
            node = current;
            Integer currentKey = current.key;
            if (key < currentKey){
                node.left = add(key, value, current.left, current);
            } else if (key > currentKey ) {
                node.right = add(key, value, current.right, current);
            }
        }
        return node;
    }

    Node search(Node node, Integer key) {
        if (node == null || node.key.equals(key)) {
            return node;
        }
        if (key < node.key) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    public void add(Integer key, Integer value) {
        root = add(key, value, root, null);
    }

    public Integer search(Integer key) {
        Node node = search(root, key);
        if (node == null){
            return null;
        }
        return node.value;
    }
}
