# Follow up for H-Index: What if the citations array is sorted in ascending order? 
#Could you optimize your algorithm

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        
        # two pointers
        left = 0
        N = len(citations)
        mid = left
        right = N-1
        
        while left <= right:
            mid = left + ((right - left)>>1)
            
            if citations[mid] == N - mid: 
                return N-mid
            elif citations[mid] > N-mid:
                right = mid-1
            else:
                left = mid+1
        
        return N - left 
        


        
