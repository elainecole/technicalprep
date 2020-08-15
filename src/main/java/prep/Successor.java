package prep;

import javax.swing.tree.TreeNode;

/**
 * 4.6 Successor
 * 5/12/20, 8/10/20 
 * write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree. 
 * You may assume that each node has a link to its parent. 
 */
public class Successor {

    public static void main( String[] args ) {
        System.out.println("Initializing Technical Prep: 4.6 Successor");
    }
    TreeNode inOrderSucc(TreeNode n) {
        if (n == null) return null; 
        if (n.getChildAt(1) != null) {
            return leftmostChild(n.getChildAt(1));
        } else {
            TreeNode q = n; 
            TreeNode x = q.getParent();
            while (x != null && x.getChildAt(0) != q) {
                q = x; 
                x = x.getParent();
            }
            return x; 
        }
    }

    TreeNode leftmostChild(TreeNode n) {
        if (n == null) return null; 
        while (n.getChildAt(0) != null) {
            n = n.getChildAt(0);
        }
        return n; 
    }
}