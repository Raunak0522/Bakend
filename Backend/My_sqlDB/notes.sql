show databases;
create database [dbname];
drop database [db name];
use [dbname];
show tables;

--create tables--
create table students(colnams datatype(size) extra);
--varchar>> string
--int

--show tables;
show tables;

---describe database;
desc students; 

--add column
alter table [tablename] ADD [column_name] datatype;

--update
alter table [tablename] MODIFY [column_name] datatype;

---Rename column
alter table [tablename] RENAME COLUMN [oldcolname] TO [newColnamwe];

--drop
alter table [tablename] DROP COLUMN [colname];

--insert
insert into[tablename] (id,city,name) values (12,"virat","delhi");

--update 
update [tablename] set address ="lko",name="Virat" where id=" ";

--delete 
delete from [tablename] where id=" ";


--order by