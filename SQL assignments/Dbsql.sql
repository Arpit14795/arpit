--Based on DbSQL schema
1.select upper(firstname), upper(last_name) from employee;
--Assuming tenure of 10 years from hiredate
2.select add_months(hiredate,120) Tenure_date from employee;
3.select distinct e.firstname, e.jobid, e.salary, d.department_name,l.city from employee e,department d,location l where e.department_id= d.department_id and d.locationid= l.locationid; 
4.select concat(concat(concat(concat(e.last_name,','),concat(e.jobid,',')),e.salary), concat(',',d.department_name)) Employee_details from employee e,department d where e.department_id= d.department_id;
5.select distinct e.firstname,d.department_name from employee e,department d,location l where e.department_id= d.department_id and d.locationid= l.locationid and l.city in ('Pune','Mumbai'); 
