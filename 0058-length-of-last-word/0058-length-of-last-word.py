class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        words = (s.split()[::-1])
        return len(words[0])