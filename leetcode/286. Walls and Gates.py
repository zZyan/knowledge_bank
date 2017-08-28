# dfs
class Solution(object):
    # four directions 
    directions = [(-1,0),(1,0),(0,-1),(0,1)]
    
    def wallsAndGates(self, rooms):
        """
        :type rooms: List[List[int]]
        :rtype: void Do not return anything, modify rooms in-place instead.
        """
                
        if not rooms:
            return
        # modify on a new list 
        
        for i in range(len(rooms)):
            for j in range(len(rooms[0])):
                if (rooms[i][j]) == 0:
                    rooms = self.dfs(rooms,i,j,0)
        
        # return rooms
                       
                    
    def dfs(self,rooms, i, j, step):
        if i >= len(rooms) or i < 0 or j >= len(rooms[0]) or j < 0 or rooms[i][j] < step:
            return rooms
            
        rooms[i][j] = step
        
        for d in self.directions:
            rooms = self.dfs(rooms,i+d[0], j+d[1], step+1)
        
        return rooms
        
        
