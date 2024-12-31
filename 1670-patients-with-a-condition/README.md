<h2><a href="https://leetcode.com/problems/patients-with-a-condition">Patients With a Condition</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Table: <code>Patients</code></p>

<pre>
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| patient_id   | int     |
| patient_name | varchar |
| conditions   | varchar |
+--------------+---------+
patient_id is the primary key (column with unique values) for this table.
&#39;conditions&#39; contains 0 or more code separated by spaces. 
This table contains information of the patients in the hospital.
</pre>

<p>&nbsp;</p>

<p>Write a solution to find the patient_id, patient_name, and conditions of the patients who have Type I Diabetes. Type I Diabetes always starts with <code>DIAB1</code> prefix.</p>

<p>Return the result table in <strong>any order</strong>.</p>

<p>The&nbsp;result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Patients table:
+------------+--------------+--------------+
| patient_id | patient_name | conditions   |
+------------+--------------+--------------+
| 1          | Daniel       | YFEV COUGH   |
| 2          | Alice        |              |
| 3          | Bob          | DIAB100 MYOP |
| 4          | George       | ACNE DIAB100 |
| 5          | Alain        | DIAB201      |
+------------+--------------+--------------+
<strong>Output:</strong> 
+------------+--------------+--------------+
| patient_id | patient_name | conditions   |
+------------+--------------+--------------+
| 3          | Bob          | DIAB100 MYOP |
| 4          | George       | ACNE DIAB100 | 
+------------+--------------+--------------+
<strong>Explanation:</strong> Bob and George both have a condition that starts with DIAB1.
</pre>


```markdown
### Code: Find Patients with Type I Diabetes

```python
import pandas as pd

def find_patients(patients: pd.DataFrame) -> pd.DataFrame:
    # Filter rows where the 'conditions' column contains the prefix 'DIAB1'
    return patients.loc[patients['conditions'].str.contains(r'(^| )DIAB1', na=False)]
```

---

### Explanation:

#### 1. **Input and Expected Columns:**
   - The function takes a `patients` DataFrame as input.
   - The input should include:
     - `patient_id` (unique ID for each patient)
     - `patient_name` (name of the patient)
     - `conditions` (space-separated string of condition codes).

#### 2. **Regex for Filtering:**
   ```python
   r'(^| )DIAB1'
   ```
   - **`^`**: Matches the start of the string.
   - **`|`**: Acts as an OR operator.
   - **` `**: Matches a space.
   - **`DIAB1`**: Matches the prefix for Type I Diabetes conditions.
   - Together, `(^| )DIAB1` matches either:
     - The string starting with `DIAB1`.
     - A space followed by `DIAB1`.

#### 3. **Filtering with `.loc` and `.str.contains`:**
   ```python
   patients.loc[patients['conditions'].str.contains(r'(^| )DIAB1', na=False)]
   ```
   - **`.loc[]`:** Filters rows based on the condition.
   - **`.str.contains()`**:
     - Checks whether the `conditions` column matches the regex.
     - **`na=False`**: Handles missing (NaN) values by treating them as `False`.

#### 4. **Returning the Result:**
   - The filtered rows where the `conditions` column contains `DIAB1` are returned as a DataFrame.

---

### Example Walkthrough:

#### Input Data:
```python
data = {
    'patient_id': [1, 2, 3, 4, 5],
    'patient_name': ['Daniel', 'Alice', 'Bob', 'George', 'Alain'],
    'conditions': ['YFEV COUGH', '', 'DIAB100 MYOP', 'ACNE DIAB100', 'DIAB201']
}
patients = pd.DataFrame(data)
```

#### Function Call:
```python
result = find_patients(patients)
print(result)
```

#### Output:
| patient_id | patient_name | conditions   |
|------------|--------------|--------------|
| 3          | Bob          | DIAB100 MYOP |
| 4          | George       | ACNE DIAB100 |

---

#### Explanations for Exclusions:
1. **Row 1 (Daniel):** Does not contain `DIAB1`.
2. **Row 2 (Alice):** Empty `conditions` field.
3. **Row 5 (Alain):** Condition `DIAB201` does not match the `DIAB1` prefix.

---

### Complexity:
- **Time Complexity:** \(O(n . m)\), where:
  - \(n\): Number of rows in the DataFrame.
  - \(m\): Average length of the `conditions` string.
- **Space Complexity:** \(O(n)\) for the filtered DataFrame.

This approach efficiently filters patients based on the specified condition prefix.
```
