CREATE TABLE lectures (
    id BIGSERIAL PRIMARY KEY,
    subject_id BIGINT NOT NULL REFERENCES subjects(id),
    start_date DATE NOT NULL,
    periods INT,
    join_code BIGINT NOT NULL
)