package prep;

import java.util.HashSet;
import java.util.Set;

/**
 * 2.8 Loop Detection
 * 5/7/20
 */
public class LoopDetection {
    public Node containsLoop(Node head) {
        Set<Node> nodeSet = new HashSet<Node>(); 
        Node curr = head; 
        while (curr != null) {
            if (nodeSet.contains(curr)) {
                return curr; 
            }
            nodeSet.add(curr); 
            curr = curr.next; 
        }
        return null; 
    }
    
    
    public Node fixLoop(Node head) {
        Set<Node> nodeSet = new HashSet<Node>(); 
        Node curr = head;
        nodeSet.add(curr);  
        while (curr != null && curr.next != null) {
            if (nodeSet.contains(curr.next)) {
                Node loopStart = curr.next; 
                curr.next = null; 
                return loopStart; 
            }
            nodeSet.add(curr.next); 
            curr = curr.next; 
        }
        return null; 
    }
    
}