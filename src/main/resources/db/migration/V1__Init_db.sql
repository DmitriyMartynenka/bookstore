create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;

create table books
(
    id     bigint not null
        constraint books_pkey
            primary key,
    author varchar(255),
    price  double precision,
    title  varchar(255)
);

alter table books
    owner to postgres;

create table users
(
    id       bigint not null
        constraint users_pkey
            primary key,
    password varchar(255),
    username varchar(255)
);

alter table users
    owner to postgres;