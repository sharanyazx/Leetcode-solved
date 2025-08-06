class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1)
        return true;
        long first=1,last=num/2;
        while(first<=last){
            long mid = first+(last-first)/2;
            long sq = mid*mid;
            if(sq==num)
            return true;
            if(sq<num)
            first = mid+1;
            else
            last=mid-1;
           }
           return false;

    }
}