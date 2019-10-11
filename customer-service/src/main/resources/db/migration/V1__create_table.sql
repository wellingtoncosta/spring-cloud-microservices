create table customer(
    id bigserial primary key,
    name varchar(255) not null,
    address varchar(255) not null,
    email varchar(255) not null,
    phone varchar(255) not null
);
