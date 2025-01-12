class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        oper =0
        for num in nums:
            rem= num %3
            if rem==1:
                oper+=1
            elif rem==2:
                oper+=1
        return oper
        