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

        