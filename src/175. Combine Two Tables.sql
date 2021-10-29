-- https://leetcode.com/problems/combine-two-tables/
-- 简单的left join

select FirstName, LastName, City, State
from Person a left join Address b
on a.PersonId = b.PersonId;