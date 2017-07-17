'''
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
'''
class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        if s == None or s == '' or s.strip()=='':
            return ''
        
        s = s.strip()
        if len(s)==1:
            return s
        
        sList = s.split()
        sList.reverse() #in place
        
        # return sList.join(' ')
        return ' '.join(sList)
