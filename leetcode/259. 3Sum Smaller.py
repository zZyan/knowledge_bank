class Solution(object):
    def threeSumSmaller(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not nums or len(nums) <= 2: 
            return 0
        
        sNums = sorted(nums)
        
        n = len(nums)
        c = 0
        
        for i, num in enumerate(sNums):
            subTarget = target - num
            
            l = i+1
            r = n - 1
            
            while (l < r):
                if sNums[l] + sNums[r] < subTarget:
                    c += (r-l)
                    l += 1
                else:
                    r -= 1

        return c
