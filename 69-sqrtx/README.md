<h2><a href="https://leetcode.com/problems/sqrtx">Sqrt(x)</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given a non-negative integer <code>x</code>, return <em>the square root of </em><code>x</code><em> rounded down to the nearest integer</em>. The returned integer should be <strong>non-negative</strong> as well.</p>

<p>You <strong>must not use</strong> any built-in exponent function or operator.</p>

<ul>
	<li>For example, do not use <code>pow(x, 0.5)</code> in c++ or <code>x ** 0.5</code> in python.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> x = 4
<strong>Output:</strong> 2
<strong>Explanation:</strong> The square root of 4 is 2, so we return 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> x = 8
<strong>Output:</strong> 2
<strong>Explanation:</strong> The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= x &lt;= 2<sup>31</sup> - 1</code></li>
</ul>




### Problem Explanation:

Given a non-negative integer `x`, the task is to find the square root of `x` and return it rounded down to the nearest integer. This means that we need to compute the largest integer `y` such that `y^2 ≤ x`. 

**Important Notes:**
- We **cannot** use built-in functions or operators that directly calculate the square root. For instance, in Python, we can't use `x ** 0.5` or `math.sqrt(x)`.
- The result should be rounded **down** to the nearest integer (i.e., floor the square root).

### Examples:

1. **Example 1:**

   **Input:** `x = 4`

   **Output:** `2`

   **Explanation:** The square root of 4 is 2, and we return `2`.

2. **Example 2:**

   **Input:** `x = 8`

   **Output:** `2`

   **Explanation:** The square root of 8 is approximately `2.82842...`. When rounded down to the nearest integer, the result is `2`.

### Approach:

The approach to solve this problem is to find an efficient way to compute the integer square root of `x` without using built-in exponent functions. We can apply **binary search** to do this efficiently.

### Algorithm (Binary Search Approach):

1. If `x == 0` or `x == 1`, return `x` because the square root of 0 is 0 and the square root of 1 is 1.
2. Use binary search to find the integer square root of `x`:
   - Set the range of the search to `low = 0` and `high = x`.
   - Compute the mid-point `mid = (low + high) // 2`.
   - Check if `mid * mid == x`, in which case `mid` is the square root.
   - If `mid * mid > x`, update the `high` pointer to `mid - 1` to search for smaller values.
   - If `mid * mid < x`, update the `low` pointer to `mid + 1` to search for larger values.
3. The result will be the highest `mid` value where `mid * mid <= x`.

### Python Solution:

```python
class Solution:
    def mySqrt(self, x: int) -> int:
        # Edge case for 0 and 1
        if x == 0 or x == 1:
            return x
        
        low, high = 0, x
        while low <= high:
            mid = (low + high) // 2
            if mid * mid == x:
                return mid
            elif mid * mid < x:
                low = mid + 1
            else:
                high = mid - 1
        
        return high  # `high` will be the largest integer such that high * high <= x
```

### Explanation of Code:

1. **Edge Case Handling**: If `x` is 0 or 1, we return `x` immediately since their square roots are themselves.
2. **Binary Search**:
   - We initialize `low` as 0 and `high` as `x`.
   - In each iteration, we calculate the middle value `mid`.
   - If `mid * mid == x`, we return `mid` because we found the exact square root.
   - If `mid * mid < x`, we move our search range to the right (`low = mid + 1`).
   - If `mid * mid > x`, we move our search range to the left (`high = mid - 1`).
3. **Returning the Result**: If we exit the loop, `high` will be the greatest integer where `high * high <= x`, so we return `high`.


    

### Explanation:

- **Edge Case**: If `x` is 0 or 1, we directly return `x` as its square root.
- **Binary Search**:
   - We initialize `low` as 0 and `high` as `x`.
   - Each iteration calculates the middle value `mid`.
   - We adjust the `low` and `high` values based on the comparison between `mid * mid` and `x`.
- **Returning the Result**: The final result is the `high` pointer, which will be the integer square root of `x`.

### Example Walkthrough:

