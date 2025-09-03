-- Last updated: 9/3/2025, 10:47:41 AM
# Write your MySQL query statement below
select uni.unique_id, emp.name
from employees emp
left join employeeuni as uni
on emp.id=uni.id;