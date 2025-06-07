create  database Emp2;
use Emp2;

create table Employee
(Emp_id int auto_increment primary key,
Emp_name varchar(20) not null,
Email varchar(20) unique,
Salary int check(Salary>5000),
Join_date datetime default current_timestamp);

insert into Employee(Emp_name,Email,Salary,join_date)
values ("Shrisha", "Shri@gmail.com",14000,current_date());

insert into Employee(Emp_name,Email,Salary,join_date)
values ("Sourabh", "sou@gmail.com",40000,current_date());

insert into Employee(Emp_name,Email,Salary,join_date)
values ("Abhishek", "Abhi@gmail.com",12000,current_date());

insert into Employee(Emp_name,Email,Salary,join_date)
values ("Sakshi", "sakshi@gmail.com",32000,current_date());

select* from EmployeeRecords ;

drop table Employee;

alter table Employee add column Bonus float default 0;

alter table employee modify column Emp_name varchar(50);

ALTER TABLE Employee ADD basic_salary INT;
SET SQL_SAFE_UPDATES = 0;
UPDATE Employee SET basic_salary = Salary;
ALTER TABLE Employee DROP COLUMN Salary;
ALTER TABLE Employee ADD CONSTRAINT chk_basic_salary CHECK (basic_salary > 5000);


rename table Employee to EmployeeRecords ;
alter table EmployeeRecords drop column Bonus;

INSERT INTO EmployeeRecords (Emp_name, Email, basic_salary, Join_date)
SELECT 'Sourabh', 'sou@gmail.com', 15000, CURRENT_TIMESTAMP
FROM DUAL
WHERE NOT EXISTS (
    SELECT 1 FROM EmployeeRecords WHERE Email = 'sou@gmail.com'
);

INSERT INTO employeerecords (Emp_name, Email, basic_salary, Join_date)
SELECT 'Abc', 'abc@gmail.com', 15000, CURRENT_TIMESTAMP
FROM DUAL
WHERE NOT EXISTS (
    SELECT 1 FROM employeerecords WHERE Email = 'abc@gmail.com'
);

update EmployeeRecords
set basic_salary=basic_salary+(basic_salary*0.015);

DELETE FROM employeerecords
WHERE join_date < DATE_SUB(CURDATE(), INTERVAL 5 YEAR);

select * from employeerecords;
