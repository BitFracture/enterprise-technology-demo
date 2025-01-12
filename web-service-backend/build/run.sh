#!/usr/bin/env bash

file_name=(`find "../wsb-application/target/" -type f -name "*.jar"`)
echo "Located JAR file at ${file_name}"
java -jar $file_name
