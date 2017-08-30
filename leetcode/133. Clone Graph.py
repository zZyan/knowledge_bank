# key: loop through all the neighbors, either dfs or bfs; when to create new node 
# bfs, create new nodes 

# Definition for a undirected graph node
# class UndirectedGraphNode:
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []

class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):
        if not node: 
            return node
        
        stack = []
        graphMap = collections.defaultdict(UndirectedGraphNode)
        visited = set()
        stack.append(node)
        visited.add(node.label)
        graphMap[node.label] = UndirectedGraphNode(node.label)

        while stack:
            curr = stack.pop()
            
            # clone the points
            for nei in curr.neighbors:
                if nei.label not in visited:
                    stack.append(nei)
                    visited.add(nei.label)
                    newNode = UndirectedGraphNode(nei.label)
                    graphMap[nei.label] = newNode

                graphMap[curr.label].neighbors.append(graphMap[nei.label])
                
        return graphMap[node.label]  
            
