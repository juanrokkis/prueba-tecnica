FROM postgres:latest

ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_DB audit

ADD init.sql /docker-entrypoint-initdb.d/