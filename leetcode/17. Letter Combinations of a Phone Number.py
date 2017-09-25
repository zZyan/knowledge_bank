class Solution(object):
    
#     or use a reduce function 
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        
        if not digits or len(digits) == 0:
            return []
        
        
        dDict = {'1': '*', '2':'abc', '3':'def', '4':'ghi', '5':'jkl', '6':'mno', '7':'pqrs', '8':'tuv', '9':'wxyz', '0':' '}
        
#         acc: result from previous iteration; d: iterate through digits 
        retList = reduce(lambda acc, d: [x+y for x in acc for y in dDict[d]], digits, [''] )
        return retList
        
            
    
    
    dDict = {1: '*', 2:'abc', 3:'def', 4:'ghi', 5:'jkl', 6:'mno', 7:'pqrs', 8:'tuv', 9:'wxyz', 0:' '}
    
    # iterative 
    def validNumber(self, char):
        """
        :type: single character
        :rtype: int
        """
        if char >= "0" and char <= "9":
            return int(char)
        
        else:
            return -1
        
        
    def appendLetter(self, oriList, d):
        """
        :type: oriList from last iteration
        :rtype: a new list
        """
        
        newList = []
        for item in oriList: 
            for c in self.dDict[d]:
                newList.append(item+c)
        
        return newList
        
    
#     def letterCombinations(self, digits):
#         """
#         :type digits: str
#         :rtype: List[str]
#         """
        
#         if not digits or len(digits) == 0:
#             return []
        
#         oriList = ['']
#         for c in digits:
#             d = self.validNumber(c)
#             if d == -1:
#                 return []
            
#             oriList = self.appendLetter(oriList, d)
        
#         return oriList
    
    
