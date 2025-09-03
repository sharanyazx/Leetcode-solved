-- Last updated: 9/3/2025, 10:46:44 AM
# Write your MySQL query statement below
select teacher_id, count(distinct subject_id) as cnt
from Teacher
group by teacher_id