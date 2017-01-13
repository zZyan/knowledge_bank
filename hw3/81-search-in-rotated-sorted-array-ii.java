public class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        
        int start = 0;
        int end = n-1;
        
        while (start<=end){
            int mid = start + ((end-start)>>1);
            
            if (nums[mid] == target){
                return true;
            }
            
            if (nums[start]<nums[mid]){
                //left is in order
                if(target>=nums[start] && target<nums[mid]){
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }
            }
            else if (nums[start]>nums[mid]){
                //left is not inorder
                if (target>nums[mid] && target<=nums[end]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            else {
                start++;
            }
        }
        
        return false;
        
    }
}