<h2><a href="https://leetcode.com/problems/build-array-from-permutation">Build Array from Permutation</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given a <strong>zero-based permutation</strong> <code>nums</code> (<strong>0-indexed</strong>), build an array <code>ans</code> of the <strong>same length</strong> where <code>ans[i] = nums[nums[i]]</code> for each <code>0 &lt;= i &lt; nums.length</code> and return it.</p>

<p>A <strong>zero-based permutation</strong> <code>nums</code> is an array of <strong>distinct</strong> integers from <code>0</code> to <code>nums.length - 1</code> (<strong>inclusive</strong>).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,2,1,5,3,4]
<strong>Output:</strong> [0,1,2,4,5,3]<strong>
Explanation:</strong> The array ans is built as follows: 
ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
    = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
    = [0,1,2,4,5,3]</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [5,0,1,2,3,4]
<strong>Output:</strong> [4,5,0,1,2,3]
<strong>Explanation:</strong> The array ans is built as follows:
ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
    = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
    = [4,5,0,1,2,3]</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>0 &lt;= nums[i] &lt; nums.length</code></li>
	<li>The elements in <code>nums</code> are <strong>distinct</strong>.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow-up:</strong> Can you solve it without using an extra space (i.e., <code>O(1)</code> memory)?</p>

### **Problem Explanation**:

Given an array `nums` of distinct integers from 0 to `nums.length - 1`, we need to construct a new array `ans` such that each element at index `i` in the array `ans` is equal to `nums[nums[i]]`.

### **Breakdown**:
- We are given a **zero-based permutation**: This means that the elements in the array `nums` are distinct integers in the range `[0, nums.length - 1]`. The index of each element is also a valid value that appears somewhere in the array.
  
### **Task**:
- We need to build an array `ans` where for each index `i` in the array `nums`:
  \[
  ans[i] = nums[nums[i]]
  \]
  This means that for each index `i`, we take the value at `nums[i]` and use that value as an index to find the value from `nums` again.

### **Example 1**:
- **Input**: `nums = [0, 2, 1, 5, 3, 4]`
- **Output**: `ans = [0, 1, 2, 4, 5, 3]`
  
**Explanation**:
- `ans[0] = nums[nums[0]] = nums[0] = 0`
- `ans[1] = nums[nums[1]] = nums[2] = 1`
- `ans[2] = nums[nums[2]] = nums[1] = 2`
- `ans[3] = nums[nums[3]] = nums[5] = 4`
- `ans[4] = nums[nums[4]] = nums[3] = 5`
- `ans[5] = nums[nums[5]] = nums[4] = 3`

Thus, the array `ans` is `[0, 1, 2, 4, 5, 3]`.

---

### **Example 2**:
- **Input**: `nums = [5, 0, 1, 2, 3, 4]`
- **Output**: `ans = [4, 5, 0, 1, 2, 3]`

**Explanation**:
- `ans[0] = nums[nums[0]] = nums[5] = 4`
- `ans[1] = nums[nums[1]] = nums[0] = 5`
- `ans[2] = nums[nums[2]] = nums[1] = 0`
- `ans[3] = nums[nums[3]] = nums[2] = 1`
- `ans[4] = nums[nums[4]] = nums[3] = 2`
- `ans[5] = nums[nums[5]] = nums[4] = 3`

Thus, the array `ans` is `[4, 5, 0, 1, 2, 3]`.

---

### **Constraints**:
- The length of the input array `nums` is between 1 and 1000 (inclusive). This means that the input array is relatively small, and a simple approach to solve this problem will work efficiently.

---

### **Plan**:
1. Create an empty array `ans` of the same length as `nums`.
2. For each index `i` in `nums`, compute `ans[i] = nums[nums[i]]`.
3. Return the array `ans` after it's fully constructed.

---

### **Time Complexity**:
- Since we iterate through the array `nums` once, the time complexity of this solution is \(O(n)\), where \(n\) is the length of `nums`.

---


# Code
```java []
class Solution {
    public int[] buildArray(int[] nums) {
        int n=nums.length;
        int [] result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=nums[nums[i]];
        }
        return result;
    }
}
```

```python3 []
class Solution:
    def buildArray(self, nums: list[int]) -> list[int]:
        ans = [0] * len(nums)
        for i in range(len(nums)):
            ans[i] = nums[nums[i]]
        return ans

```
### **Java Approach**:

```java
class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        // Build the ans array where ans[i] = nums[nums[i]]
        for (int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];
        }
        
        return ans;
    }
}
```

### **Explanation**:
1. First, we initialize an array `ans` of the same length as `nums`.
2. We iterate over all indices of `nums` using a for loop.
3. For each index `i`, we set `ans[i]` to be equal to `nums[nums[i]]`.
4. Finally, we return the `ans` array.

### **Time Complexity**:
- **O(n)**: We are iterating over the array `nums` once.

---

### **Python Approach**:

```python
class Solution:
    def buildArray(self, nums: list[int]) -> list[int]:
        # Initialize the ans array
        ans = [0] * len(nums)
        
        # Build the ans array where ans[i] = nums[nums[i]]
        for i in range(len(nums)):
            ans[i] = nums[nums[i]]
        
        return ans
```

### **Explanation**:
1. We create an empty list `ans` with the same length as `nums` and initialize it with zeros.
2. We loop through each index of `nums`, and for each index `i`, we set `ans[i]` to be equal to `nums[nums[i]]`.
3. After the loop finishes, we return the `ans` list.

### **Time Complexity**:
- **O(n)**: Like the Java solution, we are iterating through the array `nums` once.

