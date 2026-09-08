class Solution:
    def maxArea(self, heights: List[int]) -> int:

        # If left bar is lower, move l++
        # If right bar is lower, reduce r--

        l, r = 0, len(heights) - 1

        maxArea = 0

        while l < r:

            constraint = min(heights[l], heights[r])

            maxArea = max(maxArea, (r - l) * constraint)

            if heights[l] < heights[r]:
                l += 1
            else:
                r -= 1

        return maxArea

        