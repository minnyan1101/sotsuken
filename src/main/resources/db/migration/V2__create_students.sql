create table students (
    id bigserial primary key,
    name text not null,
    class_id bigint references classes(id) not null
)