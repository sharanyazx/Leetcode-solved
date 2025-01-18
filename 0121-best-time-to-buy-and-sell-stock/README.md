<h2><a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">121. Best Time to Buy and Sell Stock</a></h2><h3>Easy</h3><hr><p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>You want to maximize your profit by choosing a <strong>single day</strong> to buy one stock and choosing a <strong>different day in the future</strong> to sell that stock.</p>

<p>Return <em>the maximum profit you can achieve from this transaction</em>. If you cannot achieve any profit, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> prices = [7,1,5,3,6,4]
<strong>Output:</strong> 5
<strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> In this case, no transactions are done and the max profit = 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
</ul>

### **Understanding the Problem**

#### Problem Statement
You are given an array `prices` where `prices[i]` represents the stock price on the \(i^{th}\) day. Your task is to determine the **maximum profit** you can achieve by:
1. Buying the stock on one day.
2. Selling it on another day (after the buying day).

**Constraints:**
- You can only perform **one transaction** (buy once and sell once).
- If no profit is possible (e.g., prices are in decreasing order), the result should be `0`.

---

### **Approach**

To solve the problem, you need to:
1. Track the **minimum price** seen so far as you iterate through the array.
2. Calculate the **profit** for each price by subtracting the minimum price from the current price.
3. Keep track of the **maximum profit**.

---

### **Step-by-Step Explanation**

#### Example:  
**Input:**  
```text
prices = [7, 1, 5, 3, 6, 4]
```

---

#### Step 1: Initialization
- Start with:
  - `min = ∞` (to track the lowest price seen so far).
  - `maxProfit = 0` (to track the highest profit found).

#### Step 2: Iterate Through the Array
For each price \( p \) in `prices`:
1. Check if \( p \) is less than `min`:
   - Update `min` to \( p \) because we found a new lowest price.
2. Otherwise, calculate the **profit**:
   - `profit = p - min`
3. If `profit` is greater than `maxProfit`, update `maxProfit`.

---

#### Detailed Walkthrough:
**Day 1: Price = 7**
- `min = ∞`, `maxProfit = 0`
- \( 7 < ∞ \) → Update `min = 7`.
- No profit calculation since it's the first day.

**Day 2: Price = 1**
- \( 1 < 7 \) → Update `min = 1`.
- No profit calculation yet.

**Day 3: Price = 5**
- \( 5 > 1 \): Calculate profit.
  - `profit = 5 - 1 = 4`
  - \( 4 > 0 \): Update `maxProfit = 4`.

**Day 4: Price = 3**
- \( 3 > 1 \): Calculate profit.
  - `profit = 3 - 1 = 2`
  - \( 2 < 4 \): No change to `maxProfit`.

**Day 5: Price = 6**
- \( 6 > 1 \): Calculate profit.
  - `profit = 6 - 1 = 5`
  - \( 5 > 4 \): Update `maxProfit = 5`.

**Day 6: Price = 4**
- \( 4 > 1 \): Calculate profit.
  - `profit = 4 - 1 = 3`
  - \( 3 < 5 \): No change to `maxProfit`.

---

### **Final Output**
- **Maximum Profit:** `5`

---

### **Key Observations**
1. If the prices are decreasing (e.g., `[7, 6, 5, 4]`), the maximum profit will remain `0` because there’s no way to make a profit.
2. We never "sell before buying" because we track the minimum price as we iterate.

---

### **Optimized Approach**

#### **Algorithm**
1. Initialize:
   - `min = Integer.MAX_VALUE`
   - `maxProfit = 0`
2. Loop through the `prices` array:
   - Update `min` if the current price is smaller.
   - Calculate `profit` as the difference between the current price and `min`.
   - Update `maxProfit` if `profit` is larger than the current value.
3. Return `maxProfit`.

#### **Time Complexity:**
- \( O(n) \): Single traversal of the array.

