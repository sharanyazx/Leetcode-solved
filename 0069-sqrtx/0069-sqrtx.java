class Solution {
    public int mySqrt(int x) {
        if(x==2) return 0;
        int left=1;
        int right=x;
        while(left<=right){
            int mid = left + (right-left) / 2;
            if(mid==x/mid)  return mid;
            else if(mid < x/mid)  left=mid+1;
            else right=mid-1;
        }
        return right;
    }
}