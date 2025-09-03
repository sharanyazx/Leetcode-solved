-- Last updated: 9/3/2025, 10:47:13 AM
# Write your MySQL query statement below
select employee_id, department_id
from employee
where primary_flag = 'y' or employee_id in
    (select employee_id
    from employee
    group by employee_id
    having count(employee_id) = 1);
