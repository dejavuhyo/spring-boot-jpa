create table member
(
    id    varchar(20) not null
        constraint member_pk
            primary key,
    name  varchar(20),
    email varchar(50)
);
