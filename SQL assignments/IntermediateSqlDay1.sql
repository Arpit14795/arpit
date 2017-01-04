select to_char(salary,'$99,999.99') from employee;

select to_date('03-JAN-2015','DD-MON-YYYY') from dual;

select to_number('$15,000','$99,999') from dual;

select employeeid,firstname,jobid,salary, 
Case jobid
when 'IT_REP' then salary+2000
when 'SALES_REP' then salary+500
End "calc salary"
from employee;

select min(salary),max(salary) from employee;

select min(hiredate),max(hiredate) from employee;

select avg(salary),trunc(avg(salary),2) from employee;

select count(*) from employee;

select count(employeeid) from employee;

select count(manager_id) from employee;

select * from employee;

select department_id ,count(employeeid),sum(salary)
from employee
Group by department_id;


select department_id,jobid ,count(employeeid),sum(salary)
from employee
Group by department_id; //erorr all selected must be in group by


select department_id,jobid ,count(employeeid),sum(salary)
from employee
Group by department_id,jobid;


select department_id,jobid ,count(employeeid),sum(salary)
from employee
-- we can use where clause for row level filter here
Group by department_id,jobid
-- having for group level filter
having sum(salary)>=40000
-- sorting order by
order by sum(salary);


select department_id,jobid ,count(employeeid),sum(salary)
from employee
where salary>30000
Group by department_id,jobid
-- having for group level filter
having sum(salary)>=40000
-- sorting order by
order by sum(salary);


--Combining data 
-- Set Operators
-- Joins
--Ineer  join
select * from employee;
select employeeid,firstname,salary,e.department_id,department_name
from employee e,Department d
where e.department_id=d.department_id;
--Now Outer Join
--oracle proprietory(+)
--left and right->
select * from employee;
select employeeid,firstname,salary,e.department_id,department_name
from employee e,Department d
where e.department_id=d.department_id(+);
select * from department;

--Ansi outer join
--normal inner join

select employeeid,firstname,salary,e.department_id,department_name
from employee e Join Department d
on e.department_id=d.department_id;

--left
select * from employee;
select employeeid,firstname,salary,e.department_id,department_name
from employee e left outer join Department d
on e.department_id=d.department_id;
--right
select employeeid,firstname,salary,e.department_id,department_name
from employee e right outer join Department d
on e.department_id=d.department_id;

--full outer join
select employeeid,firstname,salary,e.department_id,department_name
from employee e full outer join Department d
on e.department_id=d.department_id;
--Cartesian product
select employeeid,firstname,salary,e.department_id,department_name
from employee e , Department d

--Self join:-
--joining same table to itself

select e1.employeeid,e1.firstname,e1.manager_id,e2.firstname ManagerName
from employee e1,employee e2
where e1.manager_id= e2.employeeid;
--self + outer
select e1.employeeid,e1.firstname,e1.manager_id,e2.firstname ManagerName
from employee e1,employee e2
where e1.manager_id= e2.employeeid(+);

--sub query
--query within query

--display all employee whose salary > james's salry
--Nested sub query
select * from employee where salary>=(select salary from employee where firstname='ajay');

--single row operator > < >=<= = <>
--multiple row operator IN ANY ALL

--display all employee details who earn same as min salary in each department
select * from employee 
where salary in(
select min(salary) from employee 
group by department_id);

--display all employee details whose salary > any of the employee in dept_id=20

select * from employee where salary > ANY(
select salary from employee where department_id=20);


--display all employee details whose salary > all of the employee in dept_id=20

select * from employee where salary > All(
select salary from employee where department_id=20);

--Correlated sub query
--outer query executes first
--then inner query exxecutes
--Inner query referes some column from outer query table
--thats why inner can't executes on its own


--to display all employee details who earn more than avg salary in their own dept

select e.employeeid,e.salary,e.department_id
from employee e
where salary > (Select avg(salary) from employee d
                where d.department_id=e.department_id); 

--exists and not exists in correlated query

--display all dept details that do not contain any employee

select * from department
where department_id not in(select department_id from employee where department_id is not null);
--performance wise better co-related query:-
select * from department d
where not exists(select * from employee e
                  where e.department_id=d.department_id); 
