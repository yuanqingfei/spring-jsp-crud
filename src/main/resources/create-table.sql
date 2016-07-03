drop table if exists t_expert;

create table t_expert(
	id serial primary key,
	name varchar(255),
	title varchar(255),
	department varchar(255)
);
insert into t_expert(name, title, department) values('孙思邈', '教授级专家', '骨科');

drop table if exists t_user;
create table t_user(
 	id serial primary key,
 	name varchar(255),
 	password varchar(255),
 	type varchar(30),
 	locked boolean,
 	last_visit timestamp,
 	last_ip varchar(30)
)