FROM mysql:8

#var d'env
ENV MYSQL_DATABASE=test_persistence

#
COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 3306
