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
        Node ret = sum; // added
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

    public Node forwardSum(int len1, Node list1, int len2, Node list2) {
        Node    next1, next2;
        int orig1 = len1; 
        int orig2 = len2; 
        if (len1 > len2) {
            next1 = list1.next;
            len1--;
            next2 = list2;
    } else if (len2 > len1) {
        next2 = list2.next; 
        len2--; 
        next1 = list1;
    } else {
        next1 = list1.next; 
        next2 = list2.next; 
        len1--;
        len2--; 
    }
    if (orig1 > 0 || orig2 > 0) {
    Node p = forwardSum(len1, next1, len2, next2); 
    Node n = new Node(0); 
    n.next = p; 
    // case 1: equal, add .data together
    // case 2: len1 > len2, .data = l1.data (plus maybe carry)
    // case 3: len2 > len1, .data = l2.data (plus maybe carry)
    n.data += (len1 >= len2) ? list1.data : 0; 
    n.data += (len2 >= len1) ? list2.data : 0; 
    if (p.data > 9) {
        p.data -= 10; 
        n.data += 1; 
    }
    return n; 
    } else { // base case
        // add .data together, start going backwards up 
        Node sum = new Node(next1.data + next2.data); 
            return sum; 
    }
    }
    

}