create table reservation(
    id bigserial primary key,
    reserved_at date not null default current_date,
    returned_at date,
    book_id bigint not null,
    customer_id bigint not null
);
