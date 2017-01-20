/*
use dp to track current max
    either add the i-2 or take i-1 and skip itself
*/


public class Solution {
    public int rob(int[] nums) {
        //corner case
        if (nums == null || nums.length == 0){
            return 0;
        }

        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        // int[] dp = new int[n+1];
        //use rolling array
        int[]dp = new int[3];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < n; i++){
            dp[i%3] = Math.max(dp[(i-2)%3] + nums[i], dp[(i-1)%3]);
        }
        
        return Math.max(Math.max(dp[0], dp[1]), dp[2]);
    }
}