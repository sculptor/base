#!/bin/bash
PACKAGE="org/fornax/cartridges/sculptor/smartclient/server/jsparser"

export CLASSPATH=.:/home/tavoda/opt/antlr/antlr-3.1.2.jar:/home/roman/download/antlr-3.1.2.jar

java org.antlr.Tool JavaScriptData.g

rm -rf org
mkdir -p $PACKAGE
cp *.java $PACKAGE

javac $PACKAGE/*.java
java `echo "$PACKAGE" | tr / .`.JavaScriptDataParser
rm -rf org
