create table subjects_students (
    subject_id bigint not null references subjects(id),
    joined_students_id text not null references students(id)
)