# Last updated: 9/3/2025, 10:46:16 AM
class Solution:
    def differenceOfSums(self, n: int, m: int) -> int:
        a=0
        b=0
        for i in range(1,n+1):
            if(i%m!=0):
                b=b+i
            else:
                a+=i
        return b-a    

        