./gradlew assemble
native-image --no-server --no-fallback --class-path build/libs/micronaut-data-jdbc-graal-*-all.jar
