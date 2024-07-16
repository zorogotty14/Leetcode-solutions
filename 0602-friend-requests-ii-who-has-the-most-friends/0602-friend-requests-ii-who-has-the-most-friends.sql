# Write your MySQL query statement below
WITH Friends AS (
    SELECT requester_id AS id FROM RequestAccepted
    UNION ALL
    SELECT accepter_id AS id FROM RequestAccepted
),
FriendCounts AS (
    SELECT id, COUNT(*) AS num
    FROM Friends
    GROUP BY id
),
MaxFriendCount AS (
    SELECT MAX(num) AS max_num
    FROM FriendCounts
)
SELECT fc.id, fc.num
FROM FriendCounts fc
JOIN MaxFriendCount mfc ON fc.num = mfc.max_num
ORDER BY fc.id ASC;
