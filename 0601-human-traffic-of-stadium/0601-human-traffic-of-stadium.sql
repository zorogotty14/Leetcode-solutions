# Write your MySQL query statement below
WITH valid_visits AS (
    SELECT 
        id, visit_date, people,
        ROW_NUMBER() OVER (ORDER BY id) AS row_num
    FROM Stadium
    WHERE people >= 100
),
consecutive_groups AS (
    SELECT 
        id, visit_date, people,
        id - row_num AS group_id
    FROM valid_visits
)
SELECT 
    id, visit_date, people
FROM (
    SELECT 
        id, visit_date, people,
        COUNT(*) OVER (PARTITION BY group_id) AS group_size
    FROM consecutive_groups
) t
WHERE group_size >= 3
ORDER BY id;
