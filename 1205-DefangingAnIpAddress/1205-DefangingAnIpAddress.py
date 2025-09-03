# Last updated: 9/3/2025, 10:48:12 AM
class Solution:
    def defangIPaddr(self, address: str) -> str:
        add= address.replace('.','[.]')
        return add
        