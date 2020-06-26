package prep;

/**
 * 2.2 Return Kth to Last
 * 4/27/20
 */
public class KthFromLast {
    // Node class has .data and .next fields.
    // NULL is end of .next
    
    public static void main(String[] args) {
        System.out.println("Initializing Technical Prep");
        // System.out.println("KthFromLast: " + fourthFromLast(3));
    }
    Node fourthFromLast(Node head) {
        // start at head.next, 
        // one ptr going one step each iteration
        // ptr 2 going 4 steps each iteration 
        Node faster = head; 
        Node slow = null;
    int i = 0;  
        while (faster.next != null) {
            if (i == 3) {
                slow = head; 
            } else if (i > 3) {
                slow = slow.next; 
            }
            i++; 
            faster = faster.next; 
        }
        return slow; 
    }
    
}