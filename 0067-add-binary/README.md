<h2><a href="https://leetcode.com/problems/add-binary">67. Add Binary</a></h2><h3>Easy</h3><hr><p>Given two binary strings <code>a</code> and <code>b</code>, return <em>their sum as a binary string</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> a = "11", b = "1"
<strong>Output:</strong> "100"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> a = "1010", b = "1011"
<strong>Output:</strong> "10101"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= a.length, b.length &lt;= 10<sup>4</sup></code></li>
	<li><code>a</code> and <code>b</code> consist&nbsp;only of <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code> characters.</li>
	<li>Each string does not contain leading zeros except for the zero itself.</li>
</ul>
### Problem Explanation:
The problem asks us to add two binary strings and return the result in binary format. 

Let's break down the solution step by step:

### Step-by-Step Explanation:

1. **Input**:
   We are given two strings `a` and `b`, which represent binary numbers. The goal is to add these numbers as binary and return the result as a string.

2. **Step 1: Convert Binary Strings to BigInteger**:
   - We convert the binary strings `a` and `b` into `BigInteger` objects. `BigInteger` is a class in Java that allows for handling very large numbers that exceed the size of primitive data types like `int` or `long`.
   - The method `new BigInteger(a, 2)` takes a string representation of a number and a base (in this case, `2` for binary) and converts the string to a `BigInteger`.
   
   Example:
   - `a = "1010"` (binary representation of 10)
   - `b = "1101"` (binary representation of 13)
   
   ```java
   BigInteger first = new BigInteger(a, 2); // first = 10 (in decimal)
   BigInteger second = new BigInteger(b, 2); // second = 13 (in decimal)
   ```

3. **Step 2: Add the BigInteger Objects**:
   - We now add the two `BigInteger` values using the `add` method of `BigInteger`.
   
   Example:
   - `first = 10` (in decimal)
   - `second = 13` (in decimal)
   
   ```java
   BigInteger result = first.add(second); // result = 23 (in decimal)
   ```

4. **Step 3: Convert the Result Back to Binary**:
   - We need the result in binary, so we convert the `BigInteger` result back to a binary string using the `toString(2)` method, which converts the number into a binary string representation.
   
   Example:
   - `result = 23` (in decimal)
   - `23` in binary is `10111`.
   
   ```java
   return result.toString(2); // Returns "10111"
   ```

5. **Final Output**:
   The final output will be the binary representation of the sum of the two numbers.

### Example Walkthrough:

#### Example 1:
Let’s walk through an example:

- Input:
  - `a = "1010"` (binary of 10)
  - `b = "1101"` (binary of 13)

- **Step 1**: Convert both strings to `BigInteger`:
  ```java
  BigInteger first = new BigInteger("1010", 2); // first = 10 (decimal)
  BigInteger second = new BigInteger("1101", 2); // second = 13 (decimal)
  ```

- **Step 2**: Add the `BigInteger` values:
  ```java
  BigInteger result = first.add(second); // result = 10 + 13 = 23 (decimal)
  ```

- **Step 3**: Convert the result back to binary:
  ```java
  return result.toString(2); // "10111"
  ```

- **Output**: `"10111"` (which is the binary representation of 23)

#### Example 2:
Let’s consider another example:

- Input:
  - `a = "110"` (binary of 6)
  - `b = "101"` (binary of 5)

- **Step 1**: Convert both strings to `BigInteger`:
  ```java
  BigInteger first = new BigInteger("110", 2); // first = 6 (decimal)
  BigInteger second = new BigInteger("101", 2); // second = 5 (decimal)
  ```

- **Step 2**: Add the `BigInteger` values:
  ```java
  BigInteger result = first.add(second); // result = 6 + 5 = 11 (decimal)
  ```

- **Step 3**: Convert the result back to binary:
  ```java
  return result.toString(2); // "1011"
  ```

- **Output**: `"1011"` (which is the binary representation of 11)

### Summary of Key Points:

- We use `BigInteger` to handle large binary numbers.
- We convert the binary string to `BigInteger`, add the numbers, and then convert the result back to binary.
- The conversion to and from binary is straightforward in Java using `BigInteger`.

Let me know if you have any more questions about the approach!

# Code
```java []
import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger first = new BigInteger(a, 2);
        BigInteger second = new BigInteger(b, 2);
        var result = first.add(second);
        return result.toString(2);
    }
}
```
