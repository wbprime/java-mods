# sudo podman build -t postgre_jooq .
# sudo podman run -d -p 5432:5432  --name jooq postgre_jooq
FROM postgres:9.4

ENV POSTGRES_USER=jooq
ENV POSTGRES_PASSWORD=jOOQ@postgresql
ENV POSTGRES_DB=jooq

COPY create_table_user.sh /docker-entrypoint-initdb.d
