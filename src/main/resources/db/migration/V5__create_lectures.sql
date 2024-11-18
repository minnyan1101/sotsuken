create table lectures (
    id bigserial primary key,
    subject_id bigint references subjects(id) not null,
    start_date date not null,
    periods bigint not null,
    join_code bigint not null
)