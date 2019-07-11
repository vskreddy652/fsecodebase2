# Starting with Docker base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Added Maintainer Info here. Details of Anshul Gautam
LABEL maintainer="anshulgammy@outlook.com"

# Added a volume
VOLUME user-datavolume:/volume/data/user

# This application will be accessible from port 7701 outside the container.
EXPOSE 7701

# Copying the jar file to workdir
COPY ./target/giveaway-usermanagement.jar /usr/app/

# Defined WORKDIR
WORKDIR /usr/app

# executing the jar file here...
ENTRYPOINT ["java","-jar","giveaway-usermanagement.jar"]  