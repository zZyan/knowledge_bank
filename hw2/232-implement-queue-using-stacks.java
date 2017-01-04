class MyQueue {
    // use two stack, 1st: natural push 2nd: reversed 1st 
    // push to 1st stack
    // pop from 2nd stack, if 2nd is empty, add reversed 1st 
    // peek similar as pop
    
    Stack<Integer> stack1 = new Stack<Integer> ();
    Stack<Integer> stack2 = new Stack<Integer> ();
    
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (!stack2.isEmpty()) stack2.pop();
        else {
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
            if (!stack2.isEmpty()) stack2.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if (!stack2.isEmpty()) return stack2.peek();
        else {
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
            if (!stack2.isEmpty()) return stack2.peek();
            return -1;
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}