class Solution:
    def reverseVowels(self, s: str) -> str:
        if not s:
            return s
        vowels = "aeiouAEIOU"
        chars = list(s)
        start, end = 0, len(chars) - 1

        while start < end:
            while start < end and chars[start] not in vowels:
                start += 1
            while start < end and chars[end] not in vowels:
                end -= 1
            chars[start], chars[end] = chars[end], chars[start]
            start += 1
            end -= 1
        
        return ''.join(chars)

