# Write your MySQL query statement below
WITH ChildNodes AS (
    SELECT DISTINCT p_id AS id
    FROM Tree
    WHERE p_id IS NOT NULL
)
SELECT 
    t.id,
    CASE 
        WHEN t.p_id IS NULL THEN 'Root'
        WHEN c.id IS NULL THEN 'Leaf'
        ELSE 'Inner'
    END AS type
FROM Tree t
LEFT JOIN ChildNodes c ON t.id = c.id;
