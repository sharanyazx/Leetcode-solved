# Write your MySQL query statement below
SELECT person.firstname,person.lastName,Address.city ,Address.state
FROM person
LEFT JOIN Address
ON person.personId  =Address . personId ;