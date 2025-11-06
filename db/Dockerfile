FROM mysql:8.0
ENV MYSQL_DATABASE=world
ENV MYSQL_ROOT_PASSWORD=example
ENV MYSQL_ROOT_HOST=%

COPY world_db/world.sql /docker-entrypoint-initdb.d/world.sql
