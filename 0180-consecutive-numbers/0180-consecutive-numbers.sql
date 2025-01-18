# Write your MySQL query statement below
select distinct l1.num as consecutivenums
from logs l1
join logs l2 on l1.id = l2.id - 1
join logs l3 on l1.id = l3.id - 2
where l1.num = l2.num and l2.num = l3.num;
