package prep;

/**
 * 8/3/20
 * Given BST of ints 
 * Find if int n exists in tree
 * no duplicates
 */
public class FindBSTNode {
    boolean findNode(int n, Node parent) {
        if (parent == null) {
            return false; 
    }
        if (n == parent.data) {
            return true; 
        } else if (n < parent.data) {
            return findNode(n, parent.left);
        } else if (n > parent.data) {
            return findNode(n, parent.right); 
        }
        return false; 
    }
    
}