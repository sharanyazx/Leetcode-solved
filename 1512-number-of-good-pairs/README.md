<h2><a href="https://leetcode.com/problems/number-of-good-pairs/">1512. Number of Good Pairs</a></h2><h3>Easy</h3><hr><p>Given an array of integers <code>nums</code>, return <em>the number of <strong>good pairs</strong></em>.</p>

<p>A pair <code>(i, j)</code> is called <em>good</em> if <code>nums[i] == nums[j]</code> and <code>i</code> &lt; <code>j</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,1,1,3]
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,1,1]
<strong>Output:</strong> 6
<strong>Explanation:</strong> Each pair in the array are <em>good</em>.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
</ul>
### Problem Explanation:

The problem is asking to find **"good pairs"** in an array of integers. A **good pair** is defined as a pair of indices `(i, j)` where:
1. `i < j` (i.e., the index `i` is before index `j`).
2. `nums[i] == nums[j]` (i.e., the values at those indices are equal).

Given an array `nums` of length `n`, your task is to count how many such good pairs exist in the array.

### Example 1:

Input: `nums = [1, 2, 3, 1, 1, 3]`

**Explanation:**
- For the first pair `(i=0, j=3)`, `nums[0] == nums[3]`, so it’s a good pair.
- For the second pair `(i=0, j=4)`, `nums[0] == nums[4]`, so it’s a good pair.
- For the third pair `(i=3, j=4)`, `nums[3] == nums[4]`, so it’s a good pair.
- For the fourth pair `(i=2, j=5)`, `nums[2] == nums[5]`, so it’s a good pair.

So, there are **4 good pairs**: `(0, 3)`, `(0, 4)`, `(3, 4)`, and `(2, 5)`.

Output: `4`

### Example 2:

Input: `nums = [1, 1, 1, 1]`

**Explanation:**
- Every pair `(i, j)` where `i < j` will be a good pair because all the elements are `1`.

So, the total number of good pairs in this case is `6` (i.e., `(0, 1)`, `(0, 2)`, `(0, 3)`, `(1, 2)`, `(1, 3)`, and `(2, 3)`).

Output: `6`

### Example 3:

Input: `nums = [1, 2, 3]`

**Explanation:**
- Since all the elements are different, there are no good pairs.

Output: `0`

### Solution Approach:

1. **Brute Force Method**:
   - Iterate through each element of the array using two nested loops.
   - The outer loop iterates from `0` to `nums.length-1`, and the inner loop iterates from `i+1` to `nums.length`.
   - If `nums[i] == nums[j]`, increment the count of good pairs.

   This method checks every possible pair of indices `(i, j)` and counts how many of them are good pairs.




### Explanation of Code:

1. **Outer Loop**:
   - `for (int i = 0; i < nums.length - 1; i++)` — this loop iterates through each element in the array, except the last one (because the inner loop will handle pairs).
   
2. **Inner Loop**:
   - `for (int j = i + 1; j < nums.length; j++)` — this loop checks all elements after the current element `i`. It ensures that only pairs where `i < j` are considered.
   
3. **Condition**:
   - `if (nums[i] == nums[j])` — checks if the two elements at indices `i` and `j` are equal. If they are, it means we have found a good pair, so we increment the `good` counter.

4. **Return**:
   - After both loops finish iterating through all the pairs, the method returns the final count of good pairs.




# Code
### Python
```python3 []
class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        good=0
        for i in range (0,len(nums)):
            for j in range (i+1,len(nums)):
                if nums[i]==nums[j]:
                    good+=1
        return good
        
```
### Java
```java []
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int good=0;
        for(int i =0;i<nums.length-1;i++){
            for(int j =i+1;j<nums.length;j++){
                if(nums[i]==nums[j]) good++;
            }
        }
        return good;
    }
}
```
