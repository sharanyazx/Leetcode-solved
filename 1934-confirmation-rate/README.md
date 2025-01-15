<h2><a href="https://leetcode.com/problems/confirmation-rate/?envType=study-plan-v2&envId=top-sql-50">1934. Confirmation Rate</a></h2><h3>Medium</h3><hr><p>Table: <code>Signups</code></p>

<pre>
+----------------+----------+
| Column Name    | Type     |
+----------------+----------+
| user_id        | int      |
| time_stamp     | datetime |
+----------------+----------+
user_id is the column of unique values for this table.
Each row contains information about the signup time for the user with ID user_id.
</pre>

<p>&nbsp;</p>

<p>Table: <code>Confirmations</code></p>

<pre>
+----------------+----------+
| Column Name    | Type     |
+----------------+----------+
| user_id        | int      |
| time_stamp     | datetime |
| action         | ENUM     |
+----------------+----------+
(user_id, time_stamp) is the primary key (combination of columns with unique values) for this table.
user_id is a foreign key (reference column) to the Signups table.
action is an ENUM (category) of the type (&#39;confirmed&#39;, &#39;timeout&#39;)
Each row of this table indicates that the user with ID user_id requested a confirmation message at time_stamp and that confirmation message was either confirmed (&#39;confirmed&#39;) or expired without confirming (&#39;timeout&#39;).
</pre>

<p>&nbsp;</p>

<p>The <strong>confirmation rate</strong> of a user is the number of <code>&#39;confirmed&#39;</code> messages divided by the total number of requested confirmation messages. The confirmation rate of a user that did not request any confirmation messages is <code>0</code>. Round the confirmation rate to <strong>two decimal</strong> places.</p>

<p>Write a solution to find the <strong>confirmation rate</strong> of each user.</p>

<p>Return the result table in <strong>any order</strong>.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Signups table:
+---------+---------------------+
| user_id | time_stamp          |
+---------+---------------------+
| 3       | 2020-03-21 10:16:13 |
| 7       | 2020-01-04 13:57:59 |
| 2       | 2020-07-29 23:09:44 |
| 6       | 2020-12-09 10:39:37 |
+---------+---------------------+
Confirmations table:
+---------+---------------------+-----------+
| user_id | time_stamp          | action    |
+---------+---------------------+-----------+
| 3       | 2021-01-06 03:30:46 | timeout   |
| 3       | 2021-07-14 14:00:00 | timeout   |
| 7       | 2021-06-12 11:57:29 | confirmed |
| 7       | 2021-06-13 12:58:28 | confirmed |
| 7       | 2021-06-14 13:59:27 | confirmed |
| 2       | 2021-01-22 00:00:00 | confirmed |
| 2       | 2021-02-28 23:59:59 | timeout   |
+---------+---------------------+-----------+
<strong>Output:</strong> 
+---------+-------------------+
| user_id | confirmation_rate |
+---------+-------------------+
| 6       | 0.00              |
| 3       | 0.00              |
| 7       | 1.00              |
| 2       | 0.50              |
+---------+-------------------+
<strong>Explanation:</strong> 
User 6 did not request any confirmation messages. The confirmation rate is 0.
User 3 made 2 requests and both timed out. The confirmation rate is 0.
User 7 made 3 requests and all were confirmed. The confirmation rate is 1.
User 2 made 2 requests where one was confirmed and the other timed out. The confirmation rate is 1 / 2 = 0.5.
</pre>



### **Problem Explanation:**

We are given two tables, `Signups` and `Confirmations`, and we need to calculate the **confirmation rate** for each user.

- **Signups table** contains the user IDs and their signup times.
- **Confirmations table** contains the user IDs, timestamps, and the action performed, which can either be "confirmed" or "timeout".

The **confirmation rate** for a user is calculated as:
The confirmation rate formula in a standard format is:

*confirmation rate* = **Number of confirmed requests / Total number of requests**


Where:
- **Number of confirmed requests** refers to the count of requests that were successfully confirmed (i.e., the action was "confirmed").
- **Total number of requests** refers to the total number of requests made, including both confirmed and timed out requests.

If no requests were made, the confirmation rate is considered to be 0.

If a user didn't request any confirmation, the confirmation rate should be `0`.

---

### **Step-by-Step Breakdown of the SQL Query:**

```sql
select s.user_id,
coalesce(round(sum(case when c.action = 'confirmed' then 1 else 0 end) / 
count(c.action), 2), 0) as confirmation_rate
from signups s
left join confirmations c on s.user_id = c.user_id
group by s.user_id;
```

#### **1. `select s.user_id, ...`**
- **Purpose**: Select the `user_id` from the `signups` table.
- **Explanation**: We are interested in calculating the confirmation rate for each user, so we need the user IDs.

#### **2. `coalesce(round(..., 2), 0) as confirmation_rate`**
- **Purpose**: To calculate the confirmation rate for each user and round it to two decimal places.
- **Explanation**: 
  - **`round(..., 2)`**: Rounds the result to two decimal places.
  - **`coalesce(..., 0)`**: Ensures that if the result of the division is `NULL` (i.e., the user didn't make any confirmation requests), we return `0` instead of `NULL`.
  - **Confirmation Rate Formula**: 
    \[
    \text{confirmation rate} = \frac{\text{number of confirmed requests}}{\text{total number of requests}}
    \]

#### **3. `sum(case when c.action = 'confirmed' then 1 else 0 end)`**
- **Purpose**: Calculate the total number of "confirmed" requests for each user.
- **Explanation**: 
  - We use a **`CASE`** statement to check if the `action` in the `confirmations` table is "confirmed". 
  - If it is "confirmed", return `1`, otherwise return `0`.
  - **`sum(...)`**: Adds up the `1`s to count the number of confirmed requests for each user.

#### **4. `count(c.action)`**
- **Purpose**: Calculate the total number of confirmation requests (whether "confirmed" or "timeout") for each user.
- **Explanation**: 
  - **`count(c.action)`** counts all the actions (both "confirmed" and "timeout") associated with each user. 
  - If a user didn't request any confirmation, this will be `0`.

#### **5. `from signups s`**
- **Purpose**: Define the source of the `signups` table, alias it as `s` for convenience.
- **Explanation**: We need the `signups` table to get the user IDs.

#### **6. `left join confirmations c on s.user_id = c.user_id`**
- **Purpose**: Join the `signups` table with the `confirmations` table based on the `user_id`.
- **Explanation**: 
  - **`LEFT JOIN`**: We use a left join to ensure that all users from `signups` are included in the result, even if they don't have any confirmation actions in the `confirmations` table.
  - If a user has no matching row in the `confirmations` table, the `confirmation_rate` will be `0` due to the `coalesce()` function.

#### **7. `group by s.user_id`**
- **Purpose**: Group the results by `user_id`.
- **Explanation**: We calculate the confirmation rate for each user, so we group by `user_id` to get one row per user.

---

### **Example Walkthrough:**

Given the sample data:

**Signups Table:**
| user_id | time_stamp          |
|---------|---------------------|
| 3       | 2020-03-21 10:16:13 |
| 7       | 2020-01-04 13:57:59 |
| 2       | 2020-07-29 23:09:44 |
| 6       | 2020-12-09 10:39:37 |

**Confirmations Table:**
| user_id | time_stamp          | action    |
|---------|---------------------|-----------|
| 3       | 2021-01-06 03:30:46 | timeout   |
| 3       | 2021-07-14 14:00:00 | timeout   |
| 7       | 2021-06-12 11:57:29 | confirmed |
| 7       | 2021-06-13 12:58:28 | confirmed |
| 7       | 2021-06-14 13:59:27 | confirmed |
| 2       | 2021-01-22 00:00:00 | confirmed |
| 2       | 2021-02-28 23:59:59 | timeout   |

**Step-by-step calculation:**

1. **User 6**:
   - No requests in `confirmations` table.
   - **Total requests = 0** → Confirmation rate = `0.00`.

2. **User 3**:
   - 2 requests: both timed out.
   - **Total requests = 2**, **Confirmed = 0** → Confirmation rate = `0 / 2 = 0.00`.

3. **User 7**:
   - 3 requests: all confirmed.
   - **Total requests = 3**, **Confirmed = 3** → Confirmation rate = `3 / 3 = 1.00`.

4. **User 2**:
   - 2 requests: 1 confirmed and 1 timed out.
   - **Total requests = 2**, **Confirmed = 1** → Confirmation rate = `1 / 2 = 0.50`.

### **Output:**
| user_id | confirmation_rate |
|---------|-------------------|
| 6       | 0.00              |
| 3       | 0.00              |
| 7       | 1.00              |
| 2       | 0.50              |

---

### **Key Points:**

- The query correctly handles users with no confirmation requests (`user_id = 6`).
- The query calculates the confirmation rate for each user based on the number of "confirmed" actions.
- If the user has no matching rows in the `confirmations` table, the rate defaults to `0`.

---


# Code
```mysql []
# Write your MySQL query statement below
select s.user_id,
coalesce(round(sum(case when c.action = 'confirmed' then 1 else 0 end) / 
count(c.action), 2), 0) as confirmation_rate
from  signups s
left join confirmations c on s.user_id = c.user_id
group by s.user_id;

```
