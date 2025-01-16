# Write your MySQL query statement below
SELECT c1.end_date AS visited_on, SUM(amount) AS amount, ROUND(SUM(amount)/7,2) AS average_amount 
FROM Customer c JOIN 
(SELECT DISTINCT c.visited_on AS start_date ,c1.visited_on AS end_date 
FROM Customer c JOIN Customer c1 
WHERE c1.visited_on = DATE_ADD(c.visited_on, INTERVAL 6 DAY)) c1 
WHERE c.visited_on BETWEEN c1.start_date AND c1.end_date GROUP BY c1.end_date;