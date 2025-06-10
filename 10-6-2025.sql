use sys;
create table employee(eid int, ename varchar(20),salary int, hiredate date, dept varchar(20));

INSERT INTO employee VALUES 
(1, 'Shrisha', 20000, '2020-02-12', 'Software developer'),
(2, 'Sourabh', 20000, '2020-05-23', 'Tester'),
(3, 'Abhi', 30000, '2018-10-09', 'Designer'),
(4, 'Sakshi', 25000, '2021-11-09', 'Software developer'),
(5, 'Allen', 40000, '2022-02-12', 'Tester'),
(6, 'Blark', 100000, '2023-05-09', 'Software developer'),
(7, 'Alice', 55000, '2025-08-13', 'Tester'),
(8, 'Sou', 65000, '2023-05-13', 'Software developer');

select * from employee;


-- WAQ to find total salary for each department
select sum(salary)
from employee
group by dept;

-- waq to find number of e,ployee in each job role

select dept, count(*)
from employee
group by dept;

-- waq to display average salary by department
select dept, avg(salary) as average_salary
from employee
group by dept;

-- waq to find maximum salary per job type
select max(salary)
from employee
group by dept;

-- list all dept where total salary is more than 100000
select dept
from employee
where salary>=100000;

-- show department having more than 3 employees
SELECT dept, COUNT(*) AS total_employees
FROM Employee
GROUP BY dept
HAVING COUNT(*) = 3;

-- list job roles where average salary is less than 50000
select dept, avg(salary) as avg_salary
from employee
group by dept
having avg(salary)<50000;

-- find department where minimum sal is greater than 30000
select dept, min(salary) as min_sal
from employee
group by dept
having min(salary)>3000;

-- waq to find who earn more than avg salary of all  employee
SELECT *
FROM Employee
WHERE Salary > (
    SELECT AVG(Salary)
    FROM Employee
);

-- Find the name and salary of the employee who earns the maximum salary. 
select * from employee where salary >= (select max(salary)
from employee);

-- Find employees whose salary is greater than the average salary of their department.
select * from employee where salary >(select avg(salary) from employee);


-- WAQ to find 3rd heighest salary.
SELECT DISTINCT salary
FROM employee
ORDER BY salary DESC
LIMIT 1 OFFSET 2;
