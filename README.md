# Micronaut Data JDBC Graal #

Test application for Micronaut Data JDBC and GraalVM that uses Oracle.

To run Oracle in Docker:
```
docker run -it --rm -p 1521:1521 -e ORACLE_PASSWORD=oracle gvenzl/oracle-xe:18.4.0-slim
```

To test the application:

```
curl localhost:8080/owners
curl localhost:8080/owners/Fred

curl localhost:8080/pets
curl localhost:8080/pets/Dino
```
