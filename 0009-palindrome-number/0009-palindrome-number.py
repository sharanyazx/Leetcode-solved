class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x<0:
            return False
        else:
            rev=int(str(x)[::-1])
            
        if(x==rev): return True
        else: return False
        