create table departments (
    department varchar(100),
    division varchar(100),
    primary key (department)
  );



create table regions (
   region_id int,
   region varchar(20),
   country varchar(20),
   primary key (region_id)
  );



create table employees (
	employee_id INT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	email VARCHAR(50),
	hire_date DATE,
	department VARCHAR(17),
	gender VARCHAR(1),
	salary INT,
	region_id INT,
	primary key (employee_id)
);
