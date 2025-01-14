<h2><a href="https://leetcode.com/problems/jewels-and-stones">782. Jewels and Stones</a></h2><h3>Easy</h3><hr><p>You&#39;re given strings <code>jewels</code> representing the types of stones that are jewels, and <code>stones</code> representing the stones you have. Each character in <code>stones</code> is a type of stone you have. You want to know how many of the stones you have are also jewels.</p>

<p>Letters are case sensitive, so <code>&quot;a&quot;</code> is considered a different type of stone from <code>&quot;A&quot;</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> jewels = "aA", stones = "aAAbbbb"
<strong>Output:</strong> 3
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> jewels = "z", stones = "ZZ"
<strong>Output:</strong> 0
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;jewels.length, stones.length &lt;= 50</code></li>
	<li><code>jewels</code> and <code>stones</code> consist of only English letters.</li>
	<li>All the characters of&nbsp;<code>jewels</code> are <strong>unique</strong>.</li>
</ul>
### **Problem Explanation**

You are given two strings:

1. **`jewels`**: Represents the types of stones that are considered jewels.  
   - Each character in `jewels` is unique.
   - Characters are case-sensitive, meaning `'a'` and `'A'` are treated as different jewels.

2. **`stones`**: Represents the collection of stones you have.  
   - Each character in `stones` represents one stone type you have.

The task is to determine how many stones from `stones` are also jewels (characters present in `jewels`).

---

### **Key Points**

1. **Case Sensitivity**:
   - `'a'` and `'A'` are treated as different characters.
   - For example, if `jewels = "aA"` and `stones = "aAAbbbb"`, both `'a'` and `'A'` are jewels.

2. **Character Uniqueness in `jewels`**:
   - The `jewels` string contains only unique characters.
   - For example, if `jewels = "abc"`, no character will repeat in `jewels`.

3. **Counting Stones**:
   - Check each character in the `stones` string.
   - If it exists in the `jewels` string, increase the count.

---

### **Constraints**
- **1 ≤ jewels.length, stones.length ≤ 50**: Both strings are short, making it feasible to iterate over them.
- `jewels` and `stones` consist only of **English letters** (both uppercase and lowercase).
- All characters in `jewels` are **unique**.

---

### **Examples**

#### **Example 1**

**Input**:  
`jewels = "aA"`  
`stones = "aAAbbbb"`

**Explanation**:  
- The `jewels` string contains `'a'` and `'A'`.
- In `stones`, `'a'` appears **once** and `'A'` appears **twice**. These are jewels.
- Total jewel count: \( 1 + 2 = 3 \).

**Output**:  
`3`

---

#### **Example 2**

**Input**:  
`jewels = "z"`  
`stones = "ZZ"`

**Explanation**:  
- The `jewels` string contains `'z'`.
- In `stones`, there are no `'z'` characters. `'Z'` is not the same as `'z'` because of case sensitivity.
- Total jewel count: \( 0 \).

**Output**:  
`0`

---

### **Approach**

The problem can be solved efficiently using a **set** data structure:

1. **Store `jewels` in a Set**:
   - Convert the `jewels` string into a `HashSet` for quick lookups.
   - This allows checking if a character is a jewel in \( O(1) \) time.

2. **Iterate Through `stones`**:
   - For each character in `stones`, check if it exists in the `jewels` set.
   - If it does, increase the count.

3. **Return the Count**:
   - The final count gives the total number of jewels in the `stones` string.

This approach minimizes unnecessary comparisons and ensures optimal performance.

# Code
```java []
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count=0;
        for(int i=0;i<stones.length();i++){
            for(int j=0;j<jewels.length();j++){
                if(stones.charAt(i)==jewels.charAt(j)) count++;
                }
                
            }
            return count;
        }
}

```
```java []
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
      HashSet <Character> set=new HashSet<>();
        for(char j : jewels.toCharArray()){
            set.add(j);
        }
        int count = 0;
        for(char s: stones.toCharArray()){
            if(set.contains(s)){
                count++;
            }
        }
        return count;
    }
}

```
```python3 []
class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        count = 0
        for stone in stones:
            if stone in jewels:
                count += 1
        return count

```
