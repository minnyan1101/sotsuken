create table subjects (
    id bigserial primary key,
    name text not null,
    detail text not null,
    startDate date not null,
    finishDate date not null,
    teacher_id bigint references teachers(id) not null
)