# Student-Admission-System-SPRING-BOOT

Server:port:8080

Database Queries:

create table login(adminusername varchar(20) primary key, adminpassword varchar(20) not null, college_code varchar(5) not null);
insert into login values ("Dhanush","123","000");

create table colleges(college_code varchar(20) primary key,college_name varchar(20) not null);
insert into colleges values ("000","Admin");
