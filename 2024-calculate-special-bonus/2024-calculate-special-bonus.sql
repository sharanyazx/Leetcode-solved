select employee_id,
        case 
           when employee_id % 2 != 0 and left(name, 1) != 'M' then salary
           else 0
       End AS bonus
from Employees
order by employee_id;
