/*The Employee table holds all employees.
The employee table has three columns:
Employee Id, Company Name, and Salary.
+-----+------------+--------+
|Id   | Company    | Salary |
+-----+------------+--------+
|1    | A          | 2341   |
|2    | A          | 341    |
|3    | A          | 15     |
|4    | A          | 15314  |
|5    | A          | 451    |
|6    | A          | 513    |
|7    | B          | 15     |
|8    | B          | 13     |
|9    | B          | 1154   |
|10   | B          | 1345   |
|11   | B          | 1221   |
|12   | B          | 234    |
|13   | C          | 2345   |
|14   | C          | 2645   |
|15   | C          | 2645   |
|16   | C          | 2652   |
|17   | C          | 65     |
+-----+------------+--------+
Write a SQL query to find the median salary of each company. Bonus points if you can solve it without using any built-in SQL functions.

+-----+------------+--------+
|Id   | Company    | Salary |
+-----+------------+--------+
|5    | A          | 451    |
|6    | A          | 513    |
|12   | B          | 234    |
|9    | B          | 1154   |
|14   | C          | 2645   |
+-----+------------+--------+
*/

ANS:
/* Write your T-SQL query statement below */
with cte as (
select Id, Company, Salary, row_number() over (partition by Company order by Salary) as rnk from Employee), mx_rnk as
(select Id, Company, Salary, rnk, max(rnk) over(partition by Company) as max_rnk from cte)

select X.Id, X.Company, X.Salary as Salary from (
select Id, Company, Salary, rnk, max_rnk,
case
when max_rnk % 2 =0 then max_rnk/2
when rnk = floor(max_rnk/2)+1 then floor(max_rnk/2)+1
else 0
end as med_rank1,
case
when max_rnk % 2 =0 then (max_rnk/2)+1
when rnk = floor(max_rnk/2)+1 then floor(max_rnk/2)+1
else 0
end as med_rank2
from mx_rnk) X
where (X.med_rank1=X.rnk OR X.med_rank2=X.rnk)
;