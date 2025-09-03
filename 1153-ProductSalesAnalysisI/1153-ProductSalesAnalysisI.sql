-- Last updated: 9/3/2025, 10:48:16 AM
# Write your MySQL query statement below
select p.product_name,s.year,s.price
from sales s
inner join product p 
on p.product_id=s.product_id;
