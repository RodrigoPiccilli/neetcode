class Solution:
    def search(self, nums: List[int], target: int) -> int:

        l, r = 0, len(nums) - 1

        while l < r:

            mid = l + (r - l) // 2

            if nums[mid] > nums[r]:
                l = mid + 1
            else:
                r = mid

        res = self.helper(0, l - 1, nums, target)

        if res == -1:
            res = self.helper(l, len(nums) - 1, nums, target)

        return res

    def helper(self, start, stop, nums, target):

        l, r = start, stop

        while l <= r:

            mid = l + (r - l) // 2

            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                l = mid + 1
            else:
                r = mid - 1

        return -1



        