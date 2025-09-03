// Last updated: 9/3/2025, 10:47:50 AM
class Solution {
    public int numberOfSteps(int num) {
        int step=0;
        while(num!=0){
            if(num%2==0){
                num/=2;
            }
            else{
                num-=1;
            }
            step++;
        }
        return step;
    }
}