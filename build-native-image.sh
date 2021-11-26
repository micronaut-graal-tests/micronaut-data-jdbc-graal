#!/bin/bash
./gradlew nativeCompile
cp build/native/nativeCompile/data-jdbc-h2 .
