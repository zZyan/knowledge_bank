class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        
        if not matrix or len(matrix) == 0:
            return False
        
        r = 0 
        c = len(matrix[0]) - 1
        
        while r < len(matrix) and c >= 0:
            if (matrix[r][c]) == target:
                return True
            elif matrix[r][c] > target:
                c -= 1
            else:
                r += 1
        
        return False 
