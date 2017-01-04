/*
stack:
    descending order, peekLast to find secured lower height
    note: 
        current, high; before: low; even before: high
        save the height for all three, save the index for two boundaries 

*/

public class Solution {
    public int trap(int[] height) {
        //corner 
        if (height.length == 0 || height.length == 1) return 0;
        
        //stack to save the left boundary, descending order
        Deque<Integer> stack = new ArrayDeque<Integer>();
        
        int current = 0;
        int sum = 0;
        while (current < height.length){
            // System.out.println(current);
            int cHeight = height[current];
            while (!stack.isEmpty() && height[stack.peekLast()]<cHeight){
                int lowest = stack.pollLast();
                int dip = height[lowest];
                if (!stack.isEmpty()){
                    // add to the sum    
                    int left = stack.peekLast();
                    int lHeight = height[left];
                    sum = sum + (Math.min(lHeight, cHeight)-dip) * (current - left -1);
                }
            }
            stack.offerLast(current);
            current++;
        }
        
        return sum;
    }
}