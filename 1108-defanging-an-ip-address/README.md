<h2><a href="https://leetcode.com/problems/defanging-an-ip-address/">1108. Defanging an IP Address</a></h2><h3>Easy</h3><hr><p>Given a valid (IPv4) IP <code>address</code>, return a defanged version of that IP address.</p>

<p>A <em>defanged&nbsp;IP address</em>&nbsp;replaces every period <code>&quot;.&quot;</code> with <code>&quot;[.]&quot;</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> address = "1.1.1.1"
<strong>Output:</strong> "1[.]1[.]1[.]1"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> address = "255.100.50.0"
<strong>Output:</strong> "255[.]100[.]50[.]0"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The given <code>address</code> is a valid IPv4 address.</li>
</ul>

### Problem Explanation:

The problem requires converting a given valid IPv4 address into its "defanged" version. In the defanged version, every period `.` in the address should be replaced with `[.]`.

#### **Example 1:**
- **Input**: `"1.1.1.1"`
- **Output**: `"1[.]1[.]1[.]1"`

#### **Example 2:**
- **Input**: `"255.100.50.0"`
- **Output**: `"255[.]100[.]50[.]0"`

---

### Approach:

1. **Input Constraints**:
   - The address will always be a valid IPv4 address, so you do not need to validate the format.
   - The task is only to replace each period `.` with `[.]`.

2. **Defanging Process**:
   - In a valid IPv4 address, the address contains 3 periods `.` separating the four parts of the address. You need to replace each period with `[.]`.

3. **Steps**:
   - You can simply iterate over the string and replace every occurrence of `.` with `[.]`.
   - This can be done easily using the built-in string method `replace()` in both Python and Java.

---

### Python Approach:

```python
class Solution:
    def defangIPaddr(self, address: str) -> str:
        # Use the replace function to replace '.' with '[.]'
        return address.replace(".", "[.]")
```

#### **Explanation**:
- The `replace()` function in Python is used to replace each occurrence of `.` with `[.]` in the string `address`.
- The time complexity is **O(n)**, where `n` is the length of the string, as we need to traverse through the entire string to perform the replacement.

---

### Java Approach:

```java
class Solution {
    public String defangIPaddr(String address) {
        // Use the replace function to replace '.' with '[.]'
        return address.replace(".", "[.]");
    }
}
```

#### **Explanation**:
- Similar to Python, Java also provides a `replace()` method for strings, which is used to replace all occurrences of `.` with `[.]`.
- The time complexity is **O(n)**, where `n` is the length of the string.

---

### Key Insights:
- Both Python and Java make it easy to solve this problem with their built-in `replace()` function.
- The problem has a **linear time complexity** (O(n)) where n is the length of the input string, since each character is processed once.
- Since the input is always a valid IPv4 address, there's no need for validation. You just need to perform the replacement operation.

# Code
```java []
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        res.append("");
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.')
                res.append("[.]");
            else
                res.append(address.charAt(i));
        }
        return res.toString();
    }
}
```

```python3 []
class Solution:
    def defangIPaddr(self, address: str) -> str:
        add= address.replace('.','[.]')
        return add
        
```
