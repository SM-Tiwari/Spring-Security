#!/bin/sh

APP_HOME=/opt/fcmclient
JAR_FILE=$APP_HOME/vnm-selfcare-fcm-client-1.0.jar

APP_OPTS="--spring.config.location=$APP_HOME/config/application.properties  --logging.config=$APP_HOME/config/logback.xml"
JAVA_OPTS="-Xms512m -Xmx1024m -Xss256k -server"

java $JAVA_OPTS -jar $JAR_FILE $APP_OPTS > /dev/null 2>&1 &
