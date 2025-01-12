<h2><a href="https://leetcode.com/problems/divisible-and-non-divisible-sums-difference">Divisible and Non-divisible Sums Difference</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>You are given positive integers <code>n</code> and <code>m</code>.</p>

<p>Define two integers as follows:</p>

<ul>
	<li><code>num1</code>: The sum of all integers in the range <code>[1, n]</code> (both <strong>inclusive</strong>) that are <strong>not divisible</strong> by <code>m</code>.</li>
	<li><code>num2</code>: The sum of all integers in the range <code>[1, n]</code> (both <strong>inclusive</strong>) that are <strong>divisible</strong> by <code>m</code>.</li>
</ul>

<p>Return <em>the integer</em> <code>num1 - num2</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 10, m = 3
<strong>Output:</strong> 19
<strong>Explanation:</strong> In the given example:
- Integers in the range [1, 10] that are not divisible by 3 are [1,2,4,5,7,8,10], num1 is the sum of those integers = 37.
- Integers in the range [1, 10] that are divisible by 3 are [3,6,9], num2 is the sum of those integers = 18.
We return 37 - 18 = 19 as the answer.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 5, m = 6
<strong>Output:</strong> 15
<strong>Explanation:</strong> In the given example:
- Integers in the range [1, 5] that are not divisible by 6 are [1,2,3,4,5], num1 is the sum of those integers = 15.
- Integers in the range [1, 5] that are divisible by 6 are [], num2 is the sum of those integers = 0.
We return 15 - 0 = 15 as the answer.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 5, m = 1
<strong>Output:</strong> -15
<strong>Explanation:</strong> In the given example:
- Integers in the range [1, 5] that are not divisible by 1 are [], num1 is the sum of those integers = 0.
- Integers in the range [1, 5] that are divisible by 1 are [1,2,3,4,5], num2 is the sum of those integers = 15.
We return 0 - 15 = -15 as the answer.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n, m &lt;= 1000</code></li>
</ul>
### Problem Explanation

You are given two integers, \( n \) and \( m \). The task is to compute the difference between two sums:

1. **num1**: The sum of all integers in the range \([1, n]\) that are **not divisible by \( m \)**.
2. **num2**: The sum of all integers in the range \([1, n]\) that are **divisible by \( m \)**.

Finally, return the result of :  **num1-num2**
**---**

### Steps to Solve the Problem

1. **Identify the Range**: The range of numbers is \([1, n]\). For example, if \( n = 10 \), the numbers are \([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]\).

2. **Divide Numbers into Two Groups**:
   - Numbers **not divisible by \( m \)** (add them to **num1**).
   - Numbers **divisible by \( m \)** (add them to **num2**).

3. **Calculate the Sums**:
   - Add up all numbers in each group to compute **num1** and **num2**.

4. **Find the Result**:
   - Compute the result as:
   
      **result = {num1} - {num2}**
    

---

### Example Walkthrough

#### Example 1: Input \( n = 10, m = 3 \)

1. **Numbers in Range**: \([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]\).

2. **Group the Numbers**:
   - **Not divisible by 3**: \([1, 2, 4, 5, 7, 8, 10]\).
   - **Divisible by 3**: \([3, 6, 9]\).

3. **Calculate Sums**:
   - **num1** = \( 1 + 2 + 4 + 5 + 7 + 8 + 10 = 37 \).
   - **num2** = \( 3 + 6 + 9 = 18 \).

4. **Result**:
  
      **result = {num1} - {num2}** = 37 - 18 = 19
   

---

#### Example 2: Input \( n = 5, m = 6 \)

1. **Numbers in Range**: \([1, 2, 3, 4, 5]\).

2. **Group the Numbers**:
   - **Not divisible by 6**: \([1, 2, 3, 4, 5]\).
   - **Divisible by 6**: \([]\) (none are divisible by 6).

3. **Calculate Sums**:
   - **num1** = \( 1 + 2 + 3 + 4 + 5 = 15 \).
   - **num2** = \( 0 \) (no numbers in this group).

4. **Result**:
    **result = {num1} - {num2}** = 15 - 0 = 15


---

#### Example 3: Input \( n = 5, m = 1 \)

1. **Numbers in Range**: \([1, 2, 3, 4, 5]\).

2. **Group the Numbers**:
   - **Not divisible by 1**: \([]\) (all numbers are divisible by 1).
   - **Divisible by 1**: \([1, 2, 3, 4, 5]\).

3. **Calculate Sums**:
   - **num1** = \( 0 \) (no numbers in this group).
   - **num2** = \( 1 + 2 + 3 + 4 + 5 = 15 \).

4. **Result**:
   **result = {num1} - {num2}** = 0 - 15 = -15


---

### General Approach (Algorithm)

1. Initialize num1 = 0  and num2=0.
2. Iterate through all numbers from \( 1 \) to \( n \):
   - If the number is divisible by \( m \), add it to num2.
   - Otherwise, add it to num1
3. Compute the result as:
        **result = {num1} - {num2}**
4. Return the result.

---



---

### Complexity Analysis

1. **Time Complexity**:
   - \( O(n) \): We iterate through all numbers from \( 1 \) to \( n \).

2. **Space Complexity**:
   - \( O(1) \): Only a few variables are used.

Let me know if you need further clarification! 😊
# Code
```java []
class Solution {
    public int differenceOfSums(int n, int m) {
        int a=0;
        int b=0;
        for(int i=0;i<=n;i++){
            if(i%m==0){
                a=a+i;
            }
            else{
                b=b+i;
            }
              
        }
      
          return b-a;
    }
}
```

```python3 []
class Solution:
    def differenceOfSums(self, n: int, m: int) -> int:
        a=0
        b=0
        for i in range(1,n+1):
            if(i%m!=0):
                b=b+i
            else:
                a+=i
        return b-a    

        
```