#### **Space Complexity:**
- \( O(1) \): No extra space is used.

---



### **Edge Cases**
1. **Empty Array:**
   - Input: `prices = []`
   - Output: `0`

2. **Single Day:**
   - Input: `prices = [7]`
   - Output: `0`

3. **Decreasing Prices:**
   - Input: `prices = [7, 6, 4, 3, 1]`
   - Output: `0`

4. **All Prices Same:**
   - Input: `prices = [5, 5, 5, 5]`
   - Output: `0`
### Explanation of the Java Solution

The given code is an efficient solution for the "Best Time to Buy and Sell Stock" problem. Below is a step-by-step breakdown:

---

### **Initialization**
1. **`int min = Integer.MAX_VALUE;`**
   - Tracks the minimum price encountered so far.
   - Initialized to the largest possible integer to ensure that any stock price in the array is smaller initially.

2. **`int max = 0;`**
   - Tracks the maximum profit achievable during the iteration.
   - Starts at `0` because if no profitable transaction is possible, the output should be `0`.

---

### **Iterating Through Prices**
```java
for (int p : prices) {
    if (p < min)
        min = p;
    else if (p - min > max)
        max = p - min;
}
```

#### Steps:
1. **`for (int p : prices)`**:
   - Iterates through each stock price `p` in the input array `prices`.

2. **`if (p < min)`**:
   - Checks if the current price `p` is smaller than the minimum price encountered so far (`min`).
   - If true, updates `min` to the current price `p`.

3. **`else if (p - min > max)`**:
   - If the current price `p` is not less than `min`, calculates the profit by selling at price `p` (i.e., `p - min`).
   - Compares the calculated profit with the current maximum profit (`max`).
   - If the calculated profit is greater than `max`, updates `max`.

---

### **Returning the Result**
```java
return max;
```
- After iterating through all prices, the variable `max` contains the highest profit achievable, which is returned as the result.

---

### **Example Walkthrough**

#### **Input:**
```java
prices = [7, 1, 5, 3, 6, 4];
```

1. **Initialization:**
   - `min = Integer.MAX_VALUE`
   - `max = 0`

2. **Iteration:**

   - **Day 1 (Price = 7):**
     - `p < min` → `7 < Integer.MAX_VALUE`: Update `min = 7`.
   - **Day 2 (Price = 1):**
     - `p < min` → `1 < 7`: Update `min = 1`.
   - **Day 3 (Price = 5):**
     - `p - min > max` → `5 - 1 > 0`: Update `max = 4`.
   - **Day 4 (Price = 3):**
     - `p - min > max` → `3 - 1 > 4`: No change.
   - **Day 5 (Price = 6):**
     - `p - min > max` → `6 - 1 > 4`: Update `max = 5`.
   - **Day 6 (Price = 4):**
     - `p - min > max` → `4 - 1 > 5`: No change.

3. **Result:**
   - Return `max = 5`.

---

### **Output**

For the input:
```java
prices = [7, 1, 5, 3, 6, 4];
```

**Output:**
```java
5
```

---

### **Edge Cases**
1. **Empty or Single-Element Array:**
   - If `prices` is empty or has only one element, no transaction is possible, and the profit is `0`.
   
   Example:
   ```java
   prices = [];
   Output: 0
   ```

2. **Decreasing Prices:**
   - If all prices are in a decreasing order, no profit can be made, and the result is `0`.
   
   Example:
   ```java
   prices = [7, 6, 4, 3, 1];
   Output: 0
   ```

---


# Code
```java []
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int p : prices) {
            if (p < min)
                min = p;
            else if (p - min > max)
                max = p - min;

        }
        return max;
    }
}
```
```python3 []
import sys
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        #return max([price - min(prices) for price in prices])
        max=0
        min=sys.maxsize
        for p in prices:
            if(p<min):
                min=p
            elif(p-min>max):
                max=p-min
        return max
        
```
