class Solution {
    public int[] sortEvenOdd(int[] nums) {
        PriorityQueue<Integer> even = new PriorityQueue<>((a, b)->(a - b));
        PriorityQueue<Integer> odd = new PriorityQueue<>((a, b)->(b - a));
        int length = nums.length;
        for (int i = 0; i < length; ++i) {
            if (i % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        
        for (int i = 0; i < length; ++i) {
            if (i % 2 == 0) {
                nums[i] = even.poll();
            } else {
                nums[i] = odd.poll();
            }
        }
        return nums;
    }
}