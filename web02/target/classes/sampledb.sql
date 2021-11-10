
insert into sample(id,title,reg_user,content,reg_date) values('sample-01000','스프링','홍길동','스프링',sysdate)
select * from tab;
select * from sample
delete from sample where id='sample-01003'
select nvl(max(id),0)+1 from SAMPLE;
create table sample(
id varchar2(12) primary key,
title varchar2(200),
reg_user varchar2(20),
content varchar2(2000),
reg_date date default sysdate
);

drop table sample;

insert into sample values('sample-00001','JAVA Programming','관리자','java관련 글만 등록하세요.',sysdate);

select * from sample;
select * from ids;
create table ids(
table_name varchar2(16) primary key,
next_id number(30) not null);

insert into ids values('sample',2);