create table students (
    id text primary key,
    name text not null,
    class_id bigint references classes(id) not null
)