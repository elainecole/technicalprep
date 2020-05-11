package prep;

import java.util.Stack;

/**
 * 3.5 Sort Stack
 * 5/7/20
 */
public class SortStack {
    public static void main(String[] args) {
        System.out.println("Initializing Technical Prep");
        Stack<Integer> s = new Stack<Integer>(); 
        s.push(2);
        s.push(4); 
        s.push(1); 
        s.push(3); 
        s.push(5); 
        Stack<Integer> r = sortStack(s);
        System.out.println("s Stack: ");
        System.out.println(r.pop()); 
        System.out.println(r.pop()); 
        System.out.println(r.pop()); 
        System.out.println(r.pop()); 
        System.out.println(r.pop()); 
    }

    static Stack<Integer> sortStack(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>(); 
        while (!s.isEmpty()) {
            int temp = s.pop(); 
            while (!r.isEmpty() && r.peek() > temp) {
                s.push(r.pop()); 
            }
            r.push(temp); 
        }
        while (!r.isEmpty()) {
            s.push(r.pop()); 
        }
        return s; 
    }
}