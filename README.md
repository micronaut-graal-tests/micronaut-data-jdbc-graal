# Micronaut Data JDBC Graal #

Test application for Micronaut Data JDBC and GraalVM that uses SQL Server.

To run SQL Server in Docker:
```
docker run -it --rm -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=My!Secret123' -e 'MSSQL_PID=Express' -p 1433:1433 mcr.microsoft.com/mssql/server:2017-latest-ubuntu
```

To test the application:

```
curl localhost:8080/owners
curl localhost:8080/owners/Fred

curl localhost:8080/pets
curl localhost:8080/pets/Dino
```
