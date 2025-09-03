# Last updated: 9/3/2025, 10:46:50 AM
class Solution:
    def smallestEvenMultiple(self, n: int) -> int:
        if n%2==0:
            return n
        else :
            return 2*n
        