#### Example 1:
**Input**: `x = 4`

- Initial values: `low = 0`, `high = 4`
- **Iteration 1**:
  - `mid = (0 + 4) // 2 = 2`
  - `2 * 2 == 4`, so we return `2`.

**Output**: `2`

#### Example 2:
**Input**: `x = 8`

- Initial values: `low = 0`, `high = 8`
- **Iteration 1**:
  - `mid = (0 + 8) // 2 = 4`
  - `4 * 4 = 16`, which is greater than 8, so `high = mid - 1 = 3`.
- **Iteration 2**:
  - `mid = (0 + 3) // 2 = 1`
  - `1 * 1 = 1`, which is less than 8, so `low = mid + 1 = 2`.
- **Iteration 3**:
  - `mid = (2 + 3) // 2 = 2`
  - `2 * 2 = 4`, which is less than 8, so `low = mid + 1 = 3`.
- **Iteration 4**:
  - `mid = (3 + 3) // 2 = 3`
  - `3 * 3 = 9`, which is greater than 8, so `high = mid - 1 = 2`.
- Final result: `high = 2`, so the integer square root of 8 is `2`.

**Output**: `2`

### Time Complexity:
- **O(log(x))**: The binary search reduces the problem size by half in each iteration.

### Space Complexity:
- **O(1)**: We use a constant amount of extra space.

### Conclusion:
This problem is efficiently solved using binary search, ensuring that we meet the constraints and provide an optimal solution.

# Code
```java []
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
```

```java []

 
class Solution {
    public int mySqrt(int x) {
        double res=Math.pow(x,0.5);
        return (int) res;
    }
}
```

``` python3 []
class Solution:
    def mySqrt(self, x: int) -> int:
        if x==0:
            return 0
        left,right=1,x
        while left<=right:
            mid=(left+right)//2
            if mid*mid==x:
                return mid
            elif mid*mid<x:
                 left=mid+1
            else :
                right=mid-1
        return right
```


---

### Problem Explanation:
You are asked to find the **integer square root** of a given non-negative integer `x`. The integer square root of `x` is the largest integer `y` such that:
`y^2 <= x`
If `x` is a perfect square, the result will be the exact square root. If not, the result will be rounded down to the nearest integer.

---

### Constraints:
1. `0 <= x <= 2^31 - 1`
2. **No built-in square root functions** like `Math.sqrt()` are allowed.

---

### Approach: Binary Search

#### Steps:

1. **Handle the special case**:  
   - If `x = 0`, return `0` immediately.

2. **Set search boundaries**:  
   - Start with `left = 1` and `right = x`.

3. **Binary Search Logic**:
   - Calculate the midpoint:
     `mid = left + (right - left) / 2`
   - Check:
     - If `mid * mid == x`, return `mid` (exact square root found).  
     - If `mid * mid < x`, move the left boundary:  
       `left = mid + 1`
     - If `mid * mid > x`, move the right boundary:  
       `right = mid - 1`

4. **Stop when `left > right`**:  
   - The loop ends when no further narrowing is possible.  
   - Return `right`, which holds the largest integer `y` such that `y^2 <= x`.

---

### Example Walkthrough

#### Example 1: `x = 8`

1. **Initialize**:  
   - `left = 1`, `right = 8`

2. **Binary Search Iterations**:
   - **First Iteration**:
     - `mid = (1 + 8) / 2 = 4`
     - `4^2 = 16 > 8`, so move `right` to `3`.

   - **Second Iteration**:
     - `mid = (1 + 3) / 2 = 2`
     - `2^2 = 4 < 8`, so move `left` to `3`.

   - **Third Iteration**:
     - `mid = (3 + 3) / 2 = 3`
     - `3^2 = 9 > 8`, so move `right` to `2`.

3. **End**:  
   - `left = 3`, `right = 2` (`left > right`).  
   - Return `right = 2`.

**Output**: `2`

---

### Key Insight:
Binary search efficiently reduces the range of possible values, ensuring an **(O(log x))** time complexity.

