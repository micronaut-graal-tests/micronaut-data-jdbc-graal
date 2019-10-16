# Micronaut Data JDBC Graal #

Test application for Micronaut Data JDBC and GraalVM that uses Oracle.

To run Oracle in Docker:
```
docker run -it --rm -p 1521:1521 wnameless/oracle-xe-11g-r2
```

To test the application:

```
curl localhost:8080/owners
curl localhost:8080/owners/Fred

curl localhost:8080/pets
curl localhost:8080/pets/Dino
```
