<h2><a href="https://leetcode.com/problems/count-primes/?envType=problem-list-v2&envId=math">204. Count Primes</a></h2><h3>Medium</h3><hr><p>Given an integer <code>n</code>, return <em>the number of prime numbers that are strictly less than</em> <code>n</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 10
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 0
<strong>Output:</strong> 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 5 * 10<sup>6</sup></code></li>
</ul>


---

### **Problem**:
You need to count the number of **prime numbers** less than a given integer `n`.

---

### **Solution Approach**:
We will use the **Sieve of Eratosthenes** algorithm to efficiently find all the primes less than `n`. The algorithm works by iteratively marking the multiples of each prime starting from `2`. Here's the breakdown:

### **Steps**:
1. **Edge Case Handling**:
   - If `n <= 2`, there are no primes, so return 0.

2. **Initialize a list** to mark numbers as prime or non-prime:
   - Create a boolean list `isPrime` where each index represents whether that number is prime or not.
   - Set `isPrime[0]` and `isPrime[1]` to `False` because 0 and 1 are not prime numbers.

3. **Sieve Algorithm**:
   - Loop through numbers from `2` to `sqrt(n)`. If the number is still marked as prime, mark all of its multiples as non-prime.

4. **Count Primes**:
   - Count how many `True` values are left in the `isPrime` list, which represents the prime numbers.

### **Code Implementation**:


### **Explanation**:
1. **Input**: The function `countPrimes` receives an integer `n`.
2. **Edge Case**: If `n` is less than or equal to 2, return 0 (no primes below 2).
3. **Prime Number Marking**:
   - We start by marking `True` for all numbers in the range from `2` to `n-1`.
   - We iterate through each number, and for each prime `i`, we mark its multiples as `False`.
4. **Counting Primes**: Finally, we sum the `True` values in `isPrime`, which represents the number of primes less than `n`.

### **Example**:

For `n = 10`:
- The primes less than 10 are `[2, 3, 5, 7]`.
- The function will return `4`.

---


# Code
```java []
class Solution {
    public int countPrimes(int n) {
        //int count =0;
        if (n <= 2) {
            return 0;  
        }
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) {
                count++;
            }
        }
        return count;
    }

    

    }

```

``` python3 []
class Solution:
    def countPrimes(self, n: int) -> int:
        if n <= 2:
            return 0
        isPrime = [True] * n
        isPrime[0] = isPrime[1] = False  
        for i in range(2, int(n**0.5) + 1):
            if isPrime[i]: 
                for j in range(i * i, n, i):  
                    isPrime[j] = False
        return sum(isPrime)

```
