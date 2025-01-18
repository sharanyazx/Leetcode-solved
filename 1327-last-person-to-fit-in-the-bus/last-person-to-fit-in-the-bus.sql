# Write your MySQL query statement below
with cumulative_sum as (
    select person_name, sum(weight) over (order by turn) as cumulative_sum
    from queue
)
select person_name
from cumulative_sum
where cumulative_sum <= 1000
order by cumulative_sum desc
limit 1;
