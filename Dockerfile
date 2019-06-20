FROM tomcat:9.0
MAINTAINER Yaroslav

COPY ./build/libs/ITCompany-release.war /usr/local/tomcat/webapps/