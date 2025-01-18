import sys
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        #return max([price - min(prices) for price in prices])
        max=0
        min=sys.maxsize
        for p in prices:
            if(p<min):
                min=p
            elif(p-min>max):
                max=p-min
        return max
        