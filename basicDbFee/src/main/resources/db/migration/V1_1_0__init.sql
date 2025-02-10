drop table if exists transaction cascade;

create table transaction
(
    id  serial primary key,
    fee DECIMAL(10,2) NOT NULL
);

insert into transaction(id, fee)
values (1, '1.1');
insert into transaction(id, fee)
values (2, '2.2');
insert into transaction(id, fee)
values (3, '3.3');
