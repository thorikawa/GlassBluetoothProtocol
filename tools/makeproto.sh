#!/bin/sh

${PROTOC} -I=proto/ --javanano_out=generate_equals=true,optional_field_style=reftypes,enum_style=java:src/main/java proto/timeline.proto proto/glass.proto
