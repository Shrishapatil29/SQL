use exp4;

CREATE TABLE departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50)
);
INSERT INTO departments (dept_id, dept_name) VALUES
(1, 'HR'),
(2, 'Finance'),
(3, 'IT'),
(4, 'Marketing');

CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
);
INSERT INTO employees (emp_id, emp_name, dept_id) VALUES
(101, 'Alice', 1),
(102, 'Bob', 2),
(103, 'Charlie', 3),
(104, 'David', 2),
(105, 'Eva', 4);

-- Write a query to fetch employee names along with their department names using an INNER JOIN.
SELECT e.emp_name, d.dept_name
FROM employees e
INNER JOIN departments d ON e.dept_id = d.dept_id;

-- Display all employees including those who do not belong to any department using a LEFT JOIN.
SELECT e.emp_name, d.dept_name
FROM employees e
LEFT JOIN departments d ON e.dept_id = d.dept_id;

-- Show all departments, even those that have no employees using a RIGHT JOIN.
SELECT e.emp_name, d.dept_name
FROM employees e
RIGHT JOIN departments d ON e.dept_id = d.dept_id;

-- Get the list of employees and departments whether matched or not (FULL OUTER JOIN).
-- Part 1: Get all employees with matching departments (or NULL if no match)
SELECT e.emp_name, d.dept_name
FROM employees e
LEFT JOIN departments d ON e.dept_id = d.dept_id

UNION

-- Part 2: Get all departments with matching employees (or NULL if no match)
SELECT e.emp_name, d.dept_name
FROM employees e
RIGHT JOIN departments d ON e.dept_id = d.dept_id;

-- Write a query to display all combinations of employees and departments using CROSS JOIN
SELECT e.emp_name, d.dept_name
FROM employees e
CROSS JOIN departments d;

-- Fetch employee names along with their manager names using SELF JOIN.
CREATE TABLE employees1 (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    manager_id INT
);

INSERT INTO employees1 (emp_id, emp_name, manager_id) VALUES
(101, 'Alice', NULL),     
(102, 'Bob', 101),       
(103, 'Charlie', 101),   
(104, 'David', 102),      
(105, 'Eva', 102);       

SELECT 
    e.emp_name AS employee,
    m.emp_name AS manager
FROM 
    employees1 e
LEFT JOIN 
    employees1 m ON e.manager_id = m.emp_id;

DROP TABLE IF EXISTS employees1;

-- 7)Display the department names that have no employees.
SELECT d.dept_name
FROM departments d
LEFT JOIN employees e ON d.dept_id = e.dept_id
WHERE e.emp_id IS NULL;


-- Write a query to list employees who earn more than the average salary in their department using JOIN + subquery.
ALTER TABLE employees
ADD COLUMN salary INt;
set SQL_SAFE_UPDATE=1;

UPDATE employees SET salary = 40000 WHERE emp_id = 101;
UPDATE employees SET salary = 50000 WHERE emp_id = 102;
UPDATE employees SET salary = 60000 WHERE emp_id = 103;
UPDATE employees SET salary = 30000 WHERE emp_id = 104;
UPDATE employees SET salary = 35000 WHERE emp_id = 105;


SELECT * FROM employees;

SELECT e.emp_name, e.salary, d.dept_name
FROM employees e
JOIN departments d ON e.dept_id = d.dept_id
WHERE e.salary > (
    SELECT AVG(e2.salary)
    FROM employees e2
    WHERE e2.dept_id = e.dept_id
);

-- 9)Show employees whose department name starts with ‘S’ using JOIN.
update departments
set dept_name="Sales"
where dept_id=4;
 
SELECT e.emp_name, d.dept_name
FROM employees e
JOIN departments d ON e.dept_id = d.dept_id
WHERE d.dept_name LIKE 'S%';

select * from departments;

-- List employees along with their department names and job titles (using JOIN across three tables).
-- Drop if exists (optional)
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;
DROP TABLE IF EXISTS jobs;

-- Departments table
CREATE TABLE departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50)
);

-- Jobs table
CREATE TABLE jobs (
    job_id INT PRIMARY KEY,
    job_title VARCHAR(50)
);

-- Employees table
CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    manager_id INT,
    dept_id INT,
    job_id INT,
    salary INT
);

-- Insert into departments
INSERT INTO departments VALUES
(1, 'HR'),
(2, 'Finance'),
(3, 'Sales');

-- Insert into jobs
INSERT INTO jobs VALUES
(101, 'Manager'),
(102, 'Analyst'),
(103, 'Clerk');

-- Insert into employees
INSERT INTO employees VALUES
(201, 'Alice', NULL, 1, 101, 60000),
(202, 'Bob', 201, 2, 102, 45000),
(203, 'Charlie', 201, 3, 103, 35000);

SELECT 
  e.emp_name,
  d.dept_name,
  j.job_title
FROM employees e
JOIN departments d ON e.dept_id = d.dept_id
JOIN jobs j ON e.job_id = j.job_id;



drop table employees; 

