# Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
# dfs easy way
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        
        if not grid or len(grid) == 0 or len(grid[0]) == 0: 
            return 0
        
        def dfs(i, j):
            if i >= 0 and i < len(grid) and j >= 0 and j <len(grid[0]) and grid[i][j] == '1':
                grid[i][j] = -1

                map(dfs, (i-1, i+1, i, i), (j, j, j-1, j+1))
                
                return 1
            
            return 0
        
       
        return sum(dfs(i,j) for i in range(len(grid)) for j in range(len(grid[0])))
        
        
