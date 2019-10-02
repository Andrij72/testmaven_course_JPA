ALTER TABLE course
    ADD begin_date BIGINT;

ALTER TABLE course
    ADD end_date BIGINT;

ALTER TABLE user_table
    ADD active BOOLEAN;

alter table user_table
    add progress jsonb;