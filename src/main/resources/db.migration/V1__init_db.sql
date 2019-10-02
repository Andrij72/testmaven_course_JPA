CREATE TABLE user_table
(
    id           BIGSERIAL   NOT NULL
        CONSTRAINT user_table_pk
            PRIMARY KEY,
    created_date BIGINT,
    login        VARCHAR(64) NOT NULL,
    name         VARCHAR(32) NOT NULL,
    age          BIGINT      NOT NULL,
    role         VARCHAR(32)
);

CREATE TABLE course
(
    id           BIGSERIAL NOT NULL
        CONSTRAINT table_name_pk
            PRIMARY KEY,
    created_date BIGINT,
    name         VARCHAR(255),
    cost         BIGINT
);

CREATE TABLE section
(
    id           BIGSERIAL NOT NULL
        CONSTRAINT section_pk
            PRIMARY KEY,
    created_date BIGINT,
    name         VARCHAR(255),
    comment       VARCHAR(1024),
    course_id    BIGINT NOT NULL
);
-- relation ManyOne
ALTER TABLE section
    ADD CONSTRAINT fk_section_id FOREIGN KEY (course_id) REFERENCES course (id);

DROP TABLE IF EXISTS lesson;
create table lesson
(
    id           BIGSERIAL NOT NULL
        CONSTRAINT lesson_pk
            PRIMARY KEY,
    created_date BIGINT,
    name         VARCHAR(255),
    section_id   BIGINT NOT NULL
);

-- relation ManyOne
ALTER TABLE lesson
    ADD CONSTRAINT fk_lesson_id FOREIGN KEY (section_id) REFERENCES section (id);

DROP TABLE IF EXISTS comment;
CREATE TABLE comment
(
    id           BIGSERIAL not null
        constraint comment_pk
            primary key,
    created_date BIGINT,
    author_id    BIGINT NOT NULL,
    lesson_id    BIGINT NOT NULL,
    content      VARCHAR(1024)
);

-- relation tables comment and lesson
ALTER TABLE comment
    ADD CONSTRAINT fk_comment_id FOREIGN KEY (lesson_id) REFERENCES lesson (id);
