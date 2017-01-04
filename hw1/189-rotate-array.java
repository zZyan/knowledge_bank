public class Solution {
    public void rotate(int[] nums, int k) {
        //edge case
        int length = nums.length;
        if (length <2) return;
        k = k%length;
        if (k == 0) return;
        
        //O(n), extra space, copy over
        //O(n), O(1) extra space, k space? 
        int[] temp = new int[k];
        
        for (int i = 0; i<k; i++){
            temp[i] = nums[length-k+i];
        }
        
        for (int j = length-k-1; j>=0; j--){
            nums[j+k] = nums[j]; 
        }
        
        for (int i = 0; i<k; i++){
            nums[i] = temp[i];
        }
        
        return;
        
    }
}