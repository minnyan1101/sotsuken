CREATE TABLE students (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    class_id BIGINT NOT NULL REFERENCES classes(id),

);