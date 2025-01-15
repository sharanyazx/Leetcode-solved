<h2><a href="https://leetcode.com/problems/minimize-xor">2429. Minimize XOR</a></h2><h3>Medium</h3><hr><p>Given two positive integers <code>num1</code> and <code>num2</code>, find the positive integer <code>x</code> such that:</p>

<ul>
	<li><code>x</code> has the same number of set bits as <code>num2</code>, and</li>
	<li>The value <code>x XOR num1</code> is <strong>minimal</strong>.</li>
</ul>

<p>Note that <code>XOR</code> is the bitwise XOR operation.</p>

<p>Return <em>the integer </em><code>x</code>. The test cases are generated such that <code>x</code> is <strong>uniquely determined</strong>.</p>

<p>The number of <strong>set bits</strong> of an integer is the number of <code>1</code>&#39;s in its binary representation.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> num1 = 3, num2 = 5
<strong>Output:</strong> 3
<strong>Explanation:</strong>
The binary representations of num1 and num2 are 0011 and 0101, respectively.
The integer <strong>3</strong> has the same number of set bits as num2, and the value <code>3 XOR 3 = 0</code> is minimal.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> num1 = 1, num2 = 12
<strong>Output:</strong> 3
<strong>Explanation:</strong>
The binary representations of num1 and num2 are 0001 and 1100, respectively.
The integer <strong>3</strong> has the same number of set bits as num2, and the value <code>3 XOR 1 = 2</code> is minimal.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num1, num2 &lt;= 10<sup>9</sup></code></li>
</ul>






### Problem Explanation:

The task is to find an integer `x` in the range `[0, num2]` such that the XOR of `num1` and `x` is minimized. However, there is a constraint: the number of set bits (1s) in the binary representation of `x` must be equal to the number of set bits in `num2`. 

This problem requires a strategic approach to select the bits for `x` such that:
- The XOR between `num1` and `x` is minimized.
- The number of set bits in `x` is exactly the same as the number of set bits in `num2`.

### Approach:

1. **Count the number of set bits in `num2`**: This is a crucial step because the result `x` should have the same number of set bits (1s) as `num2`.
   
   To count the number of set bits in a number, we can use the trick where we repeatedly clear the least significant set bit using the expression `(num2 & (num2 - 1))`. This operation clears the rightmost 1-bit in the binary representation of `num2`, and by counting how many times this operation can be performed, we can determine the number of set bits.

2. **Create a number `x` with the same number of set bits as `num2`**: 
   - Starting from the most significant bit (31st bit for a 32-bit integer), if a bit is set in `num1` and there are still set bits to be placed in `x`, set that bit in `x`.
   - If no more bits need to be set, and we still have set bits to place in `x`, look for positions in `x` where the bit is not set and set it there.
   - Continue this process until all set bits in `num2` have been used.

### Explanation of the Code:

```java
class Solution {

    // Helper function to count the number of set bits in num2
    public int findSetBits(int num2) {
        int counter = 0;
        while (num2 != 0) {
            num2 = (num2 & (num2 - 1));  // Clears the rightmost set bit
            counter++;
        }
        return counter;  // Return the count of set bits in num2
    }

    public int minimizeXor(int num1, int num2) {
        // Step 1: Count the number of set bits in num2
        int numSetBits = findSetBits(num2);
        int result = 0;

        // Step 2: Try to match the set bits in num1 with the result
        // Iterate from the most significant bit (bit 31) down to 0
        for (int i = 31; i >= 0; i--) {
            // Check if the current bit is set in num1 and we still need to set bits in result
            if ((num1 & (1 << i)) != 0 && numSetBits > 0) {
                result |= (1 << i);  // Set the i-th bit in result
                numSetBits--;  // Decrement the remaining set bits
            }
        }

        // Step 3: Set the remaining set bits (if any) in the lowest bits of result
        int index = 0;
        while (numSetBits > 0) {
            if ((result & (1 << index)) == 0) {
                result |= (1 << index);  // Set the i-th bit in result
                numSetBits--;  // Decrement the remaining set bits
            }
            index++;  // Move to the next bit
        }

        // Step 4: Return the result
        return result;
    }
}
```

### Step-by-Step Explanation with Example:

Let’s walk through the code using the example where `num1 = 3` and `num2 = 5`.

1. **Step 1 - Count the set bits in `num2`**:
   - `num2 = 5`, which in binary is `101`.
   - The number of set bits in `num2` is `2` (since there are two `1`s in `101`).
   
   The helper function `findSetBits` will return `2`.

2. **Step 2 - Try to match the set bits in `num1` with the result**:
   - `num1 = 3`, which in binary is `11`.
   - We will iterate from the 31st bit down to the 0th bit.
   
   **Loop through the bits of `num1`**:
   - **i = 31 to 2**: `num1 & (1 << i)` is `0` for these bits, so we don’t set any bits in `result`.
   - **i = 1**: `num1 & (1 << 1)` is `2`, which is non-zero, and we still need to set one more bit (`numSetBits > 0`).
     - We set the 1st bit in `result`, so `result = 2` (binary `10`).
     - We decrement `numSetBits` to `1`.
   - **i = 0**: `num1 & (1 << 0)` is `1`, which is non-zero, and we still need to set one more bit (`numSetBits > 0`).
     - We set the 0th bit in `result`, so `result = 3` (binary `11`).
     - We decrement `numSetBits` to `0`.
   
   At the end of this step, `result = 3` and `numSetBits = 0`.

3. **Step 3 - Set the remaining set bits in the lowest bits of result**:
   - In this example, `numSetBits = 0`, so no more bits need to be set.

4. **Step 4 - Return the result**:
   - The final result is `3`.

Thus, the output for `num1 = 3` and `num2 = 5` is `3`.

### Time Complexity:
- The `findSetBits` function runs in `O(log(num2))` since it iterates through the bits of `num2`.
- The main loop runs from `31` to `0`, which is a constant number of iterations (`O(32)`).
- Therefore, the overall time complexity is **O(32)**, which is effectively constant, since the bit-width of integers is fixed.

### Space Complexity:
- The space complexity is **O(1)**, as we are only using a few integer variables to store results.

### Conclusion:
This approach effectively minimizes the XOR value by strategically setting bits in `x` such that the number of set bits in `x` is equal to the number of set bits in `num2`. The method ensures that the result is as close to `num1` as possible while maintaining the set bit count constraint.
