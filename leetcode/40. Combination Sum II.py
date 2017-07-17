'''
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
'''

class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates.sort()
        return self.helper(candidates, 0, target)
        
    
    def helper(self, candidates, ind, target):
        if target == 0:
            return [[]]
        
        res = []
        
        for i in xrange(ind, len(candidates)):
            if i != ind and candidates[i] == candidates[i-1]:
                continue
            
            if candidates[i] > target:
                break
            
            for r in self.helper(candidates, i+1, target - candidates[i]):
                res.append([candidates[i]] + r)
                
        return res 
            
        
