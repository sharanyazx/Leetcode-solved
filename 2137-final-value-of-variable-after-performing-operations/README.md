<h2><a href="https://leetcode.com/problems/final-value-of-variable-after-performing-operations">Final Value of Variable After Performing Operations</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>There is a programming language with only <strong>four</strong> operations and <strong>one</strong> variable <code>X</code>:</p>

<ul>
	<li><code>++X</code> and <code>X++</code> <strong>increments</strong> the value of the variable <code>X</code> by <code>1</code>.</li>
	<li><code>--X</code> and <code>X--</code> <strong>decrements</strong> the value of the variable <code>X</code> by <code>1</code>.</li>
</ul>

<p>Initially, the value of <code>X</code> is <code>0</code>.</p>

<p>Given an array of strings <code>operations</code> containing a list of operations, return <em>the <strong>final </strong>value of </em><code>X</code> <em>after performing all the operations</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> operations = [&quot;--X&quot;,&quot;X++&quot;,&quot;X++&quot;]
<strong>Output:</strong> 1
<strong>Explanation:</strong>&nbsp;The operations are performed as follows:
Initially, X = 0.
--X: X is decremented by 1, X =  0 - 1 = -1.
X++: X is incremented by 1, X = -1 + 1 =  0.
X++: X is incremented by 1, X =  0 + 1 =  1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> operations = [&quot;++X&quot;,&quot;++X&quot;,&quot;X++&quot;]
<strong>Output:</strong> 3
<strong>Explanation: </strong>The operations are performed as follows:
Initially, X = 0.
++X: X is incremented by 1, X = 0 + 1 = 1.
++X: X is incremented by 1, X = 1 + 1 = 2.
X++: X is incremented by 1, X = 2 + 1 = 3.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> operations = [&quot;X++&quot;,&quot;++X&quot;,&quot;--X&quot;,&quot;X--&quot;]
<strong>Output:</strong> 0
<strong>Explanation:</strong>&nbsp;The operations are performed as follows:
Initially, X = 0.
X++: X is incremented by 1, X = 0 + 1 = 1.
++X: X is incremented by 1, X = 1 + 1 = 2.
--X: X is decremented by 1, X = 2 - 1 = 1.
X--: X is decremented by 1, X = 1 - 1 = 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= operations.length &lt;= 100</code></li>
	<li><code>operations[i]</code> will be either <code>&quot;++X&quot;</code>, <code>&quot;X++&quot;</code>, <code>&quot;--X&quot;</code>, or <code>&quot;X--&quot;</code>.</li>
</ul>
### Problem Explanation

The problem involves a programming language with only four operations (`++X`, `X++`, `--X`, `X--`) that affect a single variable `X`. Here's what each operation does:
1. `++X` and `X++`: Increment the value of `X` by 1.
2. `--X` and `X--`: Decrement the value of `X` by 1.

The initial value of `X` is 0, and the task is to calculate the final value of `X` after performing all the operations in the given array `operations`.

**Constraints**:
- The length of `operations` is between 1 and 100.
- Each operation in the array is one of the four valid operations (`++X`, `X++`, `--X`, `X--`).

---

### Approach

1. **Initialize `X`**:
   Start with `X = 0`.

2. **Iterate through the `operations` array**:
   - For each operation in the array:
     - If the operation is either `++X` or `X++`, increment `X` by 1.
     - If the operation is either `--X` or `X--`, decrement `X` by 1.

3. **Return the value of `X`**:
   After processing all operations, return the final value of `X`.

---

### Example Walkthroughs

#### Example 1:
**Input**: `operations = ["--X", "X++", "X++"]`  
**Step-by-Step Execution**:
- Initially, `X = 0`.
- Operation `--X`: Decrement `X` by 1 → `X = 0 - 1 = -1`.
- Operation `X++`: Increment `X` by 1 → `X = -1 + 1 = 0`.
- Operation `X++`: Increment `X` by 1 → `X = 0 + 1 = 1`.

**Output**: `1`

#### Example 2:
**Input**: `operations = ["++X", "++X", "X++"]`  
**Step-by-Step Execution**:
- Initially, `X = 0`.
- Operation `++X`: Increment `X` by 1 → `X = 0 + 1 = 1`.
- Operation `++X`: Increment `X` by 1 → `X = 1 + 1 = 2`.
- Operation `X++`: Increment `X` by 1 → `X = 2 + 1 = 3`.

**Output**: `3`

#### Example 3:
**Input**: `operations = ["X++", "++X", "--X", "X--"]`  
**Step-by-Step Execution**:
- Initially, `X = 0`.
- Operation `X++`: Increment `X` by 1 → `X = 0 + 1 = 1`.
- Operation `++X`: Increment `X` by 1 → `X = 1 + 1 = 2`.
- Operation `--X`: Decrement `X` by 1 → `X = 2 - 1 = 1`.
- Operation `X--`: Decrement `X` by 1 → `X = 1 - 1 = 0`.

**Output**: `0`

---





### Complexity Analysis
1. **Time Complexity**: \( O(n) \), where \( n \) is the length of the `operations` array. We iterate through the array once.
2. **Space Complexity**: \( O(1) \), as we only use a single variable `X` to store the result.


# Code

```python3 []
class Solution:
    def finalValueAfterOperations(self, operations: List[str]) -> int:
       X = 0
       for i in operations:
        if(i in ("X++","++X")):
            X+=1
        elif(i in ("X--","--X")):
            X-=1
       return X
        
```

```java []
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X=0;
        for(String i: operations){
            if(i.equals("X++") || i.equals("++X")){
                X++;
            }
            else if(i.equals("X--") || i.equals("--X")){
                X--;
            }
        }
        
        return X;

    }
}
```



---

### Explanation of the Code

1. **Initialization**:
   - `int X = 0;` initializes the variable `X` to 0.

2. **Iteration**:
   - The `for` loop iterates through each operation in the `operations` array.
   - Inside the loop:
     - If the operation is `"++X"` or `"X++"`, increment `X` by 1.
     - If the operation is `"--X"` or `"X--"`, decrement `X` by 1.

3. **Return the Result**:
   - After all operations are processed, the method returns the value of `X`.

4. **Testing**:
   - Several test cases are provided to validate the correctness of the implementation.

---



