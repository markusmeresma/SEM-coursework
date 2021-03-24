FROM mysql

WORKDIR /tmp

COPY world.sql/*.sql /tmp/

COPY world.sql/world.sql /docker-entrypoint-initdb.d

ENV MYSQL_ROOT_PASSWORD semcoursework