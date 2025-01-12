class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
 
 // With the built in function

/*class Solution {
    public int mySqrt(int x) {
        double res=Math.pow(x,0.5);
        return (int) res;
    }
}*/
