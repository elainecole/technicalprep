package prep;

import javax.swing.tree.TreeNode;

/**
 * 4.6 Successor
 * 
 * 5/12/20
 */
public class Successor {
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