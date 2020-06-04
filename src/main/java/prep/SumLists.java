package prep;

/**
 * 2.5 Sum Lists
 * 6/2/20
 */
public class SumLists {

    public static void main(String[] args) {
        System.out.println("Initializing Technical Prep: Sum Lists");
        Node list1 = new Node(7); 
        list1.next = new Node(1); 
        list1.next.next = new Node(6); 

        Node list2 = new Node(5); 
        list2.next = new Node(9); 
        list2.next.next = new Node(2); 
        Node n = backwardSum(list1, list2);
        System.out.print("backwardSum: ");
        while (n != null) {
            System.out.print(n.data);
            n = n.next; 
        }
        System.out.println(); 
    }

    public static Node backwardSum(Node list1, Node list2) {
        // make what I’ll return 
        // walk down while both,
        // walk down while one
        Node sum = new Node(0);
        sum.next = null; 
        int sumDigit = 0; 
        sum.data = sumDigit;
        Node ret = sum; 
        while (list1 != null || list2 != null) {
            if (list1 != null) {
                sumDigit += list1.data; 
            }
            if (list2 != null) {
                sumDigit += list2.data; 
            }
    
            if (sumDigit > 9) {
                sum.data = sumDigit - 10; 
                sumDigit = 1; 
            } else { // added else statement
                sum.data = sumDigit; 
                sumDigit = 0; 
            }
            // next digit(s)
            if (sumDigit == 1 || (list1 != null || list2 != null)) {
                sum.next = new Node(sumDigit); 
            }
            sum = sum.next;
            if (list1 != null) {
                list1 = list1.next; 
            }
            if (list2 != null) {
                list2 = list2.next; 
            }
        } 
        return ret; 
    }
}