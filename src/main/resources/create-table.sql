drop table if exists t_user;
create table t_user(
 	id serial primary key,
 	name varchar(255),
 	password varchar(255),
 	type varchar(30),
 	credit integer,
 	mobile varchar(30),
 	locked boolean,
 	last_visit timestamp,
 	last_ip varchar(30)
)
select * from t_user;

drop table if exists t_order;
create table t_order(
 	id serial primary key,
    order_date timestamp,
    order_by integer references t_user (id),
    subtotal double precision,
    status varchar(30)
);
select * from t_order;

drop table if exists t_order_item;
create table t_order_item(
 	id serial primary key,
    order_id integer references t_order (id),
    course_id integer references t_course (id),
    quantity integer,
    unit_price double precision
);
select * from t_order_item;

drop table if exists t_expert;
create table t_expert(
	id serial primary key,
	name varchar(255),
	gender varchar(10),
	title varchar(255),
	hospital varchar(255),
	department varchar(255),
	speciality varchar(255),
	introduction varchar(1024),
	photo bytea
);
//insert into t_expert(name, title, department) values('孙思邈', '教授级专家', '骨科');
select * from t_expert;

drop table if exists t_course;
create table t_course(
    id serial primary key,
    name varchar(255),
    description varchar(255),
    price double precision,
    start_date timestamp,
    end_date timestamp,
    location varchar(255),
    sellable boolean
);
select * from t_course;

drop table if exists t_expert_course;
create table t_expert_course(
    expert_id integer references t_expert (id),
    course_id integer references t_course (id),
    primary key (expert_id, course_id)
)
select * from t_expert_course;

drop table if exists t_video;
create table t_video(
    id serial primary key,
    name varchar(255),
    description varchar(255),
    size integer,
    length double precision,
    path varchar(255)
);
select * from t_video;

drop table if exists t_video_course;
create table t_video_course(
    video_id integer references t_video (id),
    course_id integer references t_course (id),
    primary key (video_id, course_id)
)
select * from t_video_course;


