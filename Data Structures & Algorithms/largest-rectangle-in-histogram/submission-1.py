class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:

        stack = []

        res = 0

        for right_idx, height in enumerate(heights):

            while stack and height < stack[-1][1]:
                old_top = stack.pop()
                
                left_idx = -1

                if stack:
                    left_idx = stack[-1][0]

                area = old_top[1] * (right_idx - left_idx - 1)
                res = max(res, area)

            stack.append((right_idx, height))


        while stack:
            old_top = stack.pop()

            left_idx = -1

            if stack:
                left_idx = stack[-1][0]

            area = old_top[1] * (len(heights) - left_idx - 1)
            res = max(res, area)

        return res



        