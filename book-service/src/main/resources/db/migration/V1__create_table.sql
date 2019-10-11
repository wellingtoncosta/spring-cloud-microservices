create table book(
    id bigserial primary key,
    author varchar(255) not null,
    title varchar(255) not null,
    description text,
    status smallint not null default 0
);