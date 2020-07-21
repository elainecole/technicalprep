package prep;

// import javax.swing.tree.TreeNode;

/**
 * 4.4 Check Balanced 
 * 5/12/20
 * Implement a function to check if a binary tree is balanced. 
 * For the purposes of this question, a balanced tree is defined to be a tree such 
 * that the heights of the two subtrees of any node never differ by more than one. 
 */
public class CheckBalanced {

    public static void main(String[] args) {
    }
    /*
    // post order traversal 
int postOrderTraversal(TreeNode root) {
	// first act on children, then node
	if (root == null) return 0; // end case
	int leftDepth = postOrderTraversal(root.leftChild); 
    int rightDepth = postOrderTraversal(root.rightChild); 
    if (Math.abs(leftDepth - rightDepth) > 1  ||
        rightDepth < 0 || leftDepth < 0) {
        return -1; 
    }
    return Math.max(leftDepth, rightDepth);
    }
    */
    

}