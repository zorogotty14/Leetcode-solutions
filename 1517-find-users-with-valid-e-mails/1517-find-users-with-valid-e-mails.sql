SELECT 
    user_id,
    name,
    mail
FROM 
    Users
WHERE 
    mail LIKE '%@leetcode.com' -- Domain is @leetcode.com
    AND LEFT(mail, 1) REGEXP '^[a-zA-Z]' -- Prefix starts with a letter
    AND mail REGEXP '^[a-zA-Z][a-zA-Z0-9._-]*@leetcode\\.com$'; -- Valid characters in the prefix