-- Last updated: 9/3/2025, 10:48:02 AM
# Write your MySQL query statement below
select distinct author_id as id
from Views
where author_id=viewer_id
order by  id asc ;