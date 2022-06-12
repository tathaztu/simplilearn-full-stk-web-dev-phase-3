drop table if exists todos;

create table todos (id bigint not null auto_increment, username varchar(45), description varchar(45), targetdate datetime, isdone boolean, primary key (id));