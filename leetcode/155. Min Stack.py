'''
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
'''

class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack =[]
        self.minStack =[]
        

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.stack.append(x)
        if len(self.minStack)==0 or x <= self.minStack[-1]:
            self.minStack.append(x)
        

    def pop(self):
        """
        :rtype: void
        """
        if self.stack[-1] == self.minStack[-1]:
            self.minStack.pop()
        self.stack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
