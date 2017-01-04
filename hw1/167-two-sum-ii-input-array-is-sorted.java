public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = {0,0};
        
        if (nums.length<2) return result; 
        
        int front = 0; 
        int back = nums.length-1;
        
        while(front!=back){
            int temp = nums[front]+nums[back];
            if (temp == target) break; 
            else if (temp<target){
                front++;
            }
            
            else back--;
        }
        
        
        
        if (front == back) return result;
        
        else {
            result[0] = front+1;
            result[1] = back+1;
            return result; 
        }
    }
}
