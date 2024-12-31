import pandas as pd

def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    emp = pd.DataFrame(employee)
    dept = pd.DataFrame(department)
    merged=pd.merge(employee, department, left_on='departmentId', right_on='id', how='left')
    merged= merged.rename(columns={'name_x': 'Employee', 'name_y': 'Department', 'salary': 'Salary'})[['Department', 'Employee', 'Salary']]
    result=merged[merged['Salary'] == merged.groupby('Department')['Salary'].transform(max)]
    return result