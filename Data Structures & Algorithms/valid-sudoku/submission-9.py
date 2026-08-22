class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

        seen = set()
        
        for i in range(len(board)):
            for j in range(len(board[0])):

                val = board[i][j];

                if val == ".":
                    continue

                row = val + "Row" + str(i)
                col = val + "Col" + str(j)
                quad = val + "Quadrant" +  str(i // 3) + "," + str(j // 3)

                if row in seen or col in seen or quad in seen: 
                    return False
               
                seen.add(row)
                seen.add(col)
                seen.add(quad)

        return True
                
                
