class Solution {
    public int differenceOfSums(int n, int m) {
        int a=0;
        int b=0;
        for(int i=0;i<=n;i++){
            if(i%m==0){
                a=a+i;
            }
            else{
                b=b+i;
            }
              
        }
      
          return b-a;
    }
}