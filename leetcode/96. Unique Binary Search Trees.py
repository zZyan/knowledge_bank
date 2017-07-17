'''
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.
'''

class Solution(object):
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        dp = []
        dp.append(1)
        dp.append(1)
        
        for i in range(2,n+1):
            subTree = 0
            for j in range(i):
                subTree += dp[j] * dp[i-j-1]
            
            # print(subTree)
            dp.append(subTree)
        
        return dp[-1]
                
        
