FROM tomcat:9.0.39-jdk8-openjdk-buster
LABEL maintainer=<dasomell@gmail.com>

# WORKDIR /usr/local/tomcat
ADD ./target/egovframework-all-in-one.war /usr/local/tomcat/webapps/app.war

EXPOSE 8080