'''
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
'''
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        diag = []
        revDiag = []
                    
        for i in range(9):
            row = []
            col = []
            cube = []
#             if board[i][i] != '.':
#                 if board[i][i] in diag:
#                     print diag
#                     print ("diag")
#                     print (i*9+j)
#                     return False 
#                 diag.append(board[i][i])
#             if board[i][8-i] != '.':
#                 if board[i][8-i] in revDiag:
#                     print("rev")
#                     print (i*9+j)

#                     return False
#                 diag.append(board[i][8-i])
                
            for j in range(9):
                rowCurr = board[i][j]
                colCurr = board[j][i] 
                cubeCurr = board[int(i/3)*3 + j/3][(i%3)*3 + j%3]
                if rowCurr != '.':
                    if rowCurr in row:
                        print("row")
                        print (i*9+j)
                        return False
                    row.append(rowCurr)
                    
                if colCurr!= '.':
                    if colCurr in col:
                        print("col")
                        print (i*9+j)
                        return False
                    col.append(colCurr)

                if cubeCurr!= '.':
                    if cubeCurr in cube:
                        print ("cube")
                        print (i*9+j)
                        return False
                    cube.append(cubeCurr)
            
