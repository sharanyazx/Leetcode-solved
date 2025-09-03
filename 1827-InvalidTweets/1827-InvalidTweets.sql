-- Last updated: 9/3/2025, 10:47:24 AM
# Write your MySQL query statement below
select tweet_id 
from tweets 
where length(content)>15;