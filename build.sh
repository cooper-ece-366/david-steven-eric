#!/bin/bash

# TODO: Add in the application you will write below. That will be a folder under this current working directory
APPS="coopercars-service"

# First ensure dependencies loaded since .m2 may be empty
mvn dependency:tree -Ddetail=true
mvn help:evaluate -Dexpression=project.version

# Clean repo from builds
./clean.sh

#
# Config
#
THEUSER=$(/usr/bin/whoami)
NOW=$(date "+%Y%m%d%H%M%S")
APP_MAVEN_VERSION=$(mvn help:evaluate -Dexpression=project.version | grep -e '^[^\[]')
APP_GIT_VERSION=$(git rev-parse --abbrev-ref HEAD)

RESOURCES_DIR=./coopercars-service/src/main/resources
APP_PROP_FILE=${RESOURCES_DIR}/application.properties
APP_TEMPLATE_PROP_FILE=${RESOURCES_DIR}/application.properties-template
APP_VERSION_FILE=./app.version

APP_VERSION=${APP_MAVEN_VERSION}-${APP_GIT_VERSION}_${NOW}_${THEUSER}
echo ${APP_VERSION} > ${APP_VERSION_FILE}

[ -e ${APP_PROP_FILE} ] && rm ${APP_PROP_FILE}
cat ${APP_TEMPLATE_PROP_FILE} | sed -e "s/NOTFORMALLYBUILT/${APP_VERSION}/g" > ${APP_PROP_FILE}

echo "LOCALLY building runtime to local folder: ./build ..."
echo "Version = ${APP_VERSION}"

if [ ! -f "${APP_VERSION_FILE}" ]; then
    echo "APP Version file DOES NOT exist. CANNOT proceed with build."
    exit 1
fi

#
# Config
#
APP_VERSION=$(cat ${APP_VERSION_FILE})

#mvn test
mvn install -Dmaven.test.skip=true
mvn package -N -P classpath-deps -Dmaven.test.skip=true

# Package runtimes with compiled and built libraries
#for APP in $APPS
#do
#	echo "Building $APP ..."
#	cd ./$APP
#	./build_app.sh
#	echo "Built $APP"
#	cd ..
#done

#echo "Copying job scripts for at scheduling to build/app/ ..."
#cp ./cicd/deploy.sh ./build/app/
#cp ./app/opt/start_app.sh ./build/app/
#echo "Done."

echo "Done building APP."
