FROM postgres:9.4

ENV POSTGRES_USER=jooq
ENV POSTGRES_PASSWORD=jOOQ@postgresql
ENV POSTGRES_DB=jooq

COPY create_table_user.sh /docker-entrypoint-initdb.d
