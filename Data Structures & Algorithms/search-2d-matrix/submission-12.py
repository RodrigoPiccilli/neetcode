class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        totalLen = len(matrix) * len(matrix[0])

        l, r = 0, totalLen - 1

        while l <= r:

            mid = l + (r - l) // 2

            row = mid // len(matrix[0]);
            col = mid % len(matrix[0]);

            if target == matrix[row][col]:
                return True
            elif target > matrix[row][col]:
                l = mid + 1
            else:
                r = mid - 1

        return False

        