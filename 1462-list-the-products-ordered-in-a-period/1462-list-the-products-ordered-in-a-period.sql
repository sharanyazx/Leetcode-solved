# Write your MySQL query statement below
SELECT product_name,sum(unit) AS unit 
FROM Products,Orders 
WHERE Products.product_id=Orders.product_id AND order_date BETWEEN '2020-02-01' AND '2020-02-29' 
GROUP BY product_name 
HAVING sum(unit)>=100;