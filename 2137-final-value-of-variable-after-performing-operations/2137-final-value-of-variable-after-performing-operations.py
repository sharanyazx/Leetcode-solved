class Solution:
    def finalValueAfterOperations(self, operations: List[str]) -> int:
        X=0
        for i in operations:
            if(i in ("X++","++X")):
                X+=1
            elif(i in ("X--","--X")):
                X-=1
        return X
        