-- Last updated: 9/3/2025, 10:47:29 AM
# Write your MySQL query statement below
select contest_id, round(count(distinct user_id) * 100 /(select count(user_id) from Users) ,2)
 as percentage
from  Register
group by contest_id
order by percentage desc,contest_id