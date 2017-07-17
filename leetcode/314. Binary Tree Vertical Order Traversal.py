'''
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.
'''

class Solution(object):
    def verticalOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        # dictionary: column id and list of number
        # pre order traversal, add to dictionary
       
        if root == None:
            return []
        
        colDict = collections.defaultdict(list)
        queue = []
        queue.append([root,0])
        colDict[0].append(root.val)
        
        while len(queue) > 0: 
            curr, index = queue.pop(0)
            if curr.left != None:
                queue.append([curr.left, index-1])
                colDict[index-1].append(curr.left.val)
                
            if curr.right != None:
                queue.append([curr.right, index+1])
                colDict[index+1].append(curr.right.val)
        
        return [colDict[i] for i in sorted(colDict)]
