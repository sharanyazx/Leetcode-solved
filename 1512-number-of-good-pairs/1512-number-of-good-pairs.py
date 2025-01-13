class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        good=0
        for i in range (0,len(nums)):
            for j in range (i+1,len(nums)):
                if nums[i]==nums[j]:
                    good+=1
        return good
        