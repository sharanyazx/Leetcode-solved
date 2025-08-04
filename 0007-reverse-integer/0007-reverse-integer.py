class Solution:
    def reverse(self, x: int) -> int:
        if x < 0:
            reversed_num = -int(str(-x)[::-1])
        else:
            reversed_num = int(str(x)[::-1])
        
        # Check for 32-bit signed integer range
        if reversed_num < -2**31 or reversed_num > 2**31 - 1:
            return 0
        return reversed_num
