/*
dp:
    up to current point, previous are breakable?
*/

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0){
            return true;
        }
        
        int n = s.length();
        
        if (wordDict == null || wordDict.size() == 0){
            return false;
        }
        
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        
        for (int i = 0; i < n+1; i++){
            for (int j = 0; j < i; j++){
                if (dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        } 
        
        return dp[n];
    }
}