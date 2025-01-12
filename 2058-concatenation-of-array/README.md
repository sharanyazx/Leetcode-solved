<h2><a href="https://leetcode.com/problems/concatenation-of-array">Concatenation of Array</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given an integer array <code>nums</code> of length <code>n</code>, you want to create an array <code>ans</code> of length <code>2n</code> where <code>ans[i] == nums[i]</code> and <code>ans[i + n] == nums[i]</code> for <code>0 &lt;= i &lt; n</code> (<strong>0-indexed</strong>).</p>

<p>Specifically, <code>ans</code> is the <strong>concatenation</strong> of two <code>nums</code> arrays.</p>

<p>Return <em>the array </em><code>ans</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,1]
<strong>Output:</strong> [1,2,1,1,2,1]
<strong>Explanation:</strong> The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
- ans = [1,2,1,1,2,1]</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3,2,1]
<strong>Output:</strong> [1,3,2,1,1,3,2,1]
<strong>Explanation:</strong> The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
- ans = [1,3,2,1,1,3,2,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
</ul>

### Problem Understanding

You're given an integer array `nums` of length `n`, and the task is to create a new array `ans` of length `2n`, which consists of two copies of the `nums` array concatenated together.

Specifically:
- For each index `i` from `0` to `n-1`, `ans[i]` should be equal to `nums[i]`.
- For each index `i` from `0` to `n-1`, `ans[i + n]` should be equal to `nums[i]`.

In other words, the array `ans` should contain the original array `nums` twice in sequence.

### Solution Explanation

1. **Input**: You are given an integer array `nums`.
2. **Output**: You need to create a new array `ans` where:
   - The first half of `ans` is exactly the same as `nums`.
   - The second half of `ans` is also exactly the same as `nums`.
3. **How to Achieve This**: We can simply concatenate the `nums` array with itself.

### Steps:
1. **Input**: Start with an integer array `nums` of length `n`.
2. **Create the Output**: To create the result array `ans`, simply concatenate `nums` with itself.
   - You can do this by using Python's list concatenation: `ans = nums + nums`.
3. **Return the Output**: The array `ans` will have a length of `2n`, and it will be the concatenation of `nums` and `nums`.

### Example Walkthrough

#### Example 1:

- **Input**: `nums = [1, 2, 1]`
- **Process**: 
  - The length of `nums` is `n = 3`.
  - We concatenate `nums` with itself:
    - `nums + nums = [1, 2, 1] + [1, 2, 1]`
    - This gives the array `[1, 2, 1, 1, 2, 1]`.
- **Output**: `ans = [1, 2, 1, 1, 2, 1]`

#### Example 2:

- **Input**: `nums = [1, 3, 2, 1]`
- **Process**:
  - The length of `nums` is `n = 4`.
  - We concatenate `nums` with itself:
    - `nums + nums = [1, 3, 2, 1] + [1, 3, 2, 1]`
    - This gives the array `[1, 3, 2, 1, 1, 3, 2, 1]`.
- **Output**: `ans = [1, 3, 2, 1, 1, 3, 2, 1]`


### Explanation of the Code:
1. **Function**: The function `getConcatenation` accepts the array `nums` as input.
2. **Concatenation**: The expression `nums + nums` creates a new array that contains two copies of the original `nums` array.
3. **Return**: The resulting array `ans` is returned as the output.

### Time Complexity:
- **Time Complexity**: The time complexity of this solution is **O(n)**, where `n` is the length of the input array `nums`. This is because concatenating two arrays takes linear time relative to the total number of elements, which is `2n`.
  
### Space Complexity:
- **Space Complexity**: The space complexity is also **O(n)**, because we are creating a new array `ans` of length `2n`.

### Edge Cases:
1. **Smallest case**: If `nums = [1]`, then `ans = [1, 1]`.
2. **All identical elements**: If `nums = [5, 5, 5]`, then `ans = [5, 5, 5, 5, 5, 5]`.
3. **Maximal case**: If `nums` has the maximum length (1000), then `ans` will have a length of 2000.

### Constraints:
- The input `nums` will always satisfy `1 <= nums.length <= 1000`, ensuring the problem is solvable within reasonable time and space limits.

---


# Code
```java []
class Solution {
    public int[] getConcatenation(int[] nums) {
        int len =nums.length;
        int []result=new int[len*2];
        for(int i=0;i<len;i++){
            result[i]=nums[i];
        }
        for(int i=0;i<len;i++){
            result[i + len]=nums[i];
        }
        return result;
        
    }
}
```

```python3 []
class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        return nums+nums
       

```





### Step-by-Step Breakdown:

1. **Get the Length of the Array**:
   ```java
   int len = nums.length;
   ```
   - The variable `len` stores the length of the input array `nums`.
   - For example, if `nums = [1, 2, 3]`, then `len = 3`.

2. **Create the Result Array**:
   ```java
   int[] result = new int[len * 2];
   ```
   - The `result` array is created with a length of `2 * len`, meaning it will have twice the number of elements as the original `nums` array.
   - For example, if `len = 3`, the `result` array will have a size of `6`.

3. **Copy the Elements of `nums` to the First Half of `result`**:
   ```java
   for (int i = 0; i < len; i++) {
       result[i] = nums[i];
   }
   ```
   - This loop copies each element from `nums` into the first half of the `result` array.
   - For example, if `nums = [1, 2, 3]`, after this loop, `result = [1, 2, 3, 0, 0, 0]`.

4. **Copy the Elements of `nums` to the Second Half of `result`**:
   ```java
   for (int i = 0; i < len; i++) {
       result[i + len] = nums[i];
   }
   ```
   - This loop copies each element from `nums` into the second half of the `result` array, starting at index `len` (i.e., from the middle of the array).
   - After this loop, for `nums = [1, 2, 3]`, `result = [1, 2, 3, 1, 2, 3]`.

5. **Return the Result**:
   ```java
   return result;
   ```
   - Finally, the method returns the concatenated `result` array, which is now the same as `nums` repeated twice.
   - For example, `result = [1, 2, 3, 1, 2, 3]`.

### Example Walkthrough:

#### Example 1:

**Input**: `nums = [1, 2, 1]`

- `len = 3`
- Step 1: `result = [0, 0, 0, 0, 0, 0]`
- Step 2 (First loop):
  - After this loop, `result = [1, 2, 1, 0, 0, 0]`
- Step 3 (Second loop):
  - After this loop, `result = [1, 2, 1, 1, 2, 1]`
- **Output**: `[1, 2, 1, 1, 2, 1]`

#### Example 2:

**Input**: `nums = [1, 3, 2, 1]`

- `len = 4`
- Step 1: `result = [0, 0, 0, 0, 0, 0, 0, 0]`
- Step 2 (First loop):
  - After this loop, `result = [1, 3, 2, 1, 0, 0, 0, 0]`
- Step 3 (Second loop):
  - After this loop, `result = [1, 3, 2, 1, 1, 3, 2, 1]`
- **Output**: `[1, 3, 2, 1, 1, 3, 2, 1]`


