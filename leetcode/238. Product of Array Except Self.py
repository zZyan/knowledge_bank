# two pass, product of all the numbers before, product of number after

class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        tmp = 1
        res = []
        for i in range(len(nums)):
            res.append(tmp)
            tmp = tmp * nums[i]
        
        tmp = 1
        for i in range(len(nums)-1, -1, -1):
            res[i] = res[i]*tmp
            tmp = tmp * nums[i]
        
        return res
            
        
        
        
