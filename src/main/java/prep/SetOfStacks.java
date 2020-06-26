package prep;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * 3.3 Set of Stacks 
 * 5/5/20
 */
public class SetOfStacks<T> {
    private static class Stack {
        public static class StackNode {
            private StackNode next; 
            private int data; 

            public StackNode(int data) {
                this.data = data; 
            }
        }
        public StackNode top;
        public int size = 0; 
        
        public int pop() {
            if (top == null) throw new EmptyStackException(); 
            int element = top.data; 
            top = top.next; 
            size--; 
            return element; 
        }

        public void push(int element) {
            StackNode t = new StackNode(element); 
            t.next = top; 
            top = t; 
            size++; 
        }

        // public int peek() {
        //     if (top == null) throw new EmptyStackException(); 
        //     return top.data; 
        // }

        public boolean isEmpty() {
            // or if size == 0
            return top == null; 
        }
    }
    int capacity; 
    ArrayList<Stack> stacks = new ArrayList<Stack>(); 
    int currStack;

    public SetOfStacks(int capacity) {
        this.capacity = capacity; 
        this.currStack = 0; 
    }

    public static void main(String[] args) {
        System.out.println("Initializing Technical Prep");
        System.out.println("SetOfStacks (capacity 4): ");
        SetOfStacks<Integer> plateStack = new SetOfStacks<Integer>(4); 
        System.out.println("plateStack size: " + plateStack.stacks.size()); 
        plateStack.push(1); 
        plateStack.push(2); 
        System.out.println("plateStack size: " + plateStack.stacks.size()); 
        plateStack.push(3); 
        plateStack.push(4); 
        System.out.println("plateStack size: " + plateStack.stacks.size()); 
        plateStack.push(5); 
        System.out.println("plateStack size: " + plateStack.stacks.size()); 
        plateStack.pop(); 
        System.out.println("plateStack size: " + plateStack.stacks.size()); 
        plateStack.push(5); 
        plateStack.push(6); 
        plateStack.push(7); 
        System.out.println("plateStack size: " + plateStack.stacks.size()); 
        plateStack.push(8); 
        System.out.println("plateStack size: " + plateStack.stacks.size()); 
        plateStack.push(9); 
        System.out.println("plateStack size: " + plateStack.stacks.size()); 
    }

    public int pop() { 
       int ret = stacks.get(currStack).pop();
       if (stacks.get(currStack).isEmpty()) {
           // this is end of stack 
           stacks.remove(stacks.get(currStack)); 
           currStack--; 
       }
       return ret; 
    }

    public boolean isFull() {
        return stacks.get(currStack).size == capacity; 
    }

    public void push(int element) {
        if (stacks.isEmpty()) {
            System.out.println("Stacks was empty");
            Stack newStack = new Stack(); 
            newStack.push(element);
            stacks.add(newStack); 
            System.out.println("curr stack size: " + stacks.get(currStack).size);
            
        } else if (isFull()) {
            System.out.println("Stacks was full");

            // create new stack at end of stacks
            Stack newCurrStack = new Stack(); 
            currStack++; 
            newCurrStack.push(element); 
            stacks.add(newCurrStack); 
            System.out.println("curr stack size: " + stacks.get(currStack).size);

        } else {
            stacks.get(currStack).push(element);
            System.out.println("curr stack size: " + stacks.get(currStack).size);
        }
    }
}