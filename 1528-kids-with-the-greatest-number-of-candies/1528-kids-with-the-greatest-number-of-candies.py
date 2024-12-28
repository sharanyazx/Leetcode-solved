class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        maxcandy=max(candies)
        result=[]
        for candy in candies:
            if candy + extraCandies>= maxcandy:
                result.append(True)
            else:
                result.append(False)
        return result
        