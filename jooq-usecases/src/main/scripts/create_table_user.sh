#!/usr/bin/env bash

set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE TABLE author (
	  id              BIGSERIAL     NOT NULL PRIMARY KEY,
	  first_name      VARCHAR(50)   NOT NULL,
	  last_name       VARCHAR(50)   NOT NULL,
	  date_of_birth   DATE,
	  year_of_birth   BIGINT
	);

	CREATE TABLE book (
	  id              BIGSERIAL		 NOT NULL PRIMARY KEY,
	  author_id       BIGINT       NOT NULL,
	  title           VARCHAR(400) NOT NULL
	);
EOSQL

# vim:et:sw=4:ts=4:ft=sh
