class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        res = [1] * len(nums)

        total = 1

        for i in range(len(nums)):
            res[i] = total
            total *= nums[i]

        total2 = 1

        for i in range(len(nums) - 1, -1, -1):
            res[i] *= total2
            total2 *= nums[i]

        return res