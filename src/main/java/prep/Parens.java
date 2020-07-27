package prep;

import java.util.ArrayList;

/**
 * 8.9 Parens
 * 7/27/20
 */
public class Parens {
    public static void main(String[] args) {
        int n = 4; 
        System.out.println("Parens: " + parens(n).toString()); 
    }

    static ArrayList<String> parens(int n) {
        ArrayList<String> result = new ArrayList<String>(); 
        if (n == 1) {
            result.add("()");
        } else {
            ArrayList<String> partial = parens(n - 1); 
            for (String s : partial) {
                // encapsulate
                String encapsulate = "(" + s + ")";
                result.add(encapsulate); 
                // add left
                String addLeft = "()" + s; 
                if (!(result.contains(addLeft))) {
                    result.add(addLeft); 
                }
                // add right
                String addRight = s + "()"; 
                if (!(result.contains(addRight))) {
                    result.add(addRight); 
                }
            }
        }
        return result; 
    }
}