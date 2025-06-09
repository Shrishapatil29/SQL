use demo1;

create table employee(eid int, ename varchar(20),salary int, hiredate date, dept varchar(20));

INSERT INTO employee VALUES 
(1, 'Shrisha', 12000, '2020-02-12', 'Software developer'),
(2, 'Sourabh', 20000, '2020-05-23', 'Tester'),
(3, 'Abhi', 30000, '2018-10-09', 'Designer'),
(4, 'Sakshi', 25000, '2021-11-09', 'Software developer'),
(5, 'Allen', 40000, '2022-02-12', 'Tester'),
(6, 'Blark', 70000, '2023-05-09', 'Software developer'),
(7, 'Alice', 55000, '2025-08-13', 'Tester'),
(8, 'Sou', 65000, '2023-05-13', 'Software developer');

select * from employee;

-- 1)Select employees where salary is between 30,000 and 70,000.

select ename,salary 
from employee
where salary between 30000 and 70000;


-- 2)Select name and salary of employees who joined after 2020.

select ename,salary,hiredate
from employee
where year(hiredate)>2020;

-- 3)Find the employee with the highest salary.
select max(salary) as salary
from employee;

-- 4)Count number of employees in each department.
select count(*)
from employee
group by dept;

-- 5)Select name as Employee_Name from the Employee table.
select ename as Employee_name
from employee;

-- 6)Display employee names as Full Name using column alias.
select ename as FullName
from employee;


