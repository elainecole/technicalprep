package prep;

/**
 * 4.5 Validate BST
 * 8/10/20
 * implement a function to check if a binary tree is a binary search tree. 
 */
public class ValidateBST {

    public static void main( String[] args ) {
        System.out.println("Initializing Technical Prep: 4.5 Validate BST");
    }

    int[] validateBST(Node n) {
        int[] range = new int[2];
        // base case: no children 
        if (n.left == null && n.right == null) {
            range[0] = n.data;
            range[1] = n.data; 
            return range; 
        }
        // check n.left 
        if (n.left.data > n.data) {
            // not a BST
            range[0] = -1;
            range[1] = -1;
            return range;
        } else {
            // valid for left; check range of left
            int[] rangeLeft = validateBST(n.left); 
            if (rangeLeft[1] > n.data) {
                // not a BST
                range[0] = -1;
            range[1] = -1;
            return range;
            } else {
                range[0] = rangeLeft[0];
    }
        }
        // check n.right
        if (n.right.data < n.data) {
            // not a BST
            range[0] = -1;
            range[1] = -1;
            return range;
        } else {
            int[] rangeRight = validateBST(n.right); 
            if (rangeRight[0] < n.data) {
                // not a BST
                range[0] = -1;
                range[1] = -1;
                return range;
            } else {
                range[1] = rangeRight[1]; 
            }
        }
        // update min and max of range for n 
        return range; 
    }
    
}