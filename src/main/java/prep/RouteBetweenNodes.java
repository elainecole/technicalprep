package prep;
import java.util.LinkedList;

/**
 * 4.1 Route Between Nodes 
 * 5/11/20
 */
public class RouteBetweenNodes {
    public enum State {
        Unvisited, Visiting, Visited
    }

    static void main(String[] args) {

    }

    static boolean routeExists(Graph g, Graph.Node s, Graph.Node e) {
        if (s == e) return true; 

        LinkedList<Graph.Node> q = new LinkedList<Graph.Node>(); 
        for (Graph.Node n : g.getNodes()) {
            n.state = State.Unvisited; 
        }

        s.state = State.Visiting; 
        q.add(s); 
        Graph.Node u;

        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (Graph.Node v : u.children) {
                    if (v.state == State.Unvisited) {
                        if (v == e) return true; 
                        v.state = State.Visiting; 
                        q.add(v); 
                    }
                }
                u.state = State.Visited; 
            }
        }
        return false;
    }
}