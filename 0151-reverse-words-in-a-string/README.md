<h2><a href="https://leetcode.com/problems/reverse-words-in-a-string">151. Reverse Words in a String</a></h2><h3>Medium</h3><hr><p>Given an input string <code>s</code>, reverse the order of the <strong>words</strong>.</p>

<p>A <strong>word</strong> is defined as a sequence of non-space characters. The <strong>words</strong> in <code>s</code> will be separated by at least one space.</p>

<p>Return <em>a string of the words in reverse order concatenated by a single space.</em></p>

<p><b>Note</b> that <code>s</code> may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;the sky is blue&quot;
<strong>Output:</strong> &quot;blue is sky the&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;  hello world  &quot;
<strong>Output:</strong> &quot;world hello&quot;
<strong>Explanation:</strong> Your reversed string should not contain leading or trailing spaces.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;a good   example&quot;
<strong>Output:</strong> &quot;example good a&quot;
<strong>Explanation:</strong> You need to reduce multiple spaces between two words to a single space in the reversed string.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> contains English letters (upper-case and lower-case), digits, and spaces <code>&#39; &#39;</code>.</li>
	<li>There is <strong>at least one</strong> word in <code>s</code>.</li>
</ul>

<p>&nbsp;</p>
<p><b data-stringify-type="bold">Follow-up:&nbsp;</b>If the string data type is mutable in your language, can&nbsp;you solve it&nbsp;<b data-stringify-type="bold">in-place</b>&nbsp;with&nbsp;<code data-stringify-type="code">O(1)</code>&nbsp;extra space?</p>

# Detailed Explanation


---

### Step-by-Step Explanation:

---

### **Step 1: Remove extra spaces at the beginning and end of the string**

```java
s = s.trim();
```

- The `.trim()` function removes any extra spaces at the beginning or the end of the string `s`.
- Example: 
  - Input: `"  hello world  "`
  - Output: `"hello world"`

---

### **Step 2: Split the string into words**

```java
String[] words = s.split("\\s+");
```

- The `.split("\\s+")` function splits the string into an array of words.
- `"\\s+"` is a regular expression:
  - `\\s` means any space character.
  - `+` means one or more spaces.
- It splits the string into individual words, ignoring multiple spaces between words.

**Example:**
- Input: `"hello   world"`
- After `.split("\\s+")`: `words = ["hello", "world"]`

---

### **Step 3: Prepare to reverse the words**

```java
StringBuilder reversedSentence = new StringBuilder();
```

- A `StringBuilder` object is created to efficiently build the reversed sentence.
- It allows you to append words to it without creating a new string each time (more efficient than regular string concatenation).

---

### **Step 4: Loop through the words in reverse order**

```java
for (int i = words.length - 1; i >= 0; i--) {
```

- The loop starts from the **last word** in the `words` array (index `words.length - 1`) and moves to the **first word** (index `0`).
- This ensures the words are added in reverse order.

**Example:**
- `words = ["hello", "world"]`
- Loop order: `"world"` → `"hello"`

---

### **Step 5: Add the current word to the reversed sentence**

```java
reversedSentence.append(words[i]);
```

- The `.append()` method adds the current word (`words[i]`) to the `reversedSentence`.

**Example:**
- First iteration: `"world"` is added.
- Second iteration: `"hello"` is added.

---

### **Step 6: Add a space between words**

```java
if (i > 0) {
    reversedSentence.append(" ");
}
```

- If the current word is **not the last word** in the reversed sentence, we add a space after it.
- This ensures proper spacing between words but avoids adding a trailing space at the end.

**Example:**
- After adding `"world"`: `"world "`
- After adding `"hello"`: `"world hello"`

---

### **Step 7: Convert the result to a string**

```java
return reversedSentence.toString();
```

- The `.toString()` method converts the `StringBuilder` object into a regular string, which is then returned as the result.

---

### Full Example Walkthrough:

#### Input:
```java
s = "  the   sky   is blue  "
```

#### Step-by-Step Execution:
1. **Trim extra spaces:**
   ```java
   s = "the   sky   is blue";
   ```

2. **Split into words:**
   ```java
   words = ["the", "sky", "is", "blue"];
   ```

3. **Reverse the words:**
   - Start from the last word (`"blue"`) and add it to the result.
   - Add `"is"`, then `"sky"`, and finally `"the"`.
   - Ensure there’s a space between words, but no trailing space at the end.

4. **Final Result:**
   ```java
   "blue is sky the"
   ```

---

### Key Points to Remember:
- `.trim()` removes unnecessary spaces at the edges.
- `.split("\\s+")` splits the string into words while handling multiple spaces.
- The loop processes the words in reverse order.
- A `StringBuilder` is used for efficient string building.

Let me know if you have further doubts! 😊

# Approach
# Steps:

**1.Trim the string:**

After .trim(), the string becomes "hello world" (no spaces at the start or end).

**2.Split into words:**

.split("\\s+") splits the string into words: ["hello", "world"].

**3.Reverse the words:**

We start from "world" (last word) and add it to reversedSentence.
Then, we add "hello" (first word).
The result so far is: "world hello".

**4.Return the result:**

The final result is "world hello", which is the words reversed and properly spaced.

# Complexity
- Time complexity:  **O(n)**
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:  **O(n)**
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] words =s.split("\\s+");
        StringBuilder reversedSentence = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence.append(words[i]);
            if (i > 0) {
                reversedSentence.append(" ");  
            }
            
        }
         return reversedSentence.toString();
       
    }
}
```
