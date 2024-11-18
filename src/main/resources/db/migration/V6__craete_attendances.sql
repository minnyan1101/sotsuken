create table attendances (
    id bigserial primary key,
    lecture_id bigint references lectures(id) not null,
    student_id text references students(id) not null,
    state text not null,
    is_lateness boolean not null,
    is_leaveEarly boolean not null
)