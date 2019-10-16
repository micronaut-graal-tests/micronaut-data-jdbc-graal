# Micronaut Data JDBC Graal #

Test application for Micronaut Data JDBC and GraalVM that uses Postgres.

To run Postgres in Docker:
```
docker run -it --rm -p 5432:5432 -e POSTGRES_PASSWORD=secret -e POSTGRES_DB=pets postgres:11.5-alpine
```

To test the application:

```
curl localhost:8080/owners
curl localhost:8080/owners/Fred

curl localhost:8080/pets
curl localhost:8080/pets/Dino
```
