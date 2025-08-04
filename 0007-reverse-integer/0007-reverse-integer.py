class Solution:
    def reverse(self, x: int) -> int:
        INT_MIN, INT_MAX = -2**31, 2**31 - 1
        res = 0
        num = abs(x)
        
        while num:
            digit = num % 10
            num //= 10

            # Check overflow
            if res > (INT_MAX - digit) // 10:
                return 0

            res = res * 10 + digit
        
        return res if x >= 0 else -res
