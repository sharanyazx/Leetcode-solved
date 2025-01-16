# Write your MySQL query statement below
select distinct sp.name
from salesperson sp
where sp.sales_id not in (
    select distinct o.sales_id
    from orders o
    join company c
    on o.com_id = c.com_id
    where c.state = 'ca'
);
