<h2><a href="https://leetcode.com/problems/increasing-triplet-subsequence">Increasing Triplet Subsequence</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given an integer array <code>nums</code>, return <code>true</code><em> if there exists a triple of indices </em><code>(i, j, k)</code><em> such that </em><code>i &lt; j &lt; k</code><em> and </em><code>nums[i] &lt; nums[j] &lt; nums[k]</code>. If no such indices exists, return <code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4,5]
<strong>Output:</strong> true
<strong>Explanation:</strong> Any triplet where i &lt; j &lt; k is valid.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [5,4,3,2,1]
<strong>Output:</strong> false
<strong>Explanation:</strong> No triplet exists.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,1,5,0,4,6]
<strong>Output:</strong> true
<strong>Explanation:</strong> The triplet (3, 4, 5) is valid because nums[3] == 0 &lt; nums[4] == 4 &lt; nums[5] == 6.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 5 * 10<sup>5</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you implement a solution that runs in <code>O(n)</code> time complexity and <code>O(1)</code> space complexity?







# **Approach to Solve the Problem:**

The goal is to find if there exists a triplet \( i, j, k \) such that:

1. \( i < j < k \)
2. \( nums[i] < nums[j] < nums[k] \)

We need to implement this in **O(n)** time complexity with **O(1)** space. Here's how the approach works:

---

### **Step-by-Step Approach**

#### **1. Initialize Two Variables**
- **`i`**: Tracks the smallest number seen so far.
- **`j`**: Tracks the second smallest number greater than `i`.
  
Both are initialized to `Integer.MAX_VALUE` (a placeholder for a very large value).

```java
int i = Integer.MAX_VALUE;
int j = Integer.MAX_VALUE;
```

---

#### **2. Iterate Through the Array**
We loop through each number in the array:

```java
for (int num : nums) {
    ...
}
```

---

#### **3. Update `i` (Smallest Number)**
- If the current number is smaller than or equal to `i`, update `i` to the current number.

**Why?**
- We are looking for the smallest possible value as the first number in the triplet.

```java
if (num <= i) {
    i = num;
}
```

---

#### **4. Update `j` (Second Smallest Number)**
- If the current number is larger than `i` but smaller than or equal to `j`, update `j`.

**Why?**
- Once `i` is determined, we look for the smallest number greater than `i` to form the second part of the triplet.

```java
else if (num <= j) {
    j = num;
}
```

---

#### **5. Check for the Third Number**
- If the current number is greater than both `i` and `j`, we’ve found the triplet.

**Why?**
- A number greater than both `i` and `j` completes the condition \( nums[i] < nums[j] < nums[k] \).

```java
else {
    return true; // Triplet found
}
```

---

#### **6. Return False if No Triplet Found**
- If the loop completes and no such triplet is found, return `false`.

```java
return false;
```

---

### **Illustration with Example**

#### Input:
```plaintext
nums = [2, 1, 5, 0, 4, 6]
```

#### Execution Steps:

| Step | Current `num` | `i`  | `j`  | Action Taken                           | Triplet Exists? |
|------|---------------|------|------|----------------------------------------|-----------------|
| 1    | 2             | 2    | MAX  | Update `i`                             | No              |
| 2    | 1             | 1    | MAX  | Update `i`                             | No              |
| 3    | 5             | 1    | 5    | Update `j`                             | No              |
| 4    | 0             | 0    | 5    | Update `i`                             | No              |
| 5    | 4             | 0    | 4    | Update `j`                             | No              |
| 6    | 6             | 0    | 4    | Found a number greater than `i` and `j`| Yes (0, 4, 6)   |

---

### **Key Observations**

1. **`i` and `j` dynamically adjust:**  
   - `i` keeps track of the smallest number.  
   - `j` keeps track of the smallest number greater than `i`.  

2. **Greedy Selection:**  
   The algorithm efficiently picks the smallest values for `i` and `j`, ensuring any number larger than both forms the triplet.

3. **Early Exit:**  
   The moment a valid triplet is found, the function exits, saving time.

---

### **Time and Space Complexity**

1. **Time Complexity:**  
   - **O(n)**: The loop iterates over the array once.

2. **Space Complexity:**  
   - **O(1)**: Only two variables (`i` and `j`) are used, independent of the array size.
### Example Input:
```plaintext
nums = [2, 1, 5, 0, 4, 6]
```

---

#### **Step 1 and Step 2**: Initialize `i` and `j`

- Initially:
  - `i = Integer.MAX_VALUE` (represents the smallest number seen so far).
  - `j = Integer.MAX_VALUE` (represents the second smallest number greater than `i`).

```plaintext
i = MAX, j = MAX
```

---

#### **Step 3**: Loop through the Array

We iterate through each element in `nums`.

---

#### Iteration 1: `num = 2`

**Condition Check:**
- `num <= i` → Yes (`2 <= MAX`).

**Action:**
- Update `i` to `num`.

```plaintext
i = 2, j = MAX
```

---

#### Iteration 2: `num = 1`

**Condition Check:**
- `num <= i` → Yes (`1 <= 2`).

**Action:**
- Update `i` to `num`.

```plaintext
i = 1, j = MAX
```

---

#### Iteration 3: `num = 5`

**Condition Check:**
- `num <= i` → No (`5 > 1`).
- `num <= j` → Yes (`5 <= MAX`).

**Action:**
- Update `j` to `num`.

```plaintext
i = 1, j = 5
```

---

#### Iteration 4: `num = 0`

**Condition Check:**
- `num <= i` → Yes (`0 <= 1`).

**Action:**
- Update `i` to `num`.

```plaintext
i = 0, j = 5
```

---

#### Iteration 5: `num = 4`

**Condition Check:**
- `num <= i` → No (`4 > 0`).
- `num <= j` → Yes (`4 <= 5`).

**Action:**
- Update `j` to `num`.

```plaintext
i = 0, j = 4
```

---

#### Iteration 6: `num = 6`

**Condition Check:**
- `num <= i` → No (`6 > 0`).
- `num <= j` → No (`6 > 4`).

**Action:**
- This satisfies the triplet condition \( i < j < k \):
  - `i = 0`, `j = 4`, and `num = 6`.

**Result:**
- Return `true`.

---

### Final Output:

The triplet `(0, 4, 6)` satisfies the condition, so the output is:

```plaintext
true
```

---

### Explanation Summary for Each Step:

1. Start with the largest possible values for `i` and `j`.
2. Update `i` if a smaller value is found.
3. Update `j` if a value larger than `i` but smaller than `j` is found.
4. If a value larger than both `i` and `j` is found, return `true` (triplet exists).
5. If no such triplet is found after checking all numbers, return `false`.

# Code
```java []
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for(int num:nums){
            if(num<=i){
                i=num;
            }
            else if(num<=j){
                j=num;
            }
            else{
                return true;
            }
        }
        return false;
        
    }
}
```
