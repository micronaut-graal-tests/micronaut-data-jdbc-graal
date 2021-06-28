#!/bin/bash
./gradlew nativeImage
cp build/native-image/data-jdbc-h2 .
