#!/bin/bash
./gradlew nativeCompile
cp build/native/nativeCompile/data-jdbc-mariadb .
