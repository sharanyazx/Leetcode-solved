class Solution:
    def defangIPaddr(self, address: str) -> str:
        add=address.replace('.',"[.]")
        return add
        