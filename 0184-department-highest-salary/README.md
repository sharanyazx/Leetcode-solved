<h2><a href="https://leetcode.com/problems/department-highest-salary">184. Department Highest Salary</a></h2><h3>Medium</h3><hr><p>Table: <code>Employee</code></p>

<pre>
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| id           | int     |
| name         | varchar |
| salary       | int     |
| departmentId | int     |
+--------------+---------+
id is the primary key (column with unique values) for this table.
departmentId is a foreign key (reference columns) of the ID from the <code>Department </code>table.
Each row of this table indicates the ID, name, and salary of an employee. It also contains the ID of their department.
</pre>

<p>&nbsp;</p>

<p>Table: <code>Department</code></p>

<pre>
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
+-------------+---------+
id is the primary key (column with unique values) for this table. It is guaranteed that department name is not <code>NULL.</code>
Each row of this table indicates the ID of a department and its name.
</pre>

<p>&nbsp;</p>

<p>Write a solution to find employees who have the highest salary in each of the departments.</p>

<p>Return the result table in <strong>any order</strong>.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Employee table:
+----+-------+--------+--------------+
| id | name  | salary | departmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Jim   | 90000  | 1            |
| 3  | Henry | 80000  | 2            |
| 4  | Sam   | 60000  | 2            |
| 5  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
Department table:
+----+-------+
| id | name  |
+----+-------+
| 1  | IT    |
| 2  | Sales |
+----+-------+
<strong>Output:</strong> 
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Jim      | 90000  |
| Sales      | Henry    | 80000  |
| IT         | Max      | 90000  |
+------------+----------+--------+
  
<strong>Explanation:</strong> Max and Jim both have the highest salary in the IT department and Henry has the highest salary in the Sales department.
</pre>
This MySQL query identifies employees with the highest salary in each department. Here's a step-by-step explanation of the query:

# SQL Implementation

### Query Breakdown:

```sql
SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM Employee e
JOIN Department d ON e.departmentId = d.id
WHERE e.salary = (
    SELECT MAX(salary) 
    FROM Employee 
    WHERE departmentId = e.departmentId
);
```

#### 1. **FROM Clause**:
```sql
FROM Employee e
```
- The query starts by selecting the `Employee` table (`e` is its alias for shorthand usage).

---

#### 2. **JOIN Clause**:
```sql
JOIN Department d ON e.departmentId = d.id
```
- Performs an **inner join** between the `Employee` table (`e`) and the `Department` table (`d`).
- The `ON` condition specifies that `e.departmentId` in the `Employee` table matches `d.id` in the `Department` table.

---

#### 3. **WHERE Clause**:
```sql
WHERE e.salary = (
    SELECT MAX(salary) 
    FROM Employee 
    WHERE departmentId = e.departmentId
);
```
- Filters rows to include only those where the employee's `salary` equals the maximum salary in their department.
- This is achieved using a **correlated subquery**:

  ##### Subquery:
  ```sql
  SELECT MAX(salary)
  FROM Employee
  WHERE departmentId = e.departmentId
  ```
  - For each row in the `Employee` table (`e`), this subquery:
    - Filters rows in the `Employee` table where `departmentId` matches the current `e.departmentId`.
    - Finds the maximum salary for that department.

  - The result of the subquery is then compared with `e.salary` in the outer query.

---

#### 4. **SELECT Clause**:
```sql
SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
```
- Retrieves:
  - `d.name` → Renamed as `Department` (department name).
  - `e.name` → Renamed as `Employee` (employee name).
  - `e.salary` → Renamed as `Salary` (employee salary).

---

### Example Input:

#### Employee Table:
| id | name  | salary | departmentId |
|----|-------|--------|--------------|
| 1  | Joe   | 70000  | 1            |
| 2  | Jim   | 90000  | 1            |
| 3  | Henry | 80000  | 2            |
| 4  | Sam   | 60000  | 2            |
| 5  | Max   | 90000  | 1            |

#### Department Table:
| id | name  |
|----|-------|
| 1  | IT    |
| 2  | Sales |

---

### Query Execution:

1. **Join Employee and Department Tables**:
   | Department | Employee | Salary | departmentId |
   |------------|----------|--------|--------------|
   | IT         | Joe      | 70000  | 1            |
   | IT         | Jim      | 90000  | 1            |
   | Sales      | Henry    | 80000  | 2            |
   | Sales      | Sam      | 60000  | 2            |
   | IT         | Max      | 90000  | 1            |

2. **Find Maximum Salary per Department**:
   - For departmentId = 1 (IT): MAX(salary) = 90000.
   - For departmentId = 2 (Sales): MAX(salary) = 80000.

3. **Filter Rows Matching Maximum Salary**:
   | Department | Employee | Salary |
   |------------|----------|--------|
   | IT         | Jim      | 90000  |
   | IT         | Max      | 90000  |
   | Sales      | Henry    | 80000  |

