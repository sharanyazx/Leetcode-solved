class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 1) {
                result ^= entry.getKey();
            }
        }

        return result;
    }
}
