/*
binary search, 
    if both mid && start > target, go second half
    if mid > target && start <target, go first half
    if mid < target && end > target, go second  half
    if mid < target && end < target, go first half 
*/

public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        
        if(n == 0) return -1;
        
        int start = 0; 
        int end = n-1;
        
        while (start<=end){
            int mid = start + ((end-start)>>1);
            // System.out.println(mid);
            // System.out.println(end);
            if (nums[mid] == target) {
                return mid;
            }
                
            else if (nums[start]<=nums[mid]){
                //in order
                if(target<nums[mid] && target>=nums[start]){
                    //keep left
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            } 
            else{
                //rotated, or start == mid
                if(target<=nums[end] && target>nums[mid]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            } 
            
        }
        
        return -1;
    }
}