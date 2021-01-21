./gradlew assemble
native-image --no-fallback --class-path build/libs/micronaut-data-jdbc-graal-*-all.jar
