class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = defaultdict(list)
        
        for word in strs:
            # Sort the word to use as a key (anagrams will have the same key)
            key = ''.join(sorted(word))
            map[key].append(word)
        
        return list(map.values())
