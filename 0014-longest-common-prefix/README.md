<h2><a href="https://leetcode.com/problems/longest-common-prefix/">14. Longest Common Prefix</a></h2><h3>Easy</h3><hr><div><p>Write a function to find the longest common prefix string amongst an array of strings.</p>

<p>If there is no common prefix, return an empty string <code>""</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> strs = ["flower","flow","flight"]
<strong>Output:</strong> "fl"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> strs = ["dog","racecar","car"]
<strong>Output:</strong> ""
<strong>Explanation:</strong> There is no common prefix among the input strings.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 200</code></li>
	<li><code>0 &lt;= strs[i].length &lt;= 200</code></li>
	<li><code>strs[i]</code> consists of only lowercase English letters.</li>
</ul>
</div>


Sure! Here's a simpler, line-by-line explanation of the code, along with an example.

### **Code Explanation:**

```java
Arrays.sort(strs);
```
- **Action:** Sort the input array of strings alphabetically.
- **Example:**  
  Input: `["flower", "flow", "flight"]`  
  After sorting: `["flight", "flow", "flower"]`

---

```java
String str1 = strs[0];
String str2 = strs[strs.length - 1];
```
- **Action:** Select the first (`str1`) and last (`str2`) strings in the sorted array.
- **Example:**  
  After sorting, `str1 = "flight"` and `str2 = "flower"`

---

```java
int index = 0;
```
- **Action:** Initialize a variable `index` to keep track of how many characters from the start match between `str1` and `str2`.
- **Example:**  
  `index = 0` means we start comparing characters from the first character.

---

```java
while (index < str1.length()) {
    if (str1.charAt(index) == str2.charAt(index)) {
        index++;
    } else {
        break;
    }
}
```
- **Action:** Compare the characters of `str1` and `str2` one by one.
  - If they match, increment the `index`.
  - If they don't match, stop the comparison.
- **Example:**  
  Comparing `"flight"` and `"flower"`:
  - Index 0: 'f' == 'f' → `index` becomes 1.
  - Index 1: 'l' == 'l' → `index` becomes 2.
  - Index 2: 'i' ≠ 'o' → Stop comparing.

---

```java
return index == 0 ? "" : str1.substring(0, index);
```
- **Action:** If no characters matched (`index == 0`), return an empty string. Otherwise, return the substring from `str1` up to `index` as the common prefix.
- **Example:**  
  Since `index = 2`, return `"flight".substring(0, 2)` → `"fl"`

---

### **Example Walkthrough:**

#### Input:
```plaintext
strs = ["flower", "flow", "flight"]
```

#### Steps:
1. **Sort the array:**
   - Before: `["flower", "flow", "flight"]`
   - After sorting: `["flight", "flow", "flower"]`

2. **Select `str1` and `str2`:**
   - `str1 = "flight"`, `str2 = "flower"`

3. **Compare characters of `str1` and `str2`:**
   - Index 0: 'f' == 'f' → `index = 1`
   - Index 1: 'l' == 'l' → `index = 2`
   - Index 2: 'i' ≠ 'o' → Stop comparing.

4. **Return the result:**
   - Since `index = 2`, return `"flight".substring(0, 2)` → `"fl"`

#### Output:
```plaintext
"fl"
```

---

### **Summary:**
This code finds the **longest common prefix** by:
- Sorting the array to compare the first and last strings.
- Comparing each character of the first and last strings.
- Returning the common prefix based on the number of matching characters.
