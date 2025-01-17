class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length - 1;
        int left = 0;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            int res[] = { left + 1, right + 1 };
            if (target == sum)
                return res;
            else if (sum < target)
                left++;
            else
                right--;

        }
        int[] em = { -1, -1 };
        return em;
    }

}
