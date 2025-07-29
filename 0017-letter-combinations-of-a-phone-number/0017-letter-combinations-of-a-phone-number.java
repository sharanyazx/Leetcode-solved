class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        // Step 1: Map digits to corresponding letters
        Map<Character, String> phoneMap = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );

        // Step 2: Initialize queue with empty string
        List<String> result = new ArrayList<>();
        result.add("");

        // Step 3: For each digit, expand the existing combinations
        for (char digit : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            String letters = phoneMap.get(digit);  // e.g., "abc"

            for (String combination : result) {
                for (char letter : letters.toCharArray()) {
                    temp.add(combination + letter);
                }
            }

            // Replace the result list with the new list of combinations
            result = temp;
        }

        return result;
    }
}
