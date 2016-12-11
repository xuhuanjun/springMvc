drop table tb_demo;
create table
tb_demo(
        id INT not null generated always as identity,
        name VARCHAR(30) not null);
insert into tb_demo(name) values('xuhuanjun');
insert into tb_demo(name) values('xhj');
insert into tb_demo(name) values('xuhj');