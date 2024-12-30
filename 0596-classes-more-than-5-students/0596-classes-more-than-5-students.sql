# Write your MySQL query statement below
select class 
from courses
group by 1 
having count(*)>=5;
