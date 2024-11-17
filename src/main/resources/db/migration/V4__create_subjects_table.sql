CREATE TABLE subjects(
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    detail TEXT NOT NULL,
    start_date DATE NOT NULL,
    finish_date DATE NOT NULL,
    teacher_id BIGINT REFERENCES teachers(id),
);