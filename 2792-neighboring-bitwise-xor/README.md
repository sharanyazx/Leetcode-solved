<h2><a href="https://leetcode.com/problems/neighboring-bitwise-xor">2792. Neighboring Bitwise XOR</a></h2><h3>Medium</h3><hr><p>A <strong>0-indexed</strong> array <code>derived</code> with length <code>n</code> is derived by computing the <strong>bitwise XOR</strong>&nbsp;(&oplus;) of adjacent values in a <strong>binary array</strong> <code>original</code> of length <code>n</code>.</p>

<p>Specifically, for each index <code>i</code> in the range <code>[0, n - 1]</code>:</p>

<ul>
	<li>If <code>i = n - 1</code>, then <code>derived[i] = original[i] &oplus; original[0]</code>.</li>
	<li>Otherwise, <code>derived[i] = original[i] &oplus; original[i + 1]</code>.</li>
</ul>

<p>Given an array <code>derived</code>, your task is to determine whether there exists a <strong>valid binary array</strong> <code>original</code> that could have formed <code>derived</code>.</p>

<p>Return <em><strong>true</strong> if such an array exists or <strong>false</strong> otherwise.</em></p>

<ul>
	<li>A binary array is an array containing only <strong>0&#39;s</strong> and <strong>1&#39;s</strong></li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> derived = [1,1,0]
<strong>Output:</strong> true
<strong>Explanation:</strong> A valid original array that gives derived is [0,1,0].
derived[0] = original[0] &oplus; original[1] = 0 &oplus; 1 = 1 
derived[1] = original[1] &oplus; original[2] = 1 &oplus; 0 = 1
derived[2] = original[2] &oplus; original[0] = 0 &oplus; 0 = 0
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> derived = [1,1]
<strong>Output:</strong> true
<strong>Explanation:</strong> A valid original array that gives derived is [0,1].
derived[0] = original[0] &oplus; original[1] = 1
derived[1] = original[1] &oplus; original[0] = 1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> derived = [1,0]
<strong>Output:</strong> false
<strong>Explanation:</strong> There is no valid original array that gives derived.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == derived.length</code></li>
	<li><code>1 &lt;= n&nbsp;&lt;= 10<sup>5</sup></code></li>
	<li>The values in <code>derived</code>&nbsp;are either <strong>0&#39;s</strong> or <strong>1&#39;s</strong></li>
</ul>
Let's break down the approach **step by step** in **detail** with **examples** to understand how it works.

### Problem Recap:
We are given an array called `derived`, and we need to check if there exists a valid binary array `original` that can be derived using the given XOR rule.

The rule for constructing `derived` from `original` is:
- For each index `i` in the array, the `derived[i]` is computed as the XOR of `original[i]` and `original[i+1]`, where `original[n-1]` (last element) is XORed with `original[0]` (first element).

We need to determine if there exists a valid `original` array that could have resulted in the `derived` array.



### Step-by-Step Approach:

To solve this problem, the key observation is that when you XOR all elements of the `derived` array, if it results in `0`, there **must** exist a valid `original` array that satisfies the XOR relations. If the XOR result is not `0`, then it is **impossible** to form a valid `original` array.

#### Why XOR all elements in `derived`?
- If the XOR of all the elements of `derived` is `0`, then we can conclude that the original array could exist, because the cancellation mechanism of XOR works out correctly for all adjacent pairs. Conversely, if the XOR of all elements is non-zero, then no valid `original` array exists that can generate the given `derived` array.

#### Algorithm Steps:

1. **Initialize the result variable `res = 0`**:
   - This will store the cumulative XOR of all elements in the `derived` array.

2. **Iterate through the `derived` array**:
   - For each element `x` in `derived`, XOR it with the running result (`res`).

3. **Check if the final result `res == 0`**:
   - If the final XOR result is `0`, it means there **exists a valid `original` array**, so we return `true`.
   - If the final XOR result is not `0`, then no valid `original` array exists, and we return `false`.

---

### Example Walkthrough:

#### Example 1: `derived = [1, 1, 0]`

1. **Initialize `res = 0`**.

2. **Iterate through `derived`**:
   - `x = 1`: XOR with `res = 0 ^ 1 = 1`
   - `x = 1`: XOR with `res = 1 ^ 1 = 0`
   - `x = 0`: XOR with `res = 0 ^ 0 = 0`

3. **Final result**: `res = 0`.

4. **Conclusion**: Since `res == 0`, a valid `original` array exists. Return `true`.

- **Valid `original` array**: `[0, 1, 0]`
  - Derived from the XOR rule:
    - `derived[0] = original[0] ⊕ original[1] = 0 ⊕ 1 = 1`
    - `derived[1] = original[1] ⊕ original[2] = 1 ⊕ 0 = 1`
    - `derived[2] = original[2] ⊕ original[0] = 0 ⊕ 0 = 0`

---

#### Example 2: `derived = [1, 1]`

1. **Initialize `res = 0`**.

2. **Iterate through `derived`**:
   - `x = 1`: XOR with `res = 0 ^ 1 = 1`
   - `x = 1`: XOR with `res = 1 ^ 1 = 0`

3. **Final result**: `res = 0`.

4. **Conclusion**: Since `res == 0`, a valid `original` array exists. Return `true`.

- **Valid `original` array**: `[0, 1]`
  - Derived from the XOR rule:
    - `derived[0] = original[0] ⊕ original[1] = 0 ⊕ 1 = 1`
    - `derived[1] = original[1] ⊕ original[0] = 1 ⊕ 0 = 1`

---

#### Example 3: `derived = [1, 0]`

1. **Initialize `res = 0`**.

2. **Iterate through `derived`**:
   - `x = 1`: XOR with `res = 0 ^ 1 = 1`
   - `x = 0`: XOR with `res = 1 ^ 0 = 1`

3. **Final result**: `res = 1`.

4. **Conclusion**: Since `res != 0`, no valid `original` array exists. Return `false`.

---



- **Line 1-2**: We initialize a variable `res` to store the cumulative XOR of all elements in `derived`.
- **Line 4-6**: We iterate through each element of `derived` and perform XOR with `res`.
- **Line 8**: If `res == 0`, it means there exists a valid `original` array that can generate `derived`, so we return `true`.
- **Line 10**: If `res != 0`, we return `false`, indicating that no valid `original` array exists.

### Time Complexity:
- **O(n)**: We only iterate through the `derived` array once, where `n` is the length of the array.

### Space Complexity:
- **O(1)**: We use only a constant amount of space, aside from the input array.

---

### Conclusion:
The approach uses the XOR operation to check whether a valid binary array `original` can exist given the `derived` array. The key is understanding that XORing all elements of `derived` will help us determine if such an array exists, and the result of that XOR operation tells us if the cancellation property of XOR holds.

# JavaCode
```java []
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int res = 0;
        for (int x : derived) {
            res ^= x;
        }
        return res == 0;
    }
}
```
