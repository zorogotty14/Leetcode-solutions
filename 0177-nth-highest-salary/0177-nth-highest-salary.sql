CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      SELECT salary
      FROM (
          SELECT DISTINCT salary
          FROM Employee
          ORDER BY salary DESC
      ) AS ranked_salaries
      WHERE (
          SELECT COUNT(DISTINCT salary)
          FROM Employee
          WHERE salary > ranked_salaries.salary
      ) = N - 1
  );
END;