public class Solution {
    public int evalRPN(String[] tokens) {
        /*
        number: push into stack; operators: pop last 2, calculate, push back 
        note
        - to implement stack - Deque<Integer> stack = new LinkedList<Integer>();
        - Integer.parseInt(s); string to integer; 
        */
        int len = tokens.length;

        if (tokens == null || len == 0) return 0;
        
        // Stack<Integer> stack = new Stack<Integer>();
        //use deque for Stack
        Deque <Integer> stack = new LinkedList<Integer>();
        //validate input
        for (int i = 0; i<len; i++){
            switch (tokens[i]){
                case "+":
                    stack.offerLast(stack.pollLast()+stack.pollLast());
                    break;
                case "-":
                    int a = stack.pollLast();
                    int b = stack.pollLast();
                    stack.offerLast(b-a);
                    break;
                case "*":
                    stack.offerLast(stack.pollLast() * stack.pollLast());
                    break;
                case "/":
                    a = stack.pollLast();
                    b = stack.pollLast();
                    stack.offerLast(b/a);
                    break;
                default:
                    stack.offerLast(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return stack.pollLast();
    }
}