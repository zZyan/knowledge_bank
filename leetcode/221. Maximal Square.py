'''
Given a 2D binary matrix filled with 0's and 1's, 
find the largest square containing only 1's and return its area.

note: clarify the input datatype - string
'''
# key: mechanics to derive from previous states
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        
        if not matrix:
            return 0
        
        r = len(matrix)
        c = len(matrix[0])
        
        # scan once to convert all string to int 
        state = [[0] * c for i in range(r)]
        
        res = 0
        for i in range(r):
            state[i][0] = int(matrix[i][0])
            res = max(res, state[i][0])
            
        for j in range(c):
            state[0][j] = int(matrix[0][j])
            res = max(res, state[0][j])

        if res == 0: return 0
        
        # scan row by row
        for i in range(1,r):
            for j in range(1,c):
                if matrix[i][j] == '1':
                    state[i][j] = min(state[i-1][j], min(state[i-1][j-1], state[i][j-1]))+1
                    # print state[i][j] 
                    res = max(res, state[i][j])
        
        return res*res
                    
                    
            
