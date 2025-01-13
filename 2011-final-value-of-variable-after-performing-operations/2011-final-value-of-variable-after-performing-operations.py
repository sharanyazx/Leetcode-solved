class Solution:
    def finalValueAfterOperations(self, operations: List[str]) -> int:
        X=0
        for i in operations:
            if "++" in i:
                X+=1
            elif "--" in i:
                X-=1
        return X
            
        #  if(i in ("X++","++X")):
        #         X+=1
        #     elif(i in ("X--","--X")):
        #         X-=1
        # return X
        
        