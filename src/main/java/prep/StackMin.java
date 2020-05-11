package prep;

/**
 * 3.2 Stack Min
 * 5/7/20
 * 3.2 Stack Min: How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop, and min should all operate in O(1) time. 
 */
public class StackMin {
    class Node {
        Node next; 
        Node previous; 
        Node minNode; 
        int data; 
    }
    
    Node top = null; 
    
    void push(Node a) {
        a.minNode = a;
        if (top != null) { 
            top.previous = a; 
            if (a.data > top.minNode.data) {
                a.minNode = top.minNode; 
            }
        }
        a.next = top; 
        a.previous = null; 
        top = a; 
        
    }
    
    Node pop() {
        Node ret = top;
        if (top != null) {
            top = top.next; 
            top.previous = null; 
    }
        return ret; 
    }
    
    Node min() {
        return top.minNode; 
    }
    
}