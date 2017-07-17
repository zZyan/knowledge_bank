'''
Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression. 
You can always assume that the given expression is valid and only consists of 
digits 0-9, ?, :, T and F (T and F represent True and False respectively).
Input: "T?2:3"
Output: "2"
'''
class Solution(object):
    def parseTernary(self, expression):
        """
        :type expression: str
        :rtype: str
        """
        if expression == None or len(expression) < 2:
            return expression
        
        values = []
        symStack = []
        
        i = len(expression) - 1
        while i > 0:
            curr = expression[i]
            if curr == ':':
                i -= 1
            elif curr == '?':
                i -= 1
                if len(values) == 0:
                    return ""
                elif len(values) == 1:
                    return values[0]
                
                if expression[i] == 'T':
                    values.pop(-2)
                else:
                    values.pop(-1)
                i -= 1
            else:
                values.append(curr)
                i -= 1
        
        return values[0]
        
'''
def parseTernary(self, expression):
    stack = []
    for c in reversed(expression):
        stack.append(c)
        if stack[-2:-1] == ['?']:
            stack[-5:] = stack[-3 if stack[-1] == 'T' else -5]
    return stack[0]
'''
