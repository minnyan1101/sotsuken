create table accounts (
    user_name text primary key,
    password_hash text not null,
    account_type text not null
)