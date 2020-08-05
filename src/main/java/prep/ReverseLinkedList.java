package prep;

/**
 * Reverse a Linked List
 * 7/28/20
 */
public class ReverseLinkedList {
    // head of list
    // .data
    // .next

    // flip around next nodes, no new nodes 

    class Node {
        int data; 
        Node next; 

        public Node(int data) {
            this.data = data; 
            this.next = null; 
        }
    }
    public static void main(String[] args) {
        System.out.println("Technical Prep: Reverse a Linked List"); 
    }

    void reverseList(Node head) {
        Node prev = null; 
        Node curr = head; 
        Node next = curr.next; 
        
        // reverse portion: 
        while (curr != null) {
            curr.next = prev; 
            prev = curr; 
            curr = next;
        }
        head = prev; 
    }
}