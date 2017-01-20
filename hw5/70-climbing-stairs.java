/*
use dp:
    curre
*/

public class Solution {
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        
        //use rolling array
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i < n+1; i++){
            dp[i%3] = dp[(i-1)%3] + dp[(i-2)%3];
        }
        
        return dp[n%3];
        
    }
}