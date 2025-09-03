-- Last updated: 9/3/2025, 10:47:48 AM
# Write your MySQL query statement below
SELECT product_name,sum(unit) AS unit 
FROM Products,Orders 
WHERE Products.product_id=Orders.product_id AND order_date BETWEEN '2020-02-01' AND '2020-02-29' 
GROUP BY product_name 
HAVING sum(unit)>=100;