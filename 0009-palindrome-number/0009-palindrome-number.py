# class Solution:
#     def isPalindrome(self, x: int) -> bool:
#         if x<0:
#             return False
#         else:
#             rev=int(str(x)[::-1])
            
#         if(x==rev): return True
#         else: return False
class Solution:
    def isPalindrome(self, x: int) -> bool:
        a=str(x)
        if a == a[::-1]:
            return True
        else:
            return False
            
         