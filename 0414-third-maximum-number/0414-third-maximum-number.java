class Solution {
    public int thirdMax(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        boolean aa = false;
        boolean bb = false;
        boolean cc = false;
        for(int n : nums){
            if(n > a || !aa){
                if(aa){
                    if(bb){
                        c = b;
                        cc = true;
                    }else
                        bb = true;
                    b  = a;
                }else
                    aa = true;
                a = n;
            }else if(n > b && n < a || !bb && n < a){
                if(bb){
                    c = b;
                    cc = true;
                }else
                    bb = true;
                b = n;
            }else if(n > c && n < b || !cc && n < b){
                cc = true;
                c = n;
            }
        }

        return !cc ? a : c;
    }
}