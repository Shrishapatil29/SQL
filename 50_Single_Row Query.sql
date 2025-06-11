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



-- 50 Single row query
--  String & Arithmetic Functions
-- 1)UPPER
select ename, upper(ename) as UPPER_NAME from employee;

-- 2)LOWER
select ename, lower(ename) as LOWER_NAME from employee;

-- 3) length --> is used to count letters in word
-- you can give condition or can get length of words from whole table
select ename, length(ename)  from employee where eid=3;
select ename, length(ename) from employee;

-- 4) Add 1000 to salary
select salary + 1000 from employee;

-- 5)Subtract 500 from salary
select salary - 500 from  employee;

-- 6)Double the salary
select salary*2 from employee;

-- 7)Half the salary
select salary/2 from employee;

-- 8)Round salary to nearest thousand
-- (-3) used to reprensent value at 1000 place
select round(salary, -3) from employee;

-- 9)Truncate salary to nearest hundred
select round(salary, -2) from employee;

-- 10) concat name with department
select concat(ename ,'-' ,dept)from employee;
select concat(ename ,' ','works in',' ' ,dept)from employee;

--  String Formatting and Replacement
-- 11)Get first 3 characters of name
select substr(ename, 1,3) from employee;

-- 12)Replace character in name
select replace(ename, 'a','e') from employee;

-- 13)Find number of days since hire date
SELECT DATEDIFF(SYSDATE(), hiredate) AS days_since_hire
FROM employee
WHERE eid = 5;

-- 14)Find months between hire date and today
SELECT 
  (YEAR(SYSDATE()) - YEAR(hiredate)) * 12 + (MONTH(SYSDATE()) - MONTH(hiredate)) AS months_between
FROM employee;

-- 15)Find next Monday after hire date
SELECT 
  DATE_ADD(hiredate, INTERVAL ((9 - DAYOFWEEK(hiredate)) % 7) DAY) AS next_monday
FROM employee;

-- 16)Get month name from hire date
SELECT DATE_FORMAT(hiredate, '%M') AS month_name
FROM employee;

-- 17)Format salary with decimal places
select format(salary, 2) as formatted_sal from employee;

-- 18)Capitalize first letter of name
SELECT CONCAT(UPPER(LEFT(ename, 1)), LOWER(SUBSTRING(ename, 2))) AS capitalized_name
FROM employee;

-- 19)Pad name on left with '*'
select lpad(ename,10,'*') from employee;

-- 20)Pad name on right with '#'
select rpad(ename,10,'#');

-- ASCII, Date, Like, Between
-- 21)Get ASCII value of first character of name

SELECT ASCII(SUBSTRING(ename, 1, 1)) AS ascii_value
FROM employee;

select ename,ascii(substr(ename,1,1)) as ascii_val from employee;

-- 22)Get character for ASCII value 65
SELECT CHAR(65) AS character_result;

-- 23)Truncate hire date to year
-- return the first day of the same year (like '2020-01-01' if the hiredate is '2020-02-12').
SELECT 
  MAKEDATE(YEAR(hiredate), 1) AS hire_year_start
FROM employee;


-- 24)Round hire date to nearest month
SELECT 
  CASE 
    WHEN DAY(hiredate) <= 15 THEN DATE_FORMAT(hiredate, '%Y-%m-01')
    ELSE DATE_FORMAT(DATE_ADD(hiredate, INTERVAL 1 MONTH), '%Y-%m-01')
  END AS rounded_month
FROM employee;

-- 25)Extract year from hire date
select extract(year from hiredate) from employee;

-- 26)Extract month from hire date
select extract(month from hiredate) from employee;

-- 27)Extract day from hire date
select extract(day from hiredate) from employee;

-- 28)Check if salary is between 20000 and 50000
select ename, salary between 20000 and 50000 from employee;

-- 29)Check if name starts with 'S'
select ename, ename like 'S%' from employee;

-- 30)Get absolute difference from 30000
select ename, abs(salary -30000) from employee;

--  Math, String, Subqueries
-- 31)Square of salary
select power(salary,2) from employee;

-- 32)Find remainder when salary is divided by 5000
SELECT salary, MOD(salary, 5000) AS remainder
FROM employee;

-- 33)Concatenate name with salary message
select concat(ename,'  ','earns ₹', salary) from employee;

-- 34)Find department of specific employee
select dept from employee where ename="Abhi";

-- 35)Find salary of specific employee
select salary from employee where ename="Shrisha";

-- 36)Find name of employee with highest salary
select ename from employee where salary=(select max(salary) from employee);

-- 37)Find name of employee with lowest salary
select ename from employee where salary=(select min(salary) from employee);

-- 38)Format hire date as DD-MM-YYYY
select date_format(hiredate,'%d-%m-%y') from employee;

-- 39)List names of employees in 'Tester' department
select ename from employee where dept='Tester';

-- 40)Increase salary by 1000 for specific employee
select ename, salary+1000 from employee;


-- ID, Formatting, Bonus, Experience
-- 41)Find EID of employee named 'Abhi'
select eid from employee where ename= substr('Abhi',1,4) ;

-- 42)Convert department to uppercase
select upper(dept) from employee;

-- 43)Find employees hired after 2021
select * from employee where hiredate >'2021-01-01';

-- 44)Calculate 10% bonus on salary
select ename,salary, salary+salary*0.010 as bonus from employee;

-- 45)Calculate total pay after 10% bonus
select sum(salary+salary*0.010) as TOTAL_SALARY from employee;

-- 46)Find length of department name
select dept, length(dept) from employee;

-- 47)Capitalize first letter of department
SELECT 
  CONCAT(UPPER(LEFT(dept, 1)), LOWER(SUBSTRING(dept, 2))) AS capitalized_dept
FROM employee;


-- 48)Get first 5 characters of department
select dept, substr(dept,1,5) from employee;

-- 49)Add 1 year to hire date
select hiredate, hiredate+1 from employee;

-- 50)Calculate years of experience (rounded)
SELECT hiredate,ROUND(datediff(SYSDATE(), hiredate)/365) AS years_worked FROM employee ;
-- ------------------------------------------------------------------------- 


-- 4) Show todays date
select sysdate() from employee;


-- 7) Add 10 days to joining date.
-- it will add 10 days in your existing dates
select hiredate + 10 from employee where eid=5;




-- 10) Replace a with e in name
select replace(ename,'a','e') from employee;

-- 11) concate employee name and department
SELECT ename || ' - ' || dept FROM employee WHERE eid = 4;

-- 12) Get ASCII vaue of fiest character in name
select ascii(substr(ename,1,1)) from employee;


