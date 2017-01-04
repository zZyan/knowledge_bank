/*
lemma: container formed with min(a,b) and any in betwee a and b, -> less
therefore, move the min(a,b) 
*/
public class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        
        int start = 0, end = height.length-1;
        int maxArea = 0;
        while (start<end){
            maxArea = Math.max(Math.min(height[start], height[end])*(end-start), maxArea);
            if (height[start]<height[end]){
                start++;
            }
            else {
                end -- ;
            }
        }
        
        return maxArea;
        
    }
}