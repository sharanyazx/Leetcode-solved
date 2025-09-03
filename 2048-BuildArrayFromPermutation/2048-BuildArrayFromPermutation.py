# Last updated: 9/3/2025, 10:47:07 AM
class Solution:
    def buildArray(self, nums: list[int]) -> list[int]:
        ans = [0] * len(nums)
        for i in range(len(nums)):
            ans[i] = nums[nums[i]]
        return ans
