use emp;
create table Emp(eid int, ename varchar(20), salary int, deptno int);
insert into Emp values(1,"shrisha",1000,10),(2,"sourabh",2000,20),(3,"abhishek",3000,30),
(4,"shrisha",2400,30),(5,"akshu",4000,40),(6,"shrisha",1000,10),(7,"sourabh",5000,40),(8,"abhishek",3000,20);
select * from emp;

select ename,salary
from emp
group by salary; 

-- waqt avgv salary needed to pay all employee in each dept excluding the employee of dept no 20
SELECT deptno, AVG(salary) AS avg_salary
FROM emp
WHERE deptno <> 20
GROUP BY deptno;

-- waqt numbers of times salasries present in emp table
SELECT salary, COUNT(*) AS frequency
FROM emp
GROUP BY salary;

-- waqt name that are repeated using having cluase
SELECT ename, COUNT(*) AS count
FROM emp
GROUP BY ename
HAVING COUNT(*) > 1;

-- waqt job and salary of each job, if the total salary of each job is greater than 1000

SELECT deptno, SUM(salary) AS total_salary
FROM emp
GROUP BY deptno
HAVING SUM(salary) > 1000;


-- waqt name and hiredate of employee if the  employee was hired after jones.

CREATE TABLE dept (
    deptno INT PRIMARY KEY,
    dname VARCHAR(50),
    location VARCHAR(50)
);

INSERT INTO dept (deptno, dname, location) VALUES
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'CLERK', 'CHICAGO'),
(40, 'OPERATIONS', 'BOSTON');


CREATE TABLE emp1 (
    empno INT PRIMARY KEY,
    ename VARCHAR(50),
    job VARCHAR(50),
    sal INT,
    hiredate DATE,
    deptno INT,
    FOREIGN KEY (deptno) REFERENCES dept(deptno)
);
drop table emp1;

INSERT INTO emp1 (empno, ename, job, sal, hiredate, deptno) VALUES
(101, 'SMITH', 'CLERK', 800, '2023-01-10', 20),
(102, 'ALLEN', 'SALESMAN', 1600, '2022-12-05', 30),
(103, 'WARD', 'SALESMAN', 1250, '2023-02-15', 30),
(104, 'JONES', 'MANAGER', 2975, '2021-06-01', 20),
(105, 'MARTIN', 'SALESMAN', 1250, '2023-03-18', 30),
(106, 'BLAKE', 'MANAGER', 2850, '2020-11-10', 30),
(107, 'CLARK', 'MANAGER', 2450, '2022-07-20', 10),
(108, 'SCOTT', 'ANALYST', 3000, '2023-04-25', 20);

select * from emp1;
select * from dept;


select hiredate,ename from emp1 where hiredate >(select hiredate
from emp1
where ename="JONES");

-- waqt details of all employee as working as clerk in same dept as CLARK

select job,ename from emp1 where job="CLERK"=(select job from emp1 where ename="CLARK");

