# dfs through all the points, remember their depth, append to proper depth - slow
# either recurcive or iterative 



# Definition for binary tree with next pointer.
# class TreeLinkNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution:
    def connect(self, root):
        
        if root is None or (root.left is None and root.right is None):
            return
        
        head = dummy = TreeLinkNode(-1)
        
        while root:
            head.next = root.left
            head = head.next or head
            head.next = root.right 
            head = head.next or head 
            
            root = root.next
            if not root:
                root = dummy.next
                head = dummy

    # @param root, a tree link node
    # @return nothing
    def connect(self, root):
        if root is None or (root.left is None and root.right is None):
            return
        # levels = collections.defaultdict(list)
        q = collections.deque()
        q.append((root,0))
        
        pre = TreeLinkNode(0)
        preLevel = -1
        
        while q:
            curr, l = q.popleft()
            print (curr.val, l)
            if l == preLevel:
                pre.next = curr
            
            pre = curr
            preLevel = l
            # levels[l].append(curr)
            
            if curr.left:
                q.append((curr.left, l+1))
            if curr.right:
                q.append((curr.right, l+1))  
        
        return
        
        
    
