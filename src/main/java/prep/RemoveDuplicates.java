package prep;

/**
 * 2.1 Remove Dups
 * 4/27/20
 */
public class RemoveDuplicates {

    public static void main(String[] args) throws Exception {
        System.out.println("Initializing Technical Prep");
        // System.out.println("RemoveDuplicates: " + removeDuplicates("));
    }
    
    void removeDuplicates(Node start) {
        // from start of linkedList to end, while loop through
        Node curr = start; 
        while (curr.hasNext()) {
            Node future = curr.next; 
            while (future.hasNext()) {
                // compare value of node at j 
                if (curr.data == future.data) {
                // if duplicate, remove 
                Node dead = future; 
                future = future.next; 
                dead.remove(); 
                } else {
                    future = future.next; 
                }
            }
            curr = curr.next; 
    }	
    }
    
}