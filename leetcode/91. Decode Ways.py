# key: validate the substring
# combined number: only when pre != '0' and 10 ~ 26
class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        if not s or s.startswith('0'):
            return 0
        
        l = len(s)
        dp = [0] * (l+1)
        dp[0] = 1
        dp[1] = 1 
        
        for i in range(1,l):
            tempSum = 0
            if s[i] != '0':
                tempSum = dp[i]
            
            combined = int(s[i-1:i+1]) 
            
            if s[i-1] != '0' and combined > 0 and combined < 27:
                tempSum += dp[i-1]
            
            dp[i+1] = tempSum
        
        print dp
        return dp[-1]
            
        
