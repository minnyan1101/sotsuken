create table attendances (
    id bigserial primary key,
    lecture_id bigint references lectures(id) not null,
    state text not null,
    isLateness boolean not null,
    isLeaveEarly boolean not null
)