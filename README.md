# Micronaut Data JDBC Graal #

Test application for Micronaut Data JDBC and GraalVM that uses MariaDB.

To run MariaDB in Docker:
```
docker run -p 3306:3306 -it --rm -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_DATABASE=pets mariadb:10.4.8-bionic
```

To test the application:

```
curl localhost:8080/owners
curl localhost:8080/owners/Fred

curl localhost:8080/pets
curl localhost:8080/pets/Dino
```
