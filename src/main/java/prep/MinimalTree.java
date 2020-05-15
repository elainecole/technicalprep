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