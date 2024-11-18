create table subjects (
    id bigserial primary key,
    name text not null,
    detail text not null,
    start_date date not null,
    finish_date date not null,
    teacher_id text references teachers(id) not null
)