package prep;

// import java.util.ArrayList;

/**
 * 4.12 Paths with Sum: 5/28/20 4.12 Paths with Sum: You are given a binary tree
 * in which each node contains an integer value (which might be positive or
 * negative). Design an algorithm to count the number of paths that sum to a
 * given value. The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 */
public class PathsWithSum {

    public static void main(String[] args) {
        System.out.println("Initializing Technical Prep: Paths with Sum");
    }
    /*
    ArrayList<Integer> PostOrder(Node n, int sumValue) {
        ArrayList<Integer> ret = new ArrayList<Integer>; 
        ret.set(0, 0); 
        if (n != null) {
            ArrayList<Integer> leftPartials = PostOrder(n.left, sumValue); 
            ArrayList<Integer> rightPartials = PostOrder(n.right, sumValue); 
            // visit(n); 
            // ArrayList of partial paths
            ret.set(0, leftPartials.get(0) + rightPartials.get(0)); 
            // for each partial, can this node make a full path? 
            for (int i = 1; i < leftPartials.size(); i++) {
                if (leftPartials.get(i) + n.data == sumValue) {
                    ret.set(0, ret.get(0) + 1);
                } else {
                    ret.add(leftPartials.get(i) + n.data); 
                }
            }
    
            // same for right: 
            for (int i = 1; i < rightPartials.size(); i++) {
                if (rightPartials.get(i) + n.data == sumValue) {
                    ret.set(0, ret.get(0) + 1);
                } else {
                    ret.add(rightPartials.get(i) + n.data); 
                }
            }
        }
    return ret; 
    }
    */
}