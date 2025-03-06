create or replace table java.users
(
    id    int auto_increment
        primary key,
    email varchar(128) null,
    constraint users_email_pk
        unique (email)
);
