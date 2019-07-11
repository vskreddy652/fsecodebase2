# Starting with Docker base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Added Maintainer Info here. Details of Anshul Gautam
LABEL maintainer="anshulgammy@outlook.com"

# Added a volume
VOLUME eureka-datavolume: /volume/data/eureka

# This application will be accessible from port 7707 outside the container.
EXPOSE 7707

# Copying the jar file to workdir
COPY ./target/giveaway-eureka-server.jar /usr/app/

# Defined WORKDIR
WORKDIR /usr/app/

# executing the jar file here...
ENTRYPOINT ["java","-jar","giveaway-eureka-server.jar"]