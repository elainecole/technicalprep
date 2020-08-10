package prep;

import javax.swing.tree.*;

/**
 * 4.2 Minimal Tree 
 * 5/12/20
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/tree/DefaultMutableTreeNode.html
 */
public class MinimalTree {
    public static void main(String[] args) {
    }
    DefaultMutableTreeNode createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    DefaultMutableTreeNode createMinimalBST(int[] arr, int start, int end) {
        if (end < start) return null; 

        int mid = (start + end) / 2;
        DefaultMutableTreeNode n = new DefaultMutableTreeNode(arr[mid]); 
        ((DefaultMutableTreeNode) n).add((MutableTreeNode) createMinimalBST(arr, start, mid - 1));
        ((DefaultMutableTreeNode) n).add((MutableTreeNode) createMinimalBST(arr, mid + 1, end));
        return n;
    }
}

/*
TreeNode {
 
}
 
TreeNode minimalSubTree(int start, int end, int[] arr) {
// stop when start == end
if (start > end) {
	return null; 
}
int mid = (arr.length - 1)/ 2; 
TreeNode child = new TreeNode(arr[mid]); 
child.left = minimalSubTree(0, mid - 1, array.subArray(0, mid - 1)); 
child.right = minimalSubTree(mid - 1, arr.length - 1, array.subArray(mid + 1, arr.length - 1)); 
return child; 
}
 
TreeNode minimalTree(int[] arr) {
	return minimalSubTree(0, arr.length - 1, arr); 
}

*/