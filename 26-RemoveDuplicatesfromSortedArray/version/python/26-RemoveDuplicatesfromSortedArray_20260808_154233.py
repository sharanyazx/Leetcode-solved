# Last updated: 8/8/2026, 3:42:33 PM
1class Solution:
2    def removeDuplicates(self, nums: List[int]) -> int:
3        dupe=sorted(set(nums))
4        nums[:len(dupe)]=dupe
5        return len(dupe)
6        