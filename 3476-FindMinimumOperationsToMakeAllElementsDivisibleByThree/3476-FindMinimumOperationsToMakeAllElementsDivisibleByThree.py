# Last updated: 9/3/2025, 10:46:08 AM
class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        oper=0
        for i in nums:
            if i%3!=0:
                oper=oper+1
                i=i+1
        return oper