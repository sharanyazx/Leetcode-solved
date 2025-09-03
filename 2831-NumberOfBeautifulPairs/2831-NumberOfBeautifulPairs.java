// Last updated: 9/3/2025, 10:46:25 AM
public class Solution {

    // Main function to count beautiful pairs
    public int countBeautifulPairs(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int first = getFirstDigit(nums[i]);

            for (int j = i + 1; j < nums.length; j++) {
                int last = nums[j] % 10;

                if (gcd(first, last) == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    // Function to get the first digit of a number
    private int getFirstDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }

    // Function to compute the GCD of two numbers
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
