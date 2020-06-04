package prep;

import prep.RouteBetweenNodes.State;

/**
 * 4.1 Route Between Nodes 
 * 5/11/20
 */
public class Graph {
    public Node[] nodes; 

    public class Node {
        public String name; 
        public Node[] children; // list of adjacent vertices
        public State state; 
    }

    Node[] getNodes() {
        return nodes; 
    }

    void depthFirstSearch(Node root) {
        if (root == null) return; 
    }
}