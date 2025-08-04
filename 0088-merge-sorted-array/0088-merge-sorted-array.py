class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        # Replace the last n elements in nums1 with nums2
        nums1[m:] = nums2
        nums1.sort()
