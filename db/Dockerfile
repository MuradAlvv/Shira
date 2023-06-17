FROM postgres:latest

ENV POSTGRES_PASSWORD 1234

COPY db/init.sql /docker-entrypoint-initdb.d/

EXPOSE 5432