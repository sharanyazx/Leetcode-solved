<h2><a href="https://leetcode.com/problems/bitwise-xor-of-all-pairings">2533. Bitwise XOR of All Pairings</a></h2><h3>Medium</h3><hr><p>You are given two <strong>0-indexed</strong> arrays, <code>nums1</code> and <code>nums2</code>, consisting of non-negative integers. There exists another array, <code>nums3</code>, which contains the bitwise XOR of <strong>all pairings</strong> of integers between <code>nums1</code> and <code>nums2</code> (every integer in <code>nums1</code> is paired with every integer in <code>nums2</code> <strong>exactly once</strong>).</p>

<p>Return<em> the <strong>bitwise XOR</strong> of all integers in </em><code>nums3</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [2,1,3], nums2 = [10,2,5,0]
<strong>Output:</strong> 13
<strong>Explanation:</strong>
A possible nums3 array is [8,0,7,2,11,3,4,1,9,1,6,3].
The bitwise XOR of all these numbers is 13, so we return 13.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [1,2], nums2 = [3,4]
<strong>Output:</strong> 0
<strong>Explanation:</strong>
All possible pairs of bitwise XORs are nums1[0] ^ nums2[0], nums1[0] ^ nums2[1], nums1[1] ^ nums2[0],
and nums1[1] ^ nums2[1].
Thus, one possible nums3 array is [2,5,1,6].
2 ^ 5 ^ 1 ^ 6 = 0, so we return 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums1[i], nums2[j] &lt;= 10<sup>9</sup></code></li>
</ul>
## Problem: Bitwise XOR of All Pairings

### Problem Statement Recap
Given two arrays `nums1` and `nums2`, compute the XOR of all pairings between them. A pairing means combining every element of `nums1` with every element of `nums2` and applying the XOR operation. Return the result of XORing all pair results.

---

### Step-by-Step Solution

#### Example Input
- `nums1 = [2, 3]`
- `nums2 = [1, 5]`

---

### Step 1: Compute XOR for `nums1`
To compute the cumulative XOR of `nums1`:

- `2 = 10` (binary)  
- `3 = 11` (binary)

Perform XOR:  
`10 ⊕ 11 = 01` (binary, decimal = 1)

Thus, `xor1 = 1`.

---

### Step 2: Compute XOR for `nums2`
To compute the cumulative XOR of `nums2`:

- `1 = 01` (binary)  
- `5 = 101` (binary)

Perform XOR:  
`01 ⊕ 101 = 100` (binary, decimal = 4)

Thus, `xor2 = 4`.

---

### Step 3: Determine Parity of Array Lengths
- Length of `nums1 = 2` (even)  
- Length of `nums2 = 2` (even)

---

### Step 4: Use XOR Properties
- If both lengths are even, every element contributes an even number of times to the result, so they cancel out. The final result is:  
  **Result = 0**

---

### Verification Using Pair-Wise XOR

Generate all pairings:
1. `2 ⊕ 1 = 10 ⊕ 01 = 11` (binary, decimal = 3)  
2. `2 ⊕ 5 = 10 ⊕ 101 = 111` (binary, decimal = 7)  
3. `3 ⊕ 1 = 11 ⊕ 01 = 10` (binary, decimal = 2)  
4. `3 ⊕ 5 = 11 ⊕ 101 = 110` (binary, decimal = 6)

Perform cumulative XOR:  
`3 ⊕ 7 ⊕ 2 ⊕ 6 = 0` (after step-by-step XOR calculation)

---

### Another Example

#### Input
- `nums1 = [1, 2, 3]`
- `nums2 = [4, 5]`

#### Step 1: Compute XOR for `nums1`
- `1 = 001`, `2 = 010`, `3 = 011`
- Perform XOR:  
  `001 ⊕ 010 ⊕ 011 = 000`  
- `xor1 = 0`

#### Step 2: Compute XOR for `nums2`
- `4 = 100`, `5 = 101`
- Perform XOR:  
  `100 ⊕ 101 = 001`  
- `xor2 = 1`

#### Step 3: Determine Parity
- Length of `nums1 = 3` (odd)  
- Length of `nums2 = 2` (even)

#### Result
- If `nums1` is odd and `nums2` is even:  
  **Result = xor1 = 0**

---





### Complexity Analysis

1. **Time Complexity**:  
   - \(O(n + m)\), where \(n\) is the size of `nums1` and \(m\) is the size of `nums2`.  
   - Each array is traversed once.

2. **Space Complexity**:  
   - \(O(1)\), as no additional space is used. 

--- 


# Code
```java []
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int a=0;
        int b=0;
        for(int i: nums1){
            a^=i;
        }
        for(int j:nums2){
           b^=j;
        }
        if(nums1.length%2 !=0 && nums2.length%2!=0){
            return a^b;
        }
        if(nums1.length%2 !=0) return b;
        if(nums2.length%2 !=0) return a;
        else return 0;
    }
}
```
