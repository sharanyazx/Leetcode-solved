# Last updated: 9/3/2025, 10:46:30 AM
class Solution:
    def doesValidArrayExist(self, derived: List[int]) -> bool:
        result = 0
        for n in derived:
            result ^= n
        return result == 0