---

### Output:

| Department | Employee | Salary |
|------------|----------|--------|
| IT         | Jim      | 90000  |
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |

---

### Key Points:
1. **Correlated Subquery**:
   - The subquery is dependent on the outer query.
   - For each row in the outer query, it calculates the maximum salary for the corresponding department.

2. **Performance**:
   - This query can be computationally expensive for large datasets because the subquery runs for every row in the outer query.
   - To optimize, consider using **window functions** if supported by the database.


# Pandas Implementation



### Function Declaration

```python
def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
```
- **Function Input**:
  - `employee`: A Pandas DataFrame containing the `Employee` table.
  - `department`: A Pandas DataFrame containing the `Department` table.
- **Function Output**: A Pandas DataFrame with columns `Department`, `Employee`, and `Salary`, showing employees with the highest salary in their department.

---

### Steps in the Function

1. **Initialize DataFrames (Optional)**:
   ```python
   emp = pd.DataFrame(employee)
   dept = pd.DataFrame(department)
   ```
   - Converts the input `employee` and `department` data into Pandas DataFrames.
   - This step ensures compatibility but is redundant since the input is already a DataFrame.

---

2. **Merge Tables**:
   ```python
   merged = pd.merge(employee, department, left_on='departmentId', right_on='id', how='left')
   ```
   - Merges the `employee` and `department` tables:
     - **`left_on='departmentId'`**: Matches `departmentId` from the `Employee` table.
     - **`right_on='id'`**: Matches `id` from the `Department` table.
     - **`how='left'`**: Ensures all rows in the `Employee` table are preserved, even if no matching department exists.
   - The resulting `merged` DataFrame includes columns from both tables.

---

3. **Rename and Select Columns**:
   ```python
   merged = merged.rename(columns={'name_x': 'Employee', 'name_y': 'Department', 'salary': 'Salary'})[['Department', 'Employee', 'Salary']]
   ```
   - Renames columns for clarity:
     - `'name_x'` → `'Employee'`: Employee name.
     - `'name_y'` → `'Department'`: Department name.
     - `'salary'` → `'Salary'`: Employee salary.
   - Selects only relevant columns: `Department`, `Employee`, and `Salary`.

---

4. **Group by Department and Find Maximum Salary**:
   ```python
   merged['Salary'] == merged.groupby('Department')['Salary'].transform(max)
   ```
   - **`groupby('Department')['Salary']`**: Groups the data by `Department` and accesses the `Salary` column.
   - **`.transform(max)`**: Computes the maximum salary for each department and broadcasts it back to all rows within the group.
   - Compares each employee's salary to the maximum salary in their department.

---

5. **Filter Rows with Maximum Salary**:
   ```python
   result = merged[merged['Salary'] == merged.groupby('Department')['Salary'].transform(max)]
   ```
   - Keeps only rows where the employee's salary matches the maximum salary in their department.

---

6. **Return the Result**:
   ```python
   return result
   ```
   - The final `result` DataFrame contains:
     - `Department`: Department name.
     - `Employee`: Employee name.
     - `Salary`: Employee's salary (highest in the department).

---

### Example Walkthrough

#### Input:

**Employee Table**:
| id | name  | salary | departmentId |
|----|-------|--------|--------------|
| 1  | Joe   | 70000  | 1            |
| 2  | Jim   | 90000  | 1            |
| 3  | Henry | 80000  | 2            |
| 4  | Sam   | 60000  | 2            |
| 5  | Max   | 90000  | 1            |

**Department Table**:
| id | name  |
|----|-------|
| 1  | IT    |
| 2  | Sales |

---

#### Process:

1. **Merged DataFrame**:
| Department | Employee | Salary |
|------------|----------|--------|
| IT         | Joe      | 70000  |
| IT         | Jim      | 90000  |
| Sales      | Henry    | 80000  |
| Sales      | Sam      | 60000  |
| IT         | Max      | 90000  |

2. **Maximum Salary per Department**:
   - IT: 90000
   - Sales: 80000

3. **Filtered DataFrame**:
| Department | Employee | Salary |
|------------|----------|--------|
| IT         | Jim      | 90000  |
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |

---

#### Output:

| Department | Employee | Salary |
|------------|----------|--------|
| IT         | Jim      | 90000  |
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |

---



# Code
```pythondata []
import pandas as pd

def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    emp = pd.DataFrame(employee)
    dept = pd.DataFrame(department)
    merged=pd.merge(employee, department, left_on='departmentId', right_on='id', how='left')
    merged= merged.rename(columns={'name_x': 'Employee', 'name_y': 'Department', 'salary': 'Salary'})[['Department', 'Employee', 'Salary']]
    result=merged[merged['Salary'] == merged.groupby('Department')['Salary'].transform(max)]
    return result
```
