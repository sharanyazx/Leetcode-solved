-- Last updated: 9/3/2025, 10:48:19 AM
# Write your MySQL query statement below
select customer_id
 from Customer 
 group by customer_id
having count(distinct product_key) = (select count(product_key) from Product)