CREATE TABLE author (
  id              BIGINT(7)     NOT NULL PRIMARY KEY,
  first_name      VARCHAR(50)   NOT NULL,
  last_name       VARCHAR(50)   NOT NULL,
  date_of_birth   DATE,
  year_of_birth   BIGINT(7)
);

CREATE TABLE book (
  id              BIGINT(7)     NOT NULL PRIMARY KEY,
  author_id       BIGINT(7)     NOT NULL,
  title           VARCHAR2(400) NOT NULL
);
