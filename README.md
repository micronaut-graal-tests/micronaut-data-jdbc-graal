# Micronaut Data JDBC Graal #

Test application for Micronaut Data JDBC and GraalVM that uses MySQL.

To run MySQL in Docker:
```
docker run -it --rm -p 3306:3306 -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_DATABASE=pets mysql:8.0.20
```

To test the application:

```
curl localhost:8080/owners
curl localhost:8080/owners/Fred

curl localhost:8080/pets
curl localhost:8080/pets/Dino
```
