# if create default dictionary with list, dic = dictdefault(list)
# use dictionary

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        hm = {}
        
        for i in range(len(nums)):
            remain = target - nums[i]
            if remain in hm:
                return [hm[remain], i]
            hm[nums[i]] = i
        
        
