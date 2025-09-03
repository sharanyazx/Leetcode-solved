-- Last updated: 9/3/2025, 10:47:20 AM
# Write your MySQL query statement below
select distinct e1.reports_to as employee_id, e2.name, 
        COUNT(*) as reports_count, ROUND(AVG(e1.age),0) as average_age
from Employees e1
left join Employees e2 on e1.reports_to = e2.employee_id
where e1.reports_to is not null
group by e1.reports_to
order by employee_id asc