-- Last updated: 9/3/2025, 10:47:31 AM
SELECT * FROM Users
WHERE mail REGEXP '^[A-Za-z][A-Za-z0-9_\.\-]*@leetcode(\\?com)?\\.com$';