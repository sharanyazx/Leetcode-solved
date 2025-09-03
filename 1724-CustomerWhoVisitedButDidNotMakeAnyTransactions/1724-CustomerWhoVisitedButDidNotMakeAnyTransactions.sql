-- Last updated: 9/3/2025, 10:47:30 AM
SELECT customer_id, COUNT(*)  count_no_trans 
FROM Visits  v 
LEFT JOIN Transactions  t 
ON v.visit_id = t.visit_id 
WHERE t.visit_id IS NULL 
GROUP BY customer_id;