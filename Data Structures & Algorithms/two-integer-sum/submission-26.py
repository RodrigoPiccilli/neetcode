class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        freq = {}

        for i, v in enumerate(nums):

            comp = target - v

            if comp in freq:
                return [freq[comp], i]

            freq[v] = i

        return [-1, -1]

