'''
Given two strings S and T, determine if they are both one edit distance apart.

'''

class Solution(object):
    def isOneEditDistance(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
#         define s is shorter one
        if abs(len(s) - len(t)) > 1:
            return False
        
#         can directly compare string 
        for i in range(min(len(s), len(t))):
            if s[i] != t[i]:
                return s[i + (1 if len(s) >= len(t) else 0):] == t[i + (1 if len(s) <= len(t) else 0):]
    
        return abs(len(s) - len(t)) == 1
