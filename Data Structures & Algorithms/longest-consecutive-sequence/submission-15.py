class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:

        res = 0

        # 1. Store values in the list in a set
        vals = set(nums)

        # 2. Iterate through input
        for n in vals:
            
            # Keep track of local result
            localRes = 0

            # Check if start of sequence
            if n - 1 not in vals:
                # If start of sequence, increment the count as 
                # long as the next value is present in our set.                
                while n + localRes in vals:
                    localRes += 1

                res = max(localRes, res)

        return res
