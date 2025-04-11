class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> Freq = new HashMap<>();
        Freq.put(0, 1);
        int currentSum = 0, count = 0;

        for (int num : nums) {
            currentSum += num;

            if (Freq.containsKey(currentSum - k)) {
                count += Freq.get(currentSum - k);
            }

          Freq.put(currentSum, Freq.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
