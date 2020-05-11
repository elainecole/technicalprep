package prep;

import java.util.EmptyStackException;

/**
 * 3.4 Queues via Stacks
 * 5/5/20
 */
public class MyQueue<T> {
    private class Stack {
        private class StackNode {
            private StackNode next; 
            private T data; 

            public StackNode(T data) {
                this.data = data; 
                this.next = null; 
            }
        }
        public StackNode top;
        
        public T pop() {
            if (top == null) throw new EmptyStackException(); 
            final T element = top.data; 
            top = top.next; 
            return element; 
        }

        public void push(final T element) {
            final StackNode t = new StackNode(element); 
            t.next = top; 
            top = t; 
        }

        public T peek() {
            if (top == null) throw new EmptyStackException(); 
            return top.data; 
        }

        public boolean isEmpty() {
            return top == null; 
        }
    }
    Stack forward = new Stack(); 
    Stack backward = new Stack(); 

    public static void main(final String[] args) throws Exception {
        System.out.println("Initializing Technical Prep");
        final MyQueue<Integer> queue = new MyQueue<Integer>(); 
        System.out.println("MQueue:");
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("MQueue peek: " + queue.peek());
        System.out.println("MQueue remove: " + queue.remove());
        System.out.println("MQueue peek: " + queue.peek());
    }

    public void add(final T element) {
        forward.push(element); 
        addEnd(element, backward); 
    }
    public T remove() {
        backward.pop(); 
        return removeEnd(forward); 
    }

    public void addEnd(final T element, final Stack s) {
        final Stack.StackNode added = s.new StackNode(element);
        if (s.top == null) {
            s.top = added; 
            return; 
        }
        Stack.StackNode runner = s.top;
        while (runner.next != null) {
            runner = runner.next; 
        }
        added.data = element; 
        runner.next = added; 
    }
    public T removeEnd(final Stack s) {
        if (s.top.next == null) return s.pop(); 
        Stack.StackNode runner = s.top;
        T ret; 
        while (runner.next.next != null) {
            runner = runner.next; 
        }
        ret = runner.next.data; 
        runner.next = null; 
        return ret;
    }

    public boolean isEmpty() {
        return forward.isEmpty(); 
    }

    public T peek() {
        return backward.peek(); 
    }
}