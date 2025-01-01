<h2><a href="https://leetcode.com/problems/managers-with-at-least-5-direct-reports">570. Managers with at Least 5 Direct Reports</a></h2><h3>Medium</h3><hr><p>Table: <code>Employee</code></p>

<pre>
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| department  | varchar |
| managerId   | int     |
+-------------+---------+
id is the primary key (column with unique values) for this table.
Each row of this table indicates the name of an employee, their department, and the id of their manager.
If managerId is null, then the employee does not have a manager.
No employee will be the manager of themself.
</pre>

<p>&nbsp;</p>

<p>Write a solution to find managers with at least <strong>five direct reports</strong>.</p>

<p>Return the result table in <strong>any order</strong>.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Employee table:
+-----+-------+------------+-----------+
| id  | name  | department | managerId |
+-----+-------+------------+-----------+
| 101 | John  | A          | null      |
| 102 | Dan   | A          | 101       |
| 103 | James | A          | 101       |
| 104 | Amy   | A          | 101       |
| 105 | Anne  | A          | 101       |
| 106 | Ron   | B          | 101       |
+-----+-------+------------+-----------+
<strong>Output:</strong> 
+------+
| name |
+------+
| John |
+------+
</pre>
# Solution Explanation

### Input Table: `Employee`

| **id** | **name** | **department** | **managerId** |
|--------|----------|----------------|---------------|
| 101    | John     | A              | NULL          |
| 102    | Dan      | A              | 101           |
| 103    | James    | A              | 101           |
| 104    | Amy      | A              | 101           |
| 105    | Anne     | A              | 101           |
| 106    | Ron      | B              | 101           |

---

### Query:

```sql
SELECT name 
FROM Employee
WHERE id IN (
    SELECT managerId 
    FROM Employee
    GROUP BY managerId
    HAVING COUNT(managerId) >= 5
);
```

---

### Step-by-Step Execution:

#### **1. Inner Query Execution:**

```sql
SELECT managerId 
FROM Employee
GROUP BY managerId
HAVING COUNT(managerId) >= 5;
```

- **Step 1:** Group rows by `managerId`:
  | **managerId** | **Employees Under This Manager** |
  |---------------|----------------------------------|
  | NULL          | [John]                          |
  | 101           | [Dan, James, Amy, Anne, Ron]    |

- **Step 2:** Count the number of employees under each manager:
  | **managerId** | **Count** |
  |---------------|-----------|
  | NULL          | 1         |
  | 101           | 5         |

- **Step 3:** Filter using `HAVING COUNT(managerId) >= 5`:
  - Retain only those `managerId` values where the count of employees is **5 or more**.
  - Result:
    | **managerId** |
    |---------------|
    | 101           |

---

#### **2. Outer Query Execution:**

```sql
SELECT name 
FROM Employee
WHERE id IN (
    SELECT managerId 
    FROM Employee
    GROUP BY managerId
    HAVING COUNT(managerId) >= 5
);
```

- **Step 1:** Retrieve `id` values from the `Employee` table that match the `managerId` returned by the inner query:
  - The inner query returned `managerId = 101`.
  - Check `id` values against this `managerId`.

- **Step 2:** Select the `name` of the employee where `id = 101`:
  | **id** | **name** | **department** | **managerId** |
  |--------|----------|----------------|---------------|
  | 101    | John     | A              | NULL          |

- **Step 3:** Return the `name` column from the matching row.

---

### Output:

| **name** |
|----------|
| John     |

---

### Explanation of Result:

- **John (id = 101)** is the manager with at least **5 direct reports** (`Dan`, `James`, `Amy`, `Anne`, and `Ron`).
- The query correctly identifies and returns John's name as the result.
