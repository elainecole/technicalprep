package prep;

public class Node {
    Node next = null; 
    int data;
	public Node left;
	public Node right; 

    public Node(int data) {
        this.data = data; 
    }

    boolean hasNext() {
        if (this.next != null) {
            return true; 
        }
        return false; 
    }
    boolean remove() {
        this.next = this.next.next; 
        return true; 
    }

    void appendToTail(int d) {
        Node end = new Node(d); 
        Node n = this; 
        while (n.next != null) {
            n = n.next; 
        }
        n.next = end; 
    }

    

    Node deleteNode(Node head, int d) {
        if (head == null) return null; 
        Node n = head; 

        if (n.data == d) {
            return head.next; // moved head
        }
        
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next; 
                return head; // head didn't change 
            }
            n = n.next; 
        }
        return head; 
    }
}