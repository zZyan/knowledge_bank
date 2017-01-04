class MyStack {
    // use two queues to make pop and peek O(1)
    // Push element x onto stack
    Queue<Integer> q1 = new ArrayDeque<Integer>();
    Queue<Integer> q2 = new ArrayDeque<Integer>();
    
    public void push(int x) {
        if(!q1.isEmpty()){
            q2.offer(x);
            while(!q1.isEmpty()){
                q2.offer(q1.poll());
            }
        }
        else {
            q1.offer(x);
            while(!q2.isEmpty()){
                q1.offer(q2.poll());
            }       
        }

    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!q1.isEmpty()) q1.poll();
        else if (!q2.isEmpty()) q2.poll();
    }

    // Get the top element.
    public int top() {
        if (!q1.isEmpty()) return q1.peek();
        else if (!q2.isEmpty()) return q2.peek();
        else return -1;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty(); 
    }
}