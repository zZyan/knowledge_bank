# toppological sort
class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        
        degrees = [0] * numCourses
        graph = collections.defaultdict(list)
        for pre in prerequisites: 
            degrees[pre[0]] += 1
            graph[pre[1]].append(pre[0])
            
        # start from the 0 degree nodes
        queue = collections.deque()
        for i in range(len(degrees)):
            if degrees[i] == 0:
                queue.append(i)
        
        seq = []
        while queue:
            curr = queue.popleft()
            seq.append(curr)
            
            for p in graph[curr]: 
                degrees[p] -= 1
                if degrees[p] == 0:
                    queue.append(p)
        if len(seq) == numCourses:
            return seq
        
        return []
            
            

            
