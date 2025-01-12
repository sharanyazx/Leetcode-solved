<h2><a href="https://leetcode.com/problems/convert-the-temperature">Convert the Temperature</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>You are given a non-negative floating point number rounded to two decimal places <code>celsius</code>, that denotes the <strong>temperature in Celsius</strong>.</p>

<p>You should convert Celsius into <strong>Kelvin</strong> and <strong>Fahrenheit</strong> and return it as an array <code>ans = [kelvin, fahrenheit]</code>.</p>

<p>Return <em>the array <code>ans</code>. </em>Answers within <code>10<sup>-5</sup></code> of the actual answer will be accepted.</p>

<p><strong>Note that:</strong></p>

<ul>
	<li><code>Kelvin = Celsius + 273.15</code></li>
	<li><code>Fahrenheit = Celsius * 1.80 + 32.00</code></li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> celsius = 36.50
<strong>Output:</strong> [309.65000,97.70000]
<strong>Explanation:</strong> Temperature at 36.50 Celsius converted in Kelvin is 309.65 and converted in Fahrenheit is 97.70.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> celsius = 122.11
<strong>Output:</strong> [395.26000,251.79800]
<strong>Explanation:</strong> Temperature at 122.11 Celsius converted in Kelvin is 395.26 and converted in Fahrenheit is 251.798.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= celsius &lt;= 1000</code></li>
</ul>
### Problem Explanation:

You are given a temperature value in **Celsius** (denoted by `celsius`). The goal is to convert this temperature into two other temperature scales: **Kelvin** and **Fahrenheit**.

#### Conversion Formulas:

1. **Kelvin (K)** = Celsius (°C) + 273.15
2. **Fahrenheit (°F)** = Celsius (°C) * 1.80 + 32.00

### Task:

- **Input**: A non-negative floating-point number `celsius` (rounded to two decimal places).
- **Output**: An array of two numbers:
  - The first value is the temperature in **Kelvin**.
  - The second value is the temperature in **Fahrenheit**.

The results should be returned with precision up to **5 decimal places**.

### Examples:

#### Example 1:

**Input**: `celsius = 36.50`

**Output**: `[309.65000, 97.70000]`

- **Kelvin** = 36.50 + 273.15 = 309.65
- **Fahrenheit** = 36.50 * 1.80 + 32.00 = 97.70

**Explanation**:  
At 36.50°C, the corresponding temperatures are 309.65 Kelvin and 97.70 Fahrenheit.

#### Example 2:

**Input**: `celsius = 122.11`

**Output**: `[395.26000, 251.79800]`

- **Kelvin** = 122.11 + 273.15 = 395.26
- **Fahrenheit** = 122.11 * 1.80 + 32.00 = 251.798

**Explanation**:  
At 122.11°C, the corresponding temperatures are 395.26 Kelvin and 251.798 Fahrenheit.

### Constraints:

- `0 <= celsius <= 1000`
- The temperature value in Celsius will always be a non-negative floating point number.

### Python Solution:

```python
class Solution:
    def convertTemperature(self, celsius: float):
        # Convert Celsius to Kelvin
        kelvin = celsius + 273.15
        # Convert Celsius to Fahrenheit
        fahrenheit = celsius * 1.80 + 32.00
        # Return the result as a list
        return [round(kelvin, 5), round(fahrenheit, 5)]
```

### Explanation of Python Code:

1. **Input**: The function receives a float `celsius`.
2. **Conversion**:
   - First, the Celsius value is converted to **Kelvin** by adding 273.15.
   - Then, the Celsius value is converted to **Fahrenheit** using the formula `C * 1.80 + 32.00`.
3. **Output**: The results are returned as a list with two values. We use `round()` to ensure that both values are rounded to 5 decimal places as required.
   
### Java Solution:

```java
class Solution {
    public double[] convertTemperature(double celsius) {
        // Convert Celsius to Kelvin
        double kelvin = celsius + 273.15;
        // Convert Celsius to Fahrenheit
        double fahrenheit = celsius * 1.80 + 32.00;
        // Return the result as an array
        return new double[]{Math.round(kelvin * 100000.0) / 100000.0, Math.round(fahrenheit * 100000.0) / 100000.0};
    }
}
```

### Explanation of Java Code:

1. **Input**: The method receives a double `celsius`.
2. **Conversion**:
   - First, the Celsius value is converted to **Kelvin** by adding 273.15.
   - Then, the Celsius value is converted to **Fahrenheit** using the formula `C * 1.80 + 32.00`.
3. **Output**: The results are returned as a `double[]` array with two values. We use `Math.round()` to round the values to 5 decimal places.

### Time Complexity:

- The time complexity for both solutions is **O(1)**, as we are performing constant-time arithmetic operations and no loops are involved.

### Space Complexity:

- The space complexity for both solutions is **O(1)**, as we are using a fixed amount of space to store the results, regardless of the size of the input.

### Summary:

This problem is focused on simple arithmetic conversions from Celsius to Kelvin and Fahrenheit. The approach involves applying the respective formulas and returning the results in a precise format. Both Python and Java solutions are efficient and handle the conversion in constant time and space.
# Code
```java []
class Solution {
    public double[] convertTemperature(double celsius) {
       double kelvin= celsius + 273.15;
       double  fahrenheit=celsius * 1.80 + 32.00;
       double [] result = {Math.round(kelvin * 100000.0) / 100000.0, Math.round(fahrenheit * 100000.0) / 100000.0};
      return result;

    
    }
}
```

```python3 []
class Solution:
    def convertTemperature(self, celsius: float) -> List[float]:
         kelvin= celsius + 273.15;
         fahrenheit=celsius * 1.80 + 32.00;
         return [round(kelvin, 5), round(fahrenheit, 5)]
        
```
