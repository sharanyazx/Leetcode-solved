<h2><a href="https://leetcode.com/problems/single-number">136. Single Number</a></h2><h3>Easy</h3><hr><p>Given a <strong>non-empty</strong>&nbsp;array of integers <code>nums</code>, every element appears <em>twice</em> except for one. Find that single one.</p>

<p>You must&nbsp;implement a solution with a linear runtime complexity and use&nbsp;only constant&nbsp;extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,2,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [4,1,2,1,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>-3 * 10<sup>4</sup> &lt;= nums[i] &lt;= 3 * 10<sup>4</sup></code></li>
	<li>Each element in the array appears twice except for one element which appears only once.</li>
</ul>
### Problem Statement:

Given an integer array `nums` where every element appears twice except for one element, find that single element which appears only once.

### Approach:

The problem can be efficiently solved using the **XOR** operation, utilizing its properties to cancel out the numbers that appear twice and isolate the number that appears only once.



#### Detailed Explanation:

We initialize a variable `count` to 0. As we iterate over the array, we perform XOR between `count` and each element. If an element appears twice, it will cancel itself out due to the property **`A^A=0`**. After processing all elements, the value of `count` will be the element that appears only once.



#### Step-by-step Breakdown of the Code:

1. **Initialization**:
   - `count` is initialized to 0. This is because XOR-ing any number with 0 results in the number itself, and we start with a neutral value for XOR operations.

2. **Iterating Through the Array**:
   - We iterate over each element in the array using a for loop.
   - During each iteration, `count ^= nums[i]` performs XOR between `count` and the current array element `nums[i]`.
     - If an element appears twice, XOR-ing it twice will cancel out the effect, leaving `count` unchanged for those elements.
     - The only element that does not cancel out will remain in `count`.

3. **Result**:
   - After iterating over the array, `count` will store the element that appears only once. This is because all other elements, appearing twice, would have canceled each other out.

#### Time and Space Complexity:

- **Time Complexity**: \( O(n) \), where \( n \) is the number of elements in the array. We iterate through the array once.
- **Space Complexity**: \( O(1) \), since we only use a single integer variable to store the result.

### Example Walkthrough:

#### Example 1:

- Input: `nums = [2, 2, 1]`
  
  **Step-by-step Execution**:
  - Initialize `count = 0`.
  - Iterate over the array:
    - `count ^= 2` → `count = 2` (initial XOR with 2)
    - `count ^= 2` → `count = 0` (cancel out the two 2's, XOR of two identical numbers results in 0)
    - `count ^= 1` → `count = 1` (final XOR, leaving the number that appears once)
  - **Output**: `1`

#### Example 2:

- Input: `nums = [4, 1, 2, 1, 2]`
  
  **Step-by-step Execution**:
  - Initialize `count = 0`.
  - Iterate over the array:
    - `count ^= 4` → `count = 4`
    - `count ^= 1` → `count = 5`
    - `count ^= 2` → `count = 7`
    - `count ^= 1` → `count = 6`
    - `count ^= 2` → `count = 4`
  - **Output**: `4`

### Conclusion:

- The XOR operation allows us to efficiently find the number that appears only once in an array where all other numbers appear twice.
- The algorithm runs in linear time \( O(n) \) and uses constant space \( O(1) \), making it both time and space efficient.
# Code
```java []

class Solution {
    public int singleNumber(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count ^= nums[i];
        }
        return count;
    }
}
```
```python3 []
  class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        count=0
        for i in nums:
            count^=i
        return count

```
