class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:

        nums.sort()

        res = []

        for idx in range(len(nums)):

            if nums[idx] > 0:
                break

            if idx > 0 and nums[idx] == nums[idx - 1]:
                continue
            
            l, r = idx + 1, len(nums) - 1

            while l < r:

                curr = nums[l] + nums[r] + nums[idx]

                if curr == 0:
                    res.append([nums[idx], nums[l], nums[r]])
                    l += 1
                    r -= 1

                    while l < r and nums[l - 1] == nums[l]:
                        l += 1

                elif curr < 0:
                    l += 1
                else:
                    r -= 1

        
        return res
                

                




