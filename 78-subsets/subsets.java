import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] arr, int index, List<Integer> current, List<List<Integer>>  result) {
        if (index == arr.length) {
            result.add(new ArrayList<>(current));  // Store a copy
            return;
        }

        // Include the current element
        current.add(arr[index]);
        helper(arr, index + 1, current, result);

        // Exclude the current element (backtrack)
        current.remove(current.size() - 1);
        helper(arr, index + 1, current, result);
    }
}
