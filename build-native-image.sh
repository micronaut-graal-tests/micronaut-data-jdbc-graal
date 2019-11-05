./gradlew assemble
native-image --no-server --no-fallback --static --class-path build/libs/micronaut-data-jdbc-graal-*-all.jar
