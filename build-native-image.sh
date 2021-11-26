#!/bin/bash
./gradlew nativeImage
cp build/native/nativeCompile/data-jdbc-h2 .
