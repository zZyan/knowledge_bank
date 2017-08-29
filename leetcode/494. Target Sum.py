'''
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. 
For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.
'''

# dfs, TLE
# dp
class Solution(object):
    def findTargetSumWays(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        if not nums:
            return 0
        
        # use a dictionary to save previous sum and counts 
        sumMap = collections.defaultdict(int)
        sumMap[0] = 1
        
        
        for n in nums: 
            tempMap = collections.defaultdict(int)
            
            for k, v in sumMap.iteritems():
                tempMap[k-n] += v
                tempMap[k+n] += v
                
            sumMap = tempMap
        
        return sumMap[S]
                
        
        
#         return self.findHelper(nums, S, 0, 0)
 
#     def findHelper(self, nums, S, i, s):
#         if i == len(nums):
#             return 1 if s == S else 0
        
#         return self.findHelper(nums, S, i+1, s+nums[i]) + self.findHelper(nums, S, i+1, s-nums[i]) 
        
