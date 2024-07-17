WITH TopSalaries AS (
    SELECT 
        departmentId, 
        salary,
        DENSE_RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) as salary_rank
    FROM 
        Employee
    GROUP BY 
        departmentId, salary
)
SELECT 
    D.name AS Department, 
    E.name AS Employee, 
    E.salary AS Salary
FROM 
    Employee E
JOIN 
    Department D ON E.departmentId = D.id
JOIN 
    TopSalaries TS ON E.salary = TS.salary AND E.departmentId = TS.departmentId
WHERE 
    TS.salary_rank <= 3;