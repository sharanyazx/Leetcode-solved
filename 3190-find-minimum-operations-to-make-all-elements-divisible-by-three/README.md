<h2><a href="https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three">3190. Find Minimum Operations to Make All Elements Divisible by Three</a></h2><h3>Easy</h3><hr><p>You are given an integer array <code>nums</code>. In one operation, you can add or subtract 1 from <strong>any</strong> element of <code>nums</code>.</p>

<p>Return the <strong>minimum</strong> number of operations to make all elements of <code>nums</code> divisible by 3.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>All array elements can be made divisible by 3 using 3 operations:</p>

<ul>
	<li>Subtract 1 from 1.</li>
	<li>Add 1 to 2.</li>
	<li>Subtract 1 from 4.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3,6,9]</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>
</div>



<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 50</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 50</code></li>
</ul>
### Problem Explanation

You are given an integer array `nums`. The task is to determine the **minimum number of operations** required to make **all elements in the array divisible by 3**. 

An operation is defined as either:
- Adding 1 to an element, or
- Subtracting 1 from an element.

### Approach

1. **Understanding Divisibility by 3**:
   - A number is divisible by 3 if the remainder when divided by 3 is 0 (i.e., `num % 3 == 0`).
   - Possible remainders when dividing any integer by 3 are:
     - Remainder 0 (already divisible by 3, no operations needed).
     - Remainder 1 (1 operation: subtract 1).
     - Remainder 2 (1 operation: add 1).

2. **Goal**:
   - For each number in the array, make it divisible by 3 with the minimum operations.
   - Count the total number of operations required.

3. **Steps to Solve**:
   - Iterate through each number in the array.
   - Check its remainder when divided by 3.
   - Based on the remainder, calculate the minimum operations to make it divisible by 3:
     - Remainder 0: No operations needed.
     - Remainder 1: Subtract 1.
     - Remainder 2: Add 1.
   - Sum up the operations for all elements in the array.

---

### Example Walkthrough

#### Example 1: Input `nums = [1, 2, 3, 4]`

1. **Remainders of the Elements**:
   - `1 % 3 = 1`: Remainder 1 (1 operation: subtract 1 to make it 0).
   - `2 % 3 = 2`: Remainder 2 (1 operation: add 1 to make it 3).
   - `3 % 3 = 0`: Remainder 0 (no operations needed).
   - `4 % 3 = 1`: Remainder 1 (1 operation: subtract 1 to make it 3).

2. **Operations Required**:
   - For `1`: Subtract 1 → 1 operation.
   - For `2`: Add 1 → 1 operation.
   - For `4`: Subtract 1 → 1 operation.

3. **Total Operations**:
   \[
   \text{Total} = 1 + 1 + 0 + 1 = 3
   \]

4. **Output**: `3`.

---

#### Example 2: Input `nums = [3, 6, 9]`

1. **Remainders of the Elements**:
   - `3 % 3 = 0`: Remainder 0 (no operations needed).
   - `6 % 3 = 0`: Remainder 0 (no operations needed).
   - `9 % 3 = 0`: Remainder 0 (no operations needed).

2. **Operations Required**:
   - All numbers are already divisible by 3 → No operations.

3. **Total Operations**:
   \[
   \text{Total} = 0 + 0 + 0 = 0
   \]

4. **Output**: `0`.

---

### Algorithm (Step-by-Step)

1. Initialize `operations = 0` to track the total number of operations.
2. Loop through each number in `nums`:
   - Calculate `remainder = num % 3`.
   - If `remainder == 1`, add 1 to `operations` (subtract 1 from the number).
   - If `remainder == 2`, add 1 to `operations` (add 1 to the number).
3. Return `operations`.

---

### Python Code Implementation

```python
def min_operations(nums):
    operations = 0
    for num in nums:
        remainder = num % 3
        if remainder == 1:
            operations += 1  # Subtract 1
        elif remainder == 2:
            operations += 1  # Add 1
    return operations

# Examples
print(min_operations([1, 2, 3, 4]))  # Output: 3
print(min_operations([3, 6, 9]))     # Output: 0
```

---

### Complexity Analysis

1. **Time Complexity**:
   - \( O(n) \), where \( n \) is the length of the array. We iterate through the array once.

2. **Space Complexity**:
   - \( O(1) \), as no extra space is used beyond a few variables.

---

### Edge Cases

1. **All Numbers Already Divisible by 3**:
   - Example: `nums = [3, 6, 9]`.
   - Output: `0`.

2. **All Numbers Need Adjustments**:
   - Example: `nums = [1, 2, 4, 5]`.
   - Each number requires 1 operation. Sum of operations will equal the length of the array.

3. **Single Element Array**:
   - Example: `nums = [7]`.
   - Calculate the adjustment for the single number.


### Python Code Implementation

```python
def min_operations(nums):
    operations = 0
    for num in nums:
        remainder = num % 3
        if remainder == 1:
            operations += 1  # Subtract 1
        elif remainder == 2:
            operations += 1  # Add 1
    return operations

# Examples
print(min_operations([1, 2, 3, 4]))  # Output: 3
print(min_operations([3, 6, 9]))     # Output: 0
```
### Java
```java
class Solution {
    public int minimumOperations(int[] nums) {
       int oper=0;
        for(int num:nums){
            int rem=num%3;
            if(rem==1){
                oper+=1;
            }
            else if(rem==2){
                oper+=1;
            }
        }
     
        return oper;
    }
}
```
