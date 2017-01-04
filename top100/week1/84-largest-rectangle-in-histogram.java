/*
at every location, scan left and right for equal or higher height
repeted work: each location is scanned multiple times 
    remember relative height compared to left, if higher, keep on
    last taken in: left boundary; trunning back: right boundary - current index
    keep comparing last to be polled and right boundary, push if lower

DS: stack 
	save left boundary
*/

public class Solution {
    public int largestRectangleArea(int[] heights) {
        //corner
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        
        //ds
        Deque<Integer> stack = new ArrayDeque<Integer>();
        
        int max = 0;
        int current = 0, right = 1;
        
        while (current <= heights.length){
            // setting the right boundary
            int rightH = current == heights.length ? 0 : heights[current];
            
            //poll when rightH is right boundary
            while (!stack.isEmpty() && rightH <= heights[stack.peekLast()]){
                //calculate the area, last is left boundary 
                int height = heights[stack.pollLast()];
                // special case, empty stack, 
                int left = stack.isEmpty() ? 0 : stack.peekLast() + 1;
                max = Math.max(max, height*(current-left));
            }
            
            
            //offer when first or current is not boundary
            stack.offerLast(current);
            current++;
        }
        
        return max;
        
    }
